package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.entity.VehicleDelivery;
import java.util.List;
public interface VehicleDeliveryService {

      VehicleDelivery createVehicleDelivery(VehicleDelivery vehicleDelivery);
        VehicleDelivery getVehicleDeliveryById(int id);
        List<VehicleDelivery>  getAllvehicleDelivery();
        VehicleDelivery updateVehicleDelivery(int id,VehicleDelivery vehicleDelivery);
        void deleteVehicleDelivery(int id);

}
