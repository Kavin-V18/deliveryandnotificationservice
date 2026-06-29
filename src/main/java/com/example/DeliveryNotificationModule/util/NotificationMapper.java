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
        return NotificationDto.builder().notificationType(notification.getNotificationType()).
                recipientRole(notification.getRecipientRole()).
                isRead(notification.getIsRead()).

                created_by(notification.getCreated_by()).
                last_modified_by(notification.getLast_modified_by()).
        build();
    }
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
         notification.setCreated_by(dto.getCreated_by());
         notification.setLast_modified_by(dto.getLast_modified_by());
        return notification;
    }
}
