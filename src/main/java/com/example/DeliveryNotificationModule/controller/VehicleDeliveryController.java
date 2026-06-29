package com.example.DeliveryNotificationModule.controller;

import com.example.DeliveryNotificationModule.dto.VehicleDeliveryDto;
import com.example.DeliveryNotificationModule.service.VehicleDeliveryService;
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
        return vehicleDeliveryService.getAllvehicleDelivery();
    }
    @PostMapping()
    public  VehicleDeliveryDto createNotification(@Valid  @RequestBody VehicleDeliveryDto vehicleDelivery){
        return vehicleDeliveryService.createVehicleDelivery(vehicleDelivery);
    }
    @GetMapping("/{id}")
    public VehicleDeliveryDto getNotificationById(@PathVariable Long id){
        return vehicleDeliveryService.getVehicleDeliveryById(id);
    }
    @PostMapping("/{id}")
    public VehicleDeliveryDto updateNotification(@PathVariable Long id,@Valid @RequestBody VehicleDeliveryDto vehicleDelivery){
        return  vehicleDeliveryService.updateVehicleDelivery(id, vehicleDelivery);
    }
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id){
       vehicleDeliveryService.deleteVehicleDelivery(id);
    }

}
