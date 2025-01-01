package com.example.terrain_management.repository;

import com.example.terrain_management.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByClientIdAndStatutReservation(Integer clientId, String statutReservation);

    @Query("SELECT r FROM Reservation r WHERE r.terrain.id = :terrainId")
    List<Reservation> findByTerrainId(@Param("terrainId") Long terrainId);
}
