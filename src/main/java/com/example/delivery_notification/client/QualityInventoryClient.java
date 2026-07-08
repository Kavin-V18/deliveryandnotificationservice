package com.example.delivery_notification.client;

import com.example.delivery_notification.dto.VehicleInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "QuantityandInventoryModule",
        url = "http://localhost:8087")
public interface QualityInventoryClient {
    @GetMapping("vehicleinventory/{id}")
    ResponseEntity<VehicleInventoryDto> getInventoryById(@PathVariable("id") Long id);

    @GetMapping("/vehicleinventory/{id}/exists")
    ResponseEntity<Boolean> checkInventoryExists(@PathVariable("id") Long id);
}
