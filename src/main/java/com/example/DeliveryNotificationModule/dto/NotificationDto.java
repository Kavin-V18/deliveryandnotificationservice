package com.example.DeliveryNotificationModule.dto;

import com.example.DeliveryNotificationModule.NotificationType;
import com.example.DeliveryNotificationModule.RecipientRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class NotificationDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecipientRole recipientRole;
    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType notificationType;
    @Column(nullable = false)
    private Boolean isRead = false;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    private String created_by;
    private LocalDate last_modified_at;
    private String last_modified_by;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.isRead == null) {
            this.isRead = false;
        }
    }
}
