package com.example.terrain_management.dto;

import com.example.terrain_management.enums.ClientTypeEnum;

public class ClientDto {
    private Integer id;
    private Integer utilisateurId;
    private ClientTypeEnum typeClient;
    private String nomOrganisation;
    private String documentAssociation;

    // Getter et Setter pour id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter et Setter pour utilisateurId
    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    // Getter et Setter pour typeClient
    public ClientTypeEnum getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(ClientTypeEnum typeClient) {
        this.typeClient = typeClient;
    }

    // Getter et Setter pour nomOrganisation
    public String getNomOrganisation() {
        return nomOrganisation;
    }

    public void setNomOrganisation(String nomOrganisation) {
        this.nomOrganisation = nomOrganisation;
    }

    // Getter et Setter pour documentAssociation
    public String getDocumentAssociation() {
        return documentAssociation;
    }

    public void setDocumentAssociation(String documentAssociation) {
        this.documentAssociation = documentAssociation;
    }
}
