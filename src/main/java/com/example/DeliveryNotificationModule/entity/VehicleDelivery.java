
package com.example.DeliveryNotificationModule.entity;

import com.example.EmployeeCustomerModule.entity.Customer;
import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.QuantityandInventoryModule.entity.VehicleInventory;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
public class VehicleDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "invoice_number",
            nullable = false,
            unique = true)
    private String invoiceNumber;
    // FK  VehicleInventory Service
    @Column(nullable = false)
    private VehicleInventory vehicleId;
    // FK  Customer Service
    @Column(nullable = false)
    private Customer customerId;
    @Column(nullable = false)
    private LocalDate deliveryDate;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal invoiceAmount;
    // FK  Employee Service
    @Column(nullable = false)
    private Employee deliveredByEmployeeId;
    @CreationTimestamp
    private LocalDateTime created_at;
    private String created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}