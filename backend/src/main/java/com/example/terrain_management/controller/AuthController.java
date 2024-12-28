package com.example.terrain_management.controller;

import com.example.terrain_management.dto.AuthRequest;
import com.example.terrain_management.dto.AuthResponse;
import com.example.terrain_management.dto.ClientDto;
import com.example.terrain_management.entity.Client;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.RoleEnum;
import com.example.terrain_management.mapper.ClientMapper;
import com.example.terrain_management.repository.ClientRepository; // Import nécessaire
import com.example.terrain_management.repository.UtilisateurRepository;
import com.example.terrain_management.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UtilisateurRepository utilisateurRepository;
    private final ClientRepository clientRepository; // Ajout du ClientRepository

    // Modifiez le constructeur pour inclure le ClientRepository
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UtilisateurRepository utilisateurRepository, ClientRepository clientRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.utilisateurRepository = utilisateurRepository;
        this.clientRepository = clientRepository; // Injection du ClientRepository
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        // Authentifier l'utilisateur
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        // Trouver l'utilisateur à partir de l'email
        Utilisateur utilisateur = utilisateurRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Génération du token
        String token = jwtUtil.generateToken(utilisateur.getEmail(), utilisateur.getRole().name());

        // Inclure les données client si l'utilisateur est un CLIENT
        ClientDto clientDto = null;
        if (utilisateur.getRole() == RoleEnum.CLIENT) {
            Client client = clientRepository.findByUtilisateurId(utilisateur.getId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            clientDto = ClientMapper.toDto(client); // Convertir en DTO pour retourner au frontend
        }

        // Log pour vérifier le retour
        System.out.println("Token généré : " + token);
        System.out.println("Utilisateur trouvé : " + utilisateur);

        // Retourner une réponse enrichie
        return new AuthResponse(
                token,
                utilisateur.getRole().name(),
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getEmail(),
                utilisateur.getTelephone(),
                utilisateur.getVille() != null ? utilisateur.getVille().name() : null,
                clientDto // Ajout des données client si elles existent
        );
    }
}
