package com.example.delivery_notification.util;

import com.example.delivery_notification.dto.NotificationDto;
import com.example.delivery_notification.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public NotificationDto toDto(Notification notification) {
        if (notification == null) {
            return null;
        }
        return NotificationDto.builder().notificationType(notification.getNotificationType()).
                recipientRole(notification.getRecipientRole()).
                  message(notification.getMessage()).
        build();
    }
    public Notification toEntity(NotificationDto dto) {
        if (dto == null) {
            return null;
        }
        Notification notification = new Notification();
         notification.setNotificationType(dto.getNotificationType());
         notification.setRecipientRole(dto.getRecipientRole());
         notification.setMessage(buildMessage(dto));
        return notification;
    }
    private String buildMessage(NotificationDto request) {
        switch (request.getNotificationType()) {

            case QC_FAIL:
                return "QC inspection failed for Production Order ";
            case DELIVERY:
                return "Delivery created for Production Order ";
            case STATUS_CHANGE:
                return "Production Order status changed ";
            default:
                return "Notification";
        }
    }
}
