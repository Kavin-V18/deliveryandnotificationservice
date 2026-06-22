
package com.example.DeliveryNotificationModule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @NotBlank
    @Column(name = "invoice_number",
            nullable = false,
            unique = true)
    private String invoiceNumber;
    // FK  VehicleInventory Service
    @NotBlank
    @Column(nullable = false)
    private String vehicleId;
    // FK  Customer Service
    @NotBlank
    @Column(nullable = false)
    private String customerId;
    @NotNull
    @Column(nullable = false)
    @PastOrPresent(message =
            "Delivery date cannot be in the future")
    private LocalDate deliveryDate;
    @NotNull
    @DecimalMin(value = "0.01",
            message = "Invoice amount must be greater than 0")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal invoiceAmount;
    // FK  Employee Service
    @NotBlank
    @Column(nullable = false)
    private String deliveredByEmployeeId;
}