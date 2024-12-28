package com.example.terrain_management.entity;

import com.example.terrain_management.enums.RoleEnum;
import com.example.terrain_management.enums.VilleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String email;
    private String telephone;
    private String password;

    @Enumerated(EnumType.STRING)
    private VilleEnum ville; // Remplacement par enum

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VilleEnum getVille() {
        return ville;
    }

    public void setVille(VilleEnum ville) {
        this.ville = ville;
    }
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}