package com.example.terrain_management.entity;

import com.example.terrain_management.enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity

@Table(name = "paiements")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double montant;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement = new Date();

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum typePaiement;

    @ManyToOne
    @JoinColumn(name = "carte_id")
    private CarteBancaire carte;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


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

    public java.util.Date getDatePaiement() {
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

    public CarteBancaire getCarte() {
        return carte;
    }

    public void setCarte(CarteBancaire carte) {
        this.carte = carte;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
