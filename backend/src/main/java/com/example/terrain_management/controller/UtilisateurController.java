package com.example.terrain_management.controller;

import com.example.terrain_management.dto.UtilisateurDto;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<UtilisateurDto> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable Integer id) {
        return ResponseEntity.ok(utilisateurService.getUtilisateurById(id));
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        return ResponseEntity.ok(utilisateurService.createUtilisateur(utilisateurDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUtilisateur(@PathVariable Integer id,
                                                            @RequestBody UtilisateurDto utilisateurDto) {
        return ResponseEntity.ok(utilisateurService.updateUtilisateur(id, utilisateurDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}

