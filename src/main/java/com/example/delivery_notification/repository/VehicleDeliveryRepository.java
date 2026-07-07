package com.example.delivery_notification.repository;

import com.example.delivery_notification.entity.VehicleDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleDeliveryRepository extends JpaRepository<VehicleDelivery,Integer> {
}
