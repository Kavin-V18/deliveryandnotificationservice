package com.example.DeliveryNotificationModule.controller;


import com.example.DeliveryNotificationModule.entity.VehicleDelivery;
import com.example.DeliveryNotificationModule.service.VehicleDeliveryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicledelivery")
public class VehicleDeliveryController {
    private final VehicleDeliveryService vehicleDeliveryService;
    public VehicleDeliveryController(VehicleDeliveryService vehicleDeliveryService){
        this.vehicleDeliveryService=vehicleDeliveryService;
    }
    @GetMapping()
    public List<VehicleDelivery> getNotifications() {
        return vehicleDeliveryService.getAllvehicleDelivery();
    }
    @PostMapping()
    public  VehicleDelivery createNotification(@Valid  @RequestBody VehicleDelivery vehicleDelivery){
        return vehicleDeliveryService.createVehicleDelivery(vehicleDelivery);
    }
    @GetMapping("/{id}")
    public VehicleDelivery getNotificationById(@PathVariable int id){
        return vehicleDeliveryService.getVehicleDeliveryById(id);
    }
    @PostMapping("/{id}")
    public VehicleDelivery updateNotification(@PathVariable int id,@Valid @RequestBody VehicleDelivery vehicleDelivery){
        return  vehicleDeliveryService.updateVehicleDelivery(id, vehicleDelivery);
    }
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id){
       vehicleDeliveryService.deleteVehicleDelivery(id);
    }

}
