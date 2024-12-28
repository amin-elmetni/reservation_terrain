package com.example.terrain_management.service;

import com.example.terrain_management.dto.UtilisateurDto;
import com.example.terrain_management.entity.Client;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.ClientTypeEnum;
import com.example.terrain_management.enums.RoleEnum;
import com.example.terrain_management.enums.VilleEnum;
import com.example.terrain_management.mapper.UtilisateurMapper;
import com.example.terrain_management.repository.ClientRepository;
import com.example.terrain_management.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository utilisateurRepository,
                              ClientRepository clientRepository,
                              PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UtilisateurDto> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDto getUtilisateurById(Integer id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        return UtilisateurMapper.toDto(utilisateur);
    }

    public Utilisateur findUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public Utilisateur createUtilisateur(UtilisateurDto utilisateurDto) {
        if (utilisateurDto.getPassword() == null || utilisateurDto.getPassword().isEmpty()) {
            throw new RuntimeException("Le mot de passe est obligatoire");
        }

        Utilisateur utilisateur = UtilisateurMapper.toEntity(utilisateurDto);

        // Encoder le mot de passe avant de sauvegarder
        utilisateur.setPassword(passwordEncoder.encode(utilisateurDto.getPassword()));

        utilisateur = utilisateurRepository.save(utilisateur);

        // Si l'utilisateur est un CLIENT, créer également un enregistrement dans la table Client
        if (utilisateurDto.getRole() == RoleEnum.CLIENT) {
            Client client = new Client();
            client.setUtilisateur(utilisateur);
            client.setTypeClient(ClientTypeEnum.INDIVIDU); // Par défaut ou à définir depuis l'utilisateur DTO
            client.setNomOrganisation(null); // À adapter si nécessaire
            client.setDocumentAssociation(null); // À adapter si nécessaire
            clientRepository.save(client);
        }

        return utilisateur;
    }

    public UtilisateurDto updateUtilisateur(Integer id, UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setTelephone(utilisateurDto.getTelephone());
        utilisateur.setRole(utilisateurDto.getRole());
        utilisateur.setVille(utilisateurDto.getVille() != null ? VilleEnum.valueOf(utilisateurDto.getVille()) : null); // Conversion String -> enum

        return UtilisateurMapper.toDto(utilisateurRepository.save(utilisateur));
    }


    public void deleteUtilisateur(Integer id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur not found");
        }
        utilisateurRepository.deleteById(id);
    }
}
