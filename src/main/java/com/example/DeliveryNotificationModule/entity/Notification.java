
package com.example.DeliveryNotificationModule.entity;

import com.example.DeliveryNotificationModule.NotificationType;
import com.example.DeliveryNotificationModule.RecipientRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "notifications", schema = "public")
public class Notification {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecipientRole recipientRole;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType notificationType;
    @Column(name = "is_read", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isRead ;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String created_by;
    @UpdateTimestamp
    private LocalDate last_modified_at;
    private String last_modified_by;
}
