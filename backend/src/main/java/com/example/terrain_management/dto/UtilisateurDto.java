package com.example.terrain_management.dto;

import com.example.terrain_management.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String email;
    private String telephone;
    private String password; // Ajout du champ password
    private RoleEnum role;
    private String ville; // Nouvelle colonne ajoutée

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
