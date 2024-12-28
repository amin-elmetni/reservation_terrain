package com.example.terrain_management.entity;

import com.example.terrain_management.enums.TypeGazon;
import com.example.terrain_management.enums.VilleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "terrains")
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String adresse;
    private String localisation;
    private Boolean disponibilite = true;
    private Integer capacite = 1;
    @Enumerated(EnumType.STRING)
    private VilleEnum ville; // Remplacement par enum
    @Enumerated(EnumType.STRING)
    private TypeGazon typeGazon; // Ajout pour le type de gazon

    private String imageUrl; // Ajout pour l'image

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Utilisateur responsable;

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

    public Utilisateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }

    public VilleEnum getVille() {
        return ville;
    }

    public void setVille(VilleEnum ville) {
        this.ville = ville;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TypeGazon getTypeGazon() {
        return typeGazon;
    }

    public void setTypeGazon(TypeGazon typeGazon) {
        this.typeGazon = typeGazon;
    }
}

