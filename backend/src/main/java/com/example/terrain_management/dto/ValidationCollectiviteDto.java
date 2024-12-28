package com.example.terrain_management.dto;

import com.example.terrain_management.enums.ValidationStatusEnum;

import java.util.Date;

public class ValidationCollectiviteDto {
    private Integer id;
    private Integer reservationId;
    private Integer collectiviteId;
    private ValidationStatusEnum statut;
    private Date dateValidation;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getCollectiviteId() {
        return collectiviteId;
    }

    public void setCollectiviteId(Integer collectiviteId) {
        this.collectiviteId = collectiviteId;
    }

    public ValidationStatusEnum getStatut() {
        return statut;
    }

    public void setStatut(ValidationStatusEnum statut) {
        this.statut = statut;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }
}
