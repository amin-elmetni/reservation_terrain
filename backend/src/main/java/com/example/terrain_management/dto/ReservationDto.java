package com.example.terrain_management.dto;

import com.example.terrain_management.enums.PaymentStatusEnum;
import com.example.terrain_management.enums.ReservationStatusEnum;

import java.util.Date;

public class ReservationDto {
    private Integer id;
    private Date dateReservation;
    private Date dateMatch; // Nouvelle colonne
    private String heureMatch; // Nouvelle colonne
    private ReservationStatusEnum statutReservation;
    private PaymentStatusEnum statutPaiement;
    private Integer matchId;

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

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
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
