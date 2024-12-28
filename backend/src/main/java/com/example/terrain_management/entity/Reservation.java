package com.example.terrain_management.entity;

import com.example.terrain_management.enums.PaymentStatusEnum;
import com.example.terrain_management.enums.ReservationStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation = new Date();

    @Enumerated(EnumType.STRING)
    private ReservationStatusEnum statutReservation;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum statutPaiement;
    @Temporal(TemporalType.DATE)
    private Date dateMatch; // Nouvelle colonne pour la date du match

    @Temporal(TemporalType.TIME)
    private String heureMatch; // Nouvelle colonne pour l'heure du match

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public ReservationStatusEnum getStatutReservation() {
        return statutReservation;
    }

    public void setStatutReservation(ReservationStatusEnum statutReservation) {
        this.statutReservation = statutReservation;
    }

    public PaymentStatusEnum getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(PaymentStatusEnum statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getHeureMatch() {
        return heureMatch;
    }

    public void setHeureMatch(String heureMatch) {
        this.heureMatch = heureMatch;
    }
}