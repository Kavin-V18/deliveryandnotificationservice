package com.example.DeliveryNotificationModule.util;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import com.example.DeliveryNotificationModule.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public NotificationDto toDto(Notification notification) {
        if (notification == null) {
            return null;
        }
        return new NotificationDto(
               notification.getRecipientRole(),
                notification.getIsRead(),
                notification.getMessage(),
                notification.getCreatedAt(),
                notification.getNotificationType(),
                notification.getId()
        );
    }

    // Convert DTO to Entity
    public Notification toEntity(NotificationDto dto) {
        if (dto == null) {
            return null;
        }
        Notification notification = new Notification();

         notification.setNotificationType(dto.getNotificationType());
         notification.setRecipientRole(dto.getRecipientRole());
         notification.setMessage(dto.getMessage());
         notification.setCreatedAt(dto.getCreatedAt());
         notification.setIsRead(dto.getIsRead());
        return notification;
    }
}
