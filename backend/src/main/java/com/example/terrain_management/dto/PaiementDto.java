package com.example.terrain_management.dto;

import com.example.terrain_management.enums.PaymentStatusEnum;

import java.util.Date;

public class PaiementDto {
    private Integer id;
    private Double montant;
    private Date datePaiement;
    private PaymentStatusEnum typePaiement;
    private Integer carteId;
    private Integer reservationId;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public PaymentStatusEnum getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(PaymentStatusEnum typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Integer getCarteId() {
        return carteId;
    }

    public void setCarteId(Integer carteId) {
        this.carteId = carteId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
}
