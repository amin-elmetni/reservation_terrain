package com.example.terrain_management.entity;

import com.example.terrain_management.enums.NotificationTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_notification") // Aligné avec la base de données
    private NotificationTypeEnum typeNotification;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi = new Date();
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

}
