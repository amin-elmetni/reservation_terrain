package com.example.terrain_management.repository;

import com.example.terrain_management.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByClientIdAndStatutReservation(Integer clientId, String statutReservation);
}
