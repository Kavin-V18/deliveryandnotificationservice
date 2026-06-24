package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.VehicleDeliveryDto;
import java.util.List;
public interface VehicleDeliveryService {

      VehicleDeliveryDto createVehicleDelivery(VehicleDeliveryDto vehicleDeliveryDto);
    VehicleDeliveryDto getVehicleDeliveryById(int id);
        List<VehicleDeliveryDto>  getAllvehicleDelivery();
    VehicleDeliveryDto updateVehicleDelivery(int id,VehicleDeliveryDto vehicleDeliveryDto);
        void deleteVehicleDelivery(int id);

}
