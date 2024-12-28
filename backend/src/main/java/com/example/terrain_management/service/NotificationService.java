package com.example.terrain_management.service;

import com.example.terrain_management.dto.NotificationDto;
import com.example.terrain_management.entity.Invitation;
import com.example.terrain_management.entity.Match;
import com.example.terrain_management.entity.Notification;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.InvitationStatusEnum;
import com.example.terrain_management.enums.NotificationTypeEnum;
import com.example.terrain_management.mapper.NotificationMapper;
import com.example.terrain_management.repository.InvitationRepository;
import com.example.terrain_management.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) { // Injection
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationDto> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(NotificationMapper::toDto)
                .collect(Collectors.toList());
    }

    public NotificationDto getNotificationById(Integer id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification non trouvée"));
        return NotificationMapper.toDto(notification);
    }

    public void deleteNotification(Integer id) {
        if (!notificationRepository.existsById(id)) {
            throw new RuntimeException("Notification non trouvée");
        }
        notificationRepository.deleteById(id);
    }
}
