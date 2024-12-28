package com.example.terrain_management.mapper;


import com.example.terrain_management.dto.NotificationDto;
import com.example.terrain_management.entity.Notification;

public class NotificationMapper {

    public static NotificationDto toDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setId(notification.getId());
        dto.setMessage(notification.getMessage());
        dto.setTypeNotification(notification.getTypeNotification());
        dto.setDateEnvoi(notification.getDateEnvoi());

        // Gestion des relations
        if (notification.getUtilisateur() != null) {
            dto.setUtilisateurId(notification.getUtilisateur().getId());
        }

        return dto;
    }

    public static Notification toEntity(NotificationDto dto) {
        Notification notification = new Notification();
        notification.setId(dto.getId());
        notification.setMessage(dto.getMessage());
        notification.setTypeNotification(dto.getTypeNotification());
        notification.setDateEnvoi(dto.getDateEnvoi());

        // Les relations doivent être gérées par le service ou le contrôleur
        return notification;
    }
}
