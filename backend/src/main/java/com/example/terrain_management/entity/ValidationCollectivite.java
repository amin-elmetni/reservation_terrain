package com.example.terrain_management.entity;


import com.example.terrain_management.enums.ValidationStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "validations_collectivite")

public class ValidationCollectivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "collectivite_id")
    private Utilisateur collectivite;

    @Enumerated(EnumType.STRING)
    private ValidationStatusEnum statut = ValidationStatusEnum.EN_ATTENTE;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValidation;
}
