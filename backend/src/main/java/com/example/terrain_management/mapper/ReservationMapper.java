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
        dto.setDateReservation(reservation.getDateReservation());
        dto.setStatutReservation(reservation.getStatutReservation());
        dto.setStatutPaiement(reservation.getStatutPaiement());
        dto.setDateMatch(reservation.getDateMatch());
        dto.setHeureMatch(reservation.getHeureMatch());
        dto.setMatchId(reservation.getMatch() != null ? reservation.getMatch().getId() : null);

        return dto;
    }


    public static Reservation toEntity(ReservationDto dto) {
        if (dto == null) {
            return null;
        }

        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setDateReservation(dto.getDateReservation());
        reservation.setStatutReservation(dto.getStatutReservation());
        reservation.setStatutPaiement(dto.getStatutPaiement());
        reservation.setDateMatch(dto.getDateMatch());
        reservation.setHeureMatch(dto.getHeureMatch());

        return reservation;
    }

}
