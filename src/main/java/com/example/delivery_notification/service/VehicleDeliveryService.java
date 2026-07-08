package com.example.delivery_notification.service;

import com.example.delivery_notification.dto.VehicleDeliveryDto;
import java.util.List;
public interface VehicleDeliveryService {

      VehicleDeliveryDto createVehicleDelivery(VehicleDeliveryDto vehicleDeliveryDto);
    VehicleDeliveryDto getVehicleDeliveryById(int id);
        List<VehicleDeliveryDto>  getAllVehicleDelivery();
    VehicleDeliveryDto updateVehicleDelivery(int id,VehicleDeliveryDto vehicleDeliveryDto);
        void deleteVehicleDelivery(int id);
}
