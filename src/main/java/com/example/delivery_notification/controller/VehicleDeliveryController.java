package com.example.delivery_notification.controller;

import com.example.delivery_notification.dto.VehicleDeliveryDto;
import com.example.delivery_notification.service.VehicleDeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicledelivery")
@RequiredArgsConstructor
public class VehicleDeliveryController {
    private final VehicleDeliveryService vehicleDeliveryService;

    @GetMapping()
    public List<VehicleDeliveryDto> getNotifications() {
        return vehicleDeliveryService.getAllVehicleDelivery();
    }
    @PostMapping()
    public  VehicleDeliveryDto createNotification(@Valid  @RequestBody VehicleDeliveryDto vehicleDelivery){
        return vehicleDeliveryService.createVehicleDelivery(vehicleDelivery);
    }
    @GetMapping("/{id}")
    public VehicleDeliveryDto getNotificationById(@PathVariable int id){
        return vehicleDeliveryService.getVehicleDeliveryById(id);
    }
    @PutMapping("/{id}")
    public VehicleDeliveryDto updateNotification(@PathVariable int id,@Valid @RequestBody VehicleDeliveryDto vehicleDelivery){
        return  vehicleDeliveryService.updateVehicleDelivery(id, vehicleDelivery);
    }
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id){
       vehicleDeliveryService.deleteVehicleDelivery(id);
    }
}
