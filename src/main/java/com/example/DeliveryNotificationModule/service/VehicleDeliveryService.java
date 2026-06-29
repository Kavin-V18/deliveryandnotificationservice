package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.VehicleDeliveryDto;
import java.util.List;
public interface VehicleDeliveryService {

      VehicleDeliveryDto createVehicleDelivery(VehicleDeliveryDto vehicleDeliveryDto);
    VehicleDeliveryDto getVehicleDeliveryById(Long id);
        List<VehicleDeliveryDto>  getAllvehicleDelivery();
    VehicleDeliveryDto updateVehicleDelivery(Long id,VehicleDeliveryDto vehicleDeliveryDto);
        void deleteVehicleDelivery(Long id);

}
