package com.example.terrain_management.service;

import com.example.terrain_management.dto.ReservationDto;
import com.example.terrain_management.entity.Reservation;
import com.example.terrain_management.entity.Terrain;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.mapper.ReservationMapper;
import com.example.terrain_management.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationById(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        return ReservationMapper.toDto(reservation);
    }

    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setDateCreation(LocalDate.now());
        reservation.setStatutReservation("CONFIRMEE");  // Statut de réservation confirmé
        reservation.setStatutPaiement("ACOMPTE");      // Statut de paiement acompte
        reservation.setDateReservation(reservationDto.getDateReservation());
        reservation.setHeureReservation(reservationDto.getHeureReservation());

        // Assurez-vous que le client est correctement défini en fonction de l'ID du client
        Utilisateur client = new Utilisateur();
        client.setId(reservationDto.getIdClient());
        reservation.setClient(client);

        // Assurez-vous que le client est correctement défini en fonction de l'ID du client
        Terrain terrain = new Terrain();
        terrain.setId(reservationDto.getIdTerrain());
        reservation.setTerrain(terrain);

        // Enregistrez la réservation dans la base de données
        reservationRepository.save(reservation);

        return reservationDto;
    }

    public void cancelReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservation.setStatutReservation("ANNULEE");
        reservationRepository.save(reservation);
    }

    public void expireReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservation.setStatutReservation("EXPIREE");
        reservationRepository.save(reservation);
    }

    public List<ReservationDto> getReservationsByClientAndStatus(Integer clientId, String status) {
        return reservationRepository.findByClientIdAndStatutReservation(clientId, status).stream()
                .map(ReservationMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<Reservation> getReservationsByTerrain(Long terrainId) {
        return reservationRepository.findByTerrainId(terrainId);
    }

}
