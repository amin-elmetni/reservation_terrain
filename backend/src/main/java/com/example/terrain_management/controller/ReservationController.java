package com.example.terrain_management.controller;

import com.example.terrain_management.dto.ReservationDto;
import com.example.terrain_management.entity.Reservation;
import com.example.terrain_management.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Integer id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationService.createReservation(reservationDto));
    }

    @PutMapping("/{id}/annuler")
    public ResponseEntity<Void> cancelReservation(@PathVariable Integer id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/expire")
    public ResponseEntity<Void> expireReservation(@PathVariable Integer id) {
        reservationService.expireReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client")
    public ResponseEntity<List<ReservationDto>> getReservationsByClientAndStatus(
            @RequestParam Integer clientId,
            @RequestParam String status) {
        return ResponseEntity.ok(reservationService.getReservationsByClientAndStatus(clientId, status));
    }

    @GetMapping("/terrain/{terrainId}")
    public ResponseEntity<List<Reservation>> getReservationsByTerrain(@PathVariable Long terrainId) {
        List<Reservation> reservations = reservationService.getReservationsByTerrain(terrainId);
        return ResponseEntity.ok(reservations);
    }

}
