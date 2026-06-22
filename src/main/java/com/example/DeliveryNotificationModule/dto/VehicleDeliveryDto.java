package com.example.DeliveryNotificationModule.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class VehicleDeliveryDto {
    private String invoiceNumber;
    // FK  VehicleInventory Service
    private String vehicleId;
    // FK  Customer Service
    private String customerId;
    private LocalDate deliveryDate;
    private BigDecimal invoiceAmount;
    // FK  Employee Service
    private String deliveredByEmployeeId;
}
