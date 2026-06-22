
package com.example.DeliveryNotificationModule.entity;

import com.example.DeliveryNotificationModule.NotificationType;
import com.example.DeliveryNotificationModule.RecipientRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "notifications", schema = "public")
public class Notification {
    @Id
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
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.isRead == null) {
            this.isRead = false;
        }
    }
}
