package com.example.delivery_notification.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDeliveryDto {

    @NotBlank
    private String invoiceNumber;
    //foreign key--vehicleInventory
    private Long vehicleId;
    //foreign-key --customer
    private Long customerId;
    @NotNull
    @PastOrPresent(message =
            "Delivery date cannot be in the future")
    private LocalDate deliveryDate;
    @NotNull
    @DecimalMin(value = "0.01",
            message = "Invoice amount must be greater than 0")
    private BigDecimal invoiceAmount;
    // FK -- Employee
    private Long deliveredByEmployeeId;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
}
