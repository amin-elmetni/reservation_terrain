package com.example.terrain_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarteBancaireDto {
    private Integer id;
    private String numeroCarte;
    private String nomProprietaire;
    private Integer moisExpiration;
    private Integer anneeExpiration;
    private String cvv;
    private Integer clientId;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public Integer getMoisExpiration() {
        return moisExpiration;
    }

    public void setMoisExpiration(Integer moisExpiration) {
        this.moisExpiration = moisExpiration;
    }

    public Integer getAnneeExpiration() {
        return anneeExpiration;
    }

    public void setAnneeExpiration(Integer anneeExpiration) {
        this.anneeExpiration = anneeExpiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
