package com.example.terrain_management.mapper;

import com.example.terrain_management.dto.ReservationDto;
import com.example.terrain_management.entity.Reservation;

public class ReservationMapper {

    public static ReservationDto toDto(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setDateCreation(reservation.getDateCreation());
        dto.setStatutReservation(reservation.getStatutReservation());
        dto.setStatutPaiement(reservation.getStatutPaiement());
        dto.setDateReservation(reservation.getDateReservation());
        dto.setHeureReservation(reservation.getHeureReservation());
        dto.setIdClient(reservation.getClient().getId());

        return dto;
    }

    public static Reservation toEntity(ReservationDto dto) {
        if (dto == null) {
            return null;
        }

        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setDateCreation(dto.getDateCreation());
        reservation.setStatutReservation(dto.getStatutReservation());
        reservation.setStatutPaiement(dto.getStatutPaiement());
        reservation.setDateReservation(dto.getDateReservation());
        reservation.setHeureReservation(dto.getHeureReservation());

        return reservation;
    }
}
