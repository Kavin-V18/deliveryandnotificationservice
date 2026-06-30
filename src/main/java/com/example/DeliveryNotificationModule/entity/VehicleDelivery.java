
package com.example.DeliveryNotificationModule.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "vehicle_delivery",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "invoice_number")
        }
)
@Data
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class VehicleDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "invoice_number",
            nullable = false,
            unique = true)
    private String invoiceNumber;
    // FK  VehicleInventory
    @Column(nullable = false)
    private Long vehicleId;
    // FK  Customer
    @Column(nullable = false)
    private Long customerId;
    @Column(nullable = false)
    private LocalDate deliveryDate;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal invoiceAmount;
    // FK  Employee
    @Column(nullable = false)
    private Long deliveredByEmployeeId;
    @CreationTimestamp
    private LocalDateTime created_at;
    @CreatedBy
    private Long created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @LastModifiedBy
    private Long last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}