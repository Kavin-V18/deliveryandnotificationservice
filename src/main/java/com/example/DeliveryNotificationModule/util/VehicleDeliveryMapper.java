package com.example.DeliveryNotificationModule.util;

import com.example.DeliveryNotificationModule.dto.VehicleDeliveryDto;
import com.example.DeliveryNotificationModule.entity.VehicleDelivery;
import org.springframework.stereotype.Component;

@Component
public class VehicleDeliveryMapper {

    public VehicleDeliveryDto toDto(VehicleDelivery vehicleDelivery) {
        if (vehicleDelivery == null) return null;

        return VehicleDeliveryDto.builder().vehicleId(vehicleDelivery.getVehicleId()).
                deliveryDate(vehicleDelivery.getDeliveryDate()).
                customerId(vehicleDelivery.getCustomerId()).
                deliveredByEmployeeId(vehicleDelivery.getDeliveredByEmployeeId()).
                created_by(vehicleDelivery.getCreated_by())
                .created_at(vehicleDelivery.getCreated_at()).
                last_modified_by(vehicleDelivery.getLast_modified_by()).
                last_modified_at(vehicleDelivery.getLast_modified_at()).
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
        return vehicleDelivery;
    }
}
