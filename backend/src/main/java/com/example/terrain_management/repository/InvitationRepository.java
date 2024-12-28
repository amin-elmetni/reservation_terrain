package com.example.terrain_management.repository;

import com.example.terrain_management.entity.Invitation;
import com.example.terrain_management.entity.Match;
import com.example.terrain_management.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {
    boolean existsByMatchAndUtilisateur(Match match, Utilisateur utilisateur);
}