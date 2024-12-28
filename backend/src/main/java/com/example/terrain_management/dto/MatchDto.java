package com.example.terrain_management.dto;

import com.example.terrain_management.enums.MatchStatusEnum;

import java.util.Date;

public class MatchDto {
    private Integer id;
    private Date dateCreation;
    private Date dateMatch;
    private String heureMatch; // Nouvelle colonne
    private Date timeout;
    private Integer clientId;
    private Integer terrainId;
    private MatchStatusEnum statut;

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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(Integer terrainId) {
        this.terrainId = terrainId;
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
