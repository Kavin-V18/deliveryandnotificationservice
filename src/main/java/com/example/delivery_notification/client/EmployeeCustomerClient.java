package com.example.delivery_notification.client;

import com.example.delivery_notification.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "EmployeeCustomerModule",
        url = "http://localhost:8085")
public interface EmployeeCustomerClient {
    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id);

    @GetMapping("/employee/{id}/exists")
    ResponseEntity<Boolean> checkEmployeeExists(@PathVariable("id") Long id);

    @GetMapping("/customer/{id}")
    ResponseEntity<EmployeeDto> getCustomerById(@PathVariable("id") Long id);

    @GetMapping("/customer/{id}/exists")
    ResponseEntity<Boolean> checkCustomerExists(@PathVariable("id") Long id);
}
