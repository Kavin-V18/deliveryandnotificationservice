package com.example.delivery_notification.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInventoryDto {

    @NotBlank
    private String vin;
    //foreign key
    private Long productionOrders;
    //foreign key-carModel
    private long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private String status;
    @NotBlank
    private LocalDate manufacturedDate;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private Long createdBy;
    private Long lastModifiedBy;
}
