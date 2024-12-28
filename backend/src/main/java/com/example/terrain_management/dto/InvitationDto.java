package com.example.terrain_management.dto;

import com.example.terrain_management.enums.InvitationStatusEnum;

public class InvitationDto {
    private Integer id;
    private Integer matchId;
    private Integer utilisateurId;
    private InvitationStatusEnum statut;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public InvitationStatusEnum getStatut() {
        return statut;
    }

    public void setStatut(InvitationStatusEnum statut) {
        this.statut = statut;
    }
}
