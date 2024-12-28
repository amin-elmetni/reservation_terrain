package com.example.terrain_management.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponse {
    private String token;
    private String role;
    private Integer id;
    private String nom;
    private String email;
    private String telephone;
    private String ville;
    private ClientDto client; // Nouveau champ pour inclure les données client

    public AuthResponse(String token, String role, Integer id, String nom, String email, String telephone, String ville ,ClientDto client) {
        this.token = token;
        this.role = role;
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.client=client;
    }

    // Getter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVille() {
        return ville;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
