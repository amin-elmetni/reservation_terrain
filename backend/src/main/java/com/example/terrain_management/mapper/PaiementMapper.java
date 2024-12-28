package com.example.terrain_management.mapper;


import com.example.terrain_management.dto.PaiementDto;
import com.example.terrain_management.entity.Paiement;

public class PaiementMapper {

    public static PaiementDto toDto(Paiement paiement) {
        PaiementDto dto = new PaiementDto();
        dto.setId(paiement.getId());
        dto.setMontant(paiement.getMontant());
        dto.setDatePaiement(paiement.getDatePaiement());
        dto.setTypePaiement(paiement.getTypePaiement());

        // Gestion des relations
        if (paiement.getCarte() != null) {
            dto.setCarteId(paiement.getCarte().getId());
        }
        if (paiement.getReservation() != null) {
            dto.setReservationId(paiement.getReservation().getId());
        }

        return dto;
    }

    public static Paiement toEntity(PaiementDto dto) {
        Paiement paiement = new Paiement();
        paiement.setId(dto.getId());
        paiement.setMontant(dto.getMontant());
        paiement.setDatePaiement(dto.getDatePaiement());
        paiement.setTypePaiement(dto.getTypePaiement());

        // Les relations doivent être gérées par le service ou le contrôleur
        return paiement;
    }
}
