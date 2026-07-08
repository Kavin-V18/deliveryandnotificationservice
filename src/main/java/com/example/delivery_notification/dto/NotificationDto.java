package com.example.delivery_notification.dto;

import com.example.delivery_notification.NotificationType;
import com.example.delivery_notification.RecipientRole;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
public class NotificationDto {

    @NotBlank
    private RecipientRole recipientRole;
    @NotBlank
    private String message;
    @NotBlank
    private NotificationType notificationType;
}
