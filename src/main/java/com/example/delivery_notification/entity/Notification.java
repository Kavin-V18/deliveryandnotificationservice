
package com.example.delivery_notification.entity;

import com.example.delivery_notification.NotificationType;
import com.example.delivery_notification.RecipientRole;
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
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
@EntityListeners(AuditingEntityListener.class)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecipientRole recipientRole;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType notificationType;
    @Column(name = "is_read", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean read ;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDate lastModifiedAt;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
}
