
package com.example.DeliveryNotificationModule.entity;

import com.example.DeliveryNotificationModule.NotificationType;
import com.example.DeliveryNotificationModule.RecipientRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "notifications", schema = "public")
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreatedBy
    private Long created_by;
    @UpdateTimestamp
    private LocalDate last_modified_at;
    @LastModifiedBy
    private Long last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
