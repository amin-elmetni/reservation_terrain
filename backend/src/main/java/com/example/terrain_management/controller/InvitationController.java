// InvitationController.java
package com.example.terrain_management.controller;

import com.example.terrain_management.dto.InvitationDto;
import com.example.terrain_management.entity.Match;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.service.InvitationService;
import com.example.terrain_management.service.MatchService;
import com.example.terrain_management.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitations")
public class InvitationController {

    private final InvitationService invitationService;
    private final MatchService matchService; // Ajout pour obtenir les informations sur le match
    private final UtilisateurService utilisateurService; // Ajout pour obtenir les informations sur l'utilisateur

    public InvitationController(InvitationService invitationService,
                                MatchService matchService,
                                UtilisateurService utilisateurService) {
        this.invitationService = invitationService;
        this.matchService = matchService;
        this.utilisateurService = utilisateurService;
    }
    @GetMapping
    public ResponseEntity<List<InvitationDto>> getAllInvitations() {
        return ResponseEntity.ok(invitationService.getAllInvitations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvitationDto> getInvitationById(@PathVariable Integer id) {
        return ResponseEntity.ok(invitationService.getInvitationById(id));
    }

    @PutMapping("/{id}/accepter")
    public ResponseEntity<Void> acceptInvitation(@PathVariable Integer id) {
        invitationService.acceptInvitation(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/refuser")
    public ResponseEntity<Void> refuseInvitation(@PathVariable Integer id) {
        invitationService.refuseInvitation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> createInvitation(@RequestParam Integer matchId, @RequestParam Integer utilisateurId) {
        // Récupérer le match et l'utilisateur en tant qu'entités
        Match match = matchService.findMatchById(matchId);
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(utilisateurId);

        // Créer l'invitation
        invitationService.createInvitation(match, utilisateur);

        return ResponseEntity.status(201).build();
    }

}
