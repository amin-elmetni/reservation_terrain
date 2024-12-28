package com.example.terrain_management.entity;

import com.example.terrain_management.enums.MatchStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();
    private Date dateMatch;
    private Date timeout;
    @Temporal(TemporalType.TIME)
    private String heureMatch;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) // Client obligatoire
    private Utilisateur client;

    @ManyToOne
    @JoinColumn(name = "terrain_id", nullable = false) // Terrain obligatoire
    private Terrain terrain;


    @Enumerated(EnumType.STRING)
    private MatchStatusEnum statut = MatchStatusEnum.EN_ATTENTE;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public Date getTimeout() {
        return timeout;
    }

    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public MatchStatusEnum getStatut() {
        return statut;
    }

    public void setStatut(MatchStatusEnum statut) {
        this.statut = statut;
    }

    public String getHeureMatch() {
        return heureMatch;
    }

    public void setHeureMatch(String heureMatch) {
        this.heureMatch = heureMatch;
    }
}