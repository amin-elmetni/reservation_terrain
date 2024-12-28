package com.example.terrain_management.mapper;

import com.example.terrain_management.dto.ClientDto;
import com.example.terrain_management.entity.Client;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.repository.UtilisateurRepository;

public class ClientMapper {
    private final UtilisateurRepository utilisateurRepository;

    // Constructor
    public ClientMapper(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Convertir une entité Client en DTO
    public static ClientDto toDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setUtilisateurId(client.getUtilisateur() != null ? client.getUtilisateur().getId() : null);
        dto.setTypeClient(client.getTypeClient());
        dto.setNomOrganisation(client.getNomOrganisation());
        dto.setDocumentAssociation(client.getDocumentAssociation());
        return dto;
    }

    // Convertir un DTO en entité Client
    public Client toEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        if (dto.getUtilisateurId() != null) {
            Utilisateur utilisateur = utilisateurRepository.findById(dto.getUtilisateurId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
            client.setUtilisateur(utilisateur);
        }
        client.setTypeClient(dto.getTypeClient());
        client.setNomOrganisation(dto.getNomOrganisation());
        client.setDocumentAssociation(dto.getDocumentAssociation());
        return client;
    }
}
