package com.example.terrain_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartes_bancaires")
public class CarteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroCarte;
    private String nomProprietaire;
    private Integer moisExpiration;
    private Integer anneeExpiration;
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
