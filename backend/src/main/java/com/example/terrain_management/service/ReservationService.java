package com.example.terrain_management.service;

import com.example.terrain_management.dto.ReservationDto;
import com.example.terrain_management.entity.Match;
import com.example.terrain_management.entity.Reservation;
import com.example.terrain_management.enums.ReservationStatusEnum;
import com.example.terrain_management.mapper.ReservationMapper;
import com.example.terrain_management.repository.MatchRepository;
import com.example.terrain_management.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MatchRepository matchRepository; // Ajout du MatchRepository

    public ReservationService(ReservationRepository reservationRepository, MatchRepository matchRepository) {
        this.reservationRepository = reservationRepository;
        this.matchRepository = matchRepository; // Injection du MatchRepository
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
        Reservation reservation = ReservationMapper.toEntity(reservationDto);

        if (reservationDto.getMatchId() != null) {
            Match match = matchRepository.findById(reservationDto.getMatchId())
                    .orElseThrow(() -> new RuntimeException("Match non trouvé"));

            // Associer les données du match à la réservation
            reservation.setMatch(match);
            reservation.setDateMatch(match.getDateMatch());
            reservation.setHeureMatch(match.getHeureMatch());
        } else {
            throw new RuntimeException("Match ID manquant pour la réservation");
        }

        // Définir la date de réservation avec la date actuelle
        reservation.setDateReservation(new Date());

        // Définir le statut par défaut
        reservation.setStatutReservation(ReservationStatusEnum.EN_ATTENTE);

        // Sauvegarder et retourner le DTO
        return ReservationMapper.toDto(reservationRepository.save(reservation));
    }



    public void cancelReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservation.setStatutReservation(ReservationStatusEnum.ANNULEE);
        reservationRepository.save(reservation);
    }

    public void expireReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservation.setStatutReservation(ReservationStatusEnum.EXPIREE);
        reservationRepository.save(reservation);
    }
}
