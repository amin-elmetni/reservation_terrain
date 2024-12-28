package com.example.terrain_management.mapper;


import com.example.terrain_management.dto.InvitationDto;
import com.example.terrain_management.entity.Invitation;

public class InvitationMapper {

    public static InvitationDto toDto(Invitation invitation) {
        InvitationDto dto = new InvitationDto();
        dto.setId(invitation.getId());
        dto.setMatchId(invitation.getMatch() != null ? invitation.getMatch().getId() : null);
        dto.setUtilisateurId(invitation.getUtilisateur() != null ? invitation.getUtilisateur().getId() : null);
        dto.setStatut(invitation.getStatut());
        return dto;
    }

    public static Invitation toEntity(InvitationDto dto) {
        Invitation invitation = new Invitation();
        invitation.setId(dto.getId());
        // Mapping manuel pour les relations complexes comme Match ou Utilisateur
        invitation.setStatut(dto.getStatut());
        return invitation;
    }
}

