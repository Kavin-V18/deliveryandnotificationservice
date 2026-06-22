package com.example.DeliveryNotificationModule.repository;

import com.example.DeliveryNotificationModule.entity.VehicleDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleDeliveryRepository extends JpaRepository<VehicleDelivery,Integer> {
}
