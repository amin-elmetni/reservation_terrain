package com.example.terrain_management.service;

import com.example.terrain_management.dto.InvitationDto;
import com.example.terrain_management.entity.Invitation;
import com.example.terrain_management.entity.Match;
import com.example.terrain_management.entity.Notification;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.InvitationStatusEnum;
import com.example.terrain_management.enums.NotificationTypeEnum;
import com.example.terrain_management.mapper.InvitationMapper;
import com.example.terrain_management.repository.InvitationRepository;
import com.example.terrain_management.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvitationService {
    private final InvitationRepository invitationRepository;
    private final NotificationRepository notificationRepository; // Ajout pour les notifications

    public InvitationService(InvitationRepository invitationRepository,
                             NotificationRepository notificationRepository) {
        this.invitationRepository = invitationRepository;
        this.notificationRepository = notificationRepository; // Initialisation
    }

    public List<InvitationDto> getAllInvitations() {
        return invitationRepository.findAll().stream()
                .map(InvitationMapper::toDto)
                .collect(Collectors.toList());
    }

    public InvitationDto getInvitationById(Integer id) {
        Invitation invitation = invitationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitation non trouvée"));
        return InvitationMapper.toDto(invitation);
    }

    public void createInvitation(Match match, Utilisateur utilisateur) {
        // Vérifiez si une invitation existe déjà pour ce match et cet utilisateur
        boolean invitationExists = invitationRepository.existsByMatchAndUtilisateur(match, utilisateur);
        if (invitationExists) {
            throw new RuntimeException("L'utilisateur est déjà invité à ce match.");
        }

        // Création de l'invitation
        Invitation invitation = new Invitation();
        invitation.setMatch(match);
        invitation.setUtilisateur(utilisateur);
        invitation.setStatut(InvitationStatusEnum.EN_ATTENTE);
        invitationRepository.save(invitation);

        // Envoi automatique de notification
        Notification notification = new Notification();
        notification.setMessage("Vous êtes invité au match du " + match.getDateMatch() + " à " + match.getHeureMatch());
        notification.setUtilisateur(utilisateur);
        notification.setTypeNotification(NotificationTypeEnum.INVITATION);
        notificationRepository.save(notification);
    }


    public void acceptInvitation(Integer id) {
        Invitation invitation = invitationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitation non trouvée"));
        invitation.setStatut(InvitationStatusEnum.ACCEPTEE);
        invitationRepository.save(invitation);
    }

    public void refuseInvitation(Integer id) {
        Invitation invitation = invitationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitation non trouvée"));
        invitation.setStatut(InvitationStatusEnum.REFUSEE);
        invitationRepository.save(invitation);
    }
}