package com.example.terrain_management.entity;

import com.example.terrain_management.enums.ClientTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
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

    // Getter et Setter pour utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
