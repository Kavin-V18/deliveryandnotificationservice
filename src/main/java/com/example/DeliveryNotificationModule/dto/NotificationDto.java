package com.example.DeliveryNotificationModule.dto;

import com.example.DeliveryNotificationModule.NotificationType;
import com.example.DeliveryNotificationModule.RecipientRole;
import lombok.*;


import java.time.LocalDateTime;

@Data
public class NotificationDto {

    private int id;
    private RecipientRole recipientRole;
    private String message;
    private NotificationType notificationType;
    private Boolean isRead=false;
    private LocalDateTime createdAt;

    public NotificationDto(RecipientRole recipientRole, Boolean isRead, String message, LocalDateTime createdAt, NotificationType notificationType, Long id) {
    }
}
