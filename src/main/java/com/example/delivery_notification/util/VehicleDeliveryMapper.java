package com.example.delivery_notification.util;

import com.example.delivery_notification.dto.VehicleDeliveryDto;
import com.example.delivery_notification.entity.VehicleDelivery;
import org.springframework.stereotype.Component;

@Component
public class VehicleDeliveryMapper {

    public VehicleDeliveryDto toDto(VehicleDelivery vehicleDelivery) {
        if (vehicleDelivery == null) return null;

        return VehicleDeliveryDto.builder().vehicleId(vehicleDelivery.getVehicleId()).
                deliveryDate(vehicleDelivery.getDeliveryDate()).
                customerId(vehicleDelivery.getCustomerId()).
                deliveredByEmployeeId(vehicleDelivery.getDeliveredByEmployeeId()).
                createdBy(vehicleDelivery.getCreatedBy())
                .createdAt(vehicleDelivery.getCreatedAt()).
                lastModifiedBy(vehicleDelivery.getLastModifiedBy()).
                lastModifiedAt(vehicleDelivery.getLastModifiedAt()).
                invoiceAmount(vehicleDelivery.getInvoiceAmount()).
                invoiceNumber(vehicleDelivery.getInvoiceNumber()).
                deliveryDate(vehicleDelivery.getDeliveryDate()).
                build();
    }
    public VehicleDelivery toEntity(VehicleDeliveryDto dto) {
        if (dto == null) return null;
        VehicleDelivery vehicleDelivery = new VehicleDelivery();
        vehicleDelivery.setVehicleId(dto.getVehicleId());
        vehicleDelivery.setDeliveryDate(dto.getDeliveryDate());
        vehicleDelivery.setCustomerId(dto.getCustomerId());
        vehicleDelivery.setDeliveredByEmployeeId(dto.getDeliveredByEmployeeId());
        vehicleDelivery.setInvoiceAmount(dto.getInvoiceAmount());
        vehicleDelivery.setInvoiceNumber(dto.getInvoiceNumber());
        vehicleDelivery.setCreatedBy(dto.getCreatedBy());
        vehicleDelivery.setCreatedAt(dto.getCreatedAt());
        vehicleDelivery.setLastModifiedBy(dto.getLastModifiedBy());
        vehicleDelivery.setLastModifiedAt(dto.getLastModifiedAt());
        return vehicleDelivery;
    }
}
