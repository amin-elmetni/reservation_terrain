package com.example.terrain_management.dto;

import com.example.terrain_management.enums.NotificationTypeEnum;

import java.util.Date;

public class NotificationDto {
    private Integer id;
    private String message;
    private NotificationTypeEnum typeNotification;
    private Integer utilisateurId;
    private Date dateEnvoi;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationTypeEnum getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(NotificationTypeEnum typeNotification) {
        this.typeNotification = typeNotification;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
}
