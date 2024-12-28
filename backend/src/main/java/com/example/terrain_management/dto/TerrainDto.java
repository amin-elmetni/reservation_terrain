package com.example.terrain_management.dto;

import com.example.terrain_management.enums.TypeGazon;
import com.example.terrain_management.enums.VilleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TerrainDto {
    private Integer id;
    private String nom;
    private String adresse;
    private String localisation;
    private Boolean disponibilite;
    private Integer capacite;
    private Integer responsableId;
    private String ville; // Remplacement par enum
    private TypeGazon typeGazon; // Ajout pour le type de gazon
    private String imageUrl; // Ajout pour l'image

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTypeGazon(TypeGazon typeGazon) {
        this.typeGazon = typeGazon;
    }

    public TypeGazon getTypeGazon() {
        return typeGazon;
    }
}
