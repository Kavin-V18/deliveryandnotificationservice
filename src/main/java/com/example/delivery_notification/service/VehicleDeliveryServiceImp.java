package com.example.delivery_notification.service;


import com.example.delivery_notification.client.EmployeeCustomerClient;
import com.example.delivery_notification.client.QualityInventoryClient;
import  com.example.delivery_notification.dto.VehicleDeliveryDto;
import com.example.delivery_notification.entity.VehicleDelivery;
import com.example.delivery_notification.repository.VehicleDeliveryRepository;
import com.example.delivery_notification.util.VehicleDeliveryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleDeliveryServiceImp implements VehicleDeliveryService   {

    private final VehicleDeliveryRepository vehicleDeliveryRepository;
    private final VehicleDeliveryMapper vehicleDeliveryMapper;
    private final EmployeeCustomerClient employeeCustomerClient;
    private final QualityInventoryClient qualityInventoryClient;
    private final NotificationService notificationService;
    @Override
    public VehicleDeliveryDto createVehicleDelivery(VehicleDeliveryDto vehicleDeliveryDto) {
        Boolean employeeExist=employeeCustomerClient.checkEmployeeExists(vehicleDeliveryDto.getDeliveredByEmployeeId()).getBody();
        if (Boolean.FALSE.equals(employeeExist)) {
            throw new EntityNotFoundException("Employee not found with id : " + vehicleDeliveryDto.getDeliveredByEmployeeId());
        }
        Boolean customerExist=employeeCustomerClient.checkCustomerExists(vehicleDeliveryDto.getCustomerId()).getBody();
        if (Boolean.FALSE.equals(customerExist)) {
            throw new EntityNotFoundException("Customer not found with id : " + vehicleDeliveryDto.getCustomerId());
        }
        Boolean inventoryExist=qualityInventoryClient.checkInventoryExists(vehicleDeliveryDto.getVehicleId()).getBody();
        if (Boolean.FALSE.equals(inventoryExist)) {
            throw new EntityNotFoundException("Inventory not found with id : " + vehicleDeliveryDto.getVehicleId());
        }
        VehicleDelivery entity = vehicleDeliveryMapper.toEntity(vehicleDeliveryDto); // DTO -> Entity
        VehicleDelivery savedEntity = vehicleDeliveryRepository.save(entity);

        return vehicleDeliveryMapper.toDto(savedEntity);
    }
    @Override
    public VehicleDeliveryDto getVehicleDeliveryById(int id) {
        VehicleDelivery existing=vehicleDeliveryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
          return  vehicleDeliveryMapper.toDto(existing);
    }
    @Override
    public List<VehicleDeliveryDto> getAllVehicleDelivery() {
        return vehicleDeliveryRepository.findAll().stream().map(vehicleDeliveryMapper::toDto).toList();
    }
    @Override
    public VehicleDeliveryDto updateVehicleDelivery(int id, VehicleDeliveryDto vehicleDeliveryDto) {
        Boolean employeeExist=employeeCustomerClient.checkEmployeeExists(vehicleDeliveryDto.getDeliveredByEmployeeId()).getBody();
        if (Boolean.FALSE.equals(employeeExist)) {
            throw new EntityNotFoundException("Employee not found with id : " + vehicleDeliveryDto.getDeliveredByEmployeeId());
        }
        Boolean customerExist=employeeCustomerClient.checkCustomerExists(vehicleDeliveryDto.getCustomerId()).getBody();
        if (Boolean.FALSE.equals(customerExist)) {
            throw new EntityNotFoundException("Customer not found with id : " + vehicleDeliveryDto.getCustomerId());
        }
        Boolean inventoryExist=qualityInventoryClient.checkInventoryExists(vehicleDeliveryDto.getVehicleId()).getBody();
        if (Boolean.FALSE.equals(inventoryExist)) {
            throw new EntityNotFoundException("Inventory not found with id : " + vehicleDeliveryDto.getVehicleId());
        }
        VehicleDelivery existing=vehicleDeliveryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
         existing.setInvoiceAmount(vehicleDeliveryDto.getInvoiceAmount());
         existing.setInvoiceNumber(vehicleDeliveryDto.getInvoiceNumber());
         existing.setDeliveryDate(vehicleDeliveryDto.getDeliveryDate());
         existing.setDeliveredByEmployeeId(vehicleDeliveryDto.getDeliveredByEmployeeId());
         existing.setVehicleId(vehicleDeliveryDto.getVehicleId());
         existing.setCustomerId(vehicleDeliveryDto.getCustomerId());
         VehicleDelivery savedEntity = vehicleDeliveryRepository.save(existing);
         return vehicleDeliveryMapper.toDto(savedEntity);
    }
    @Override
    public void deleteVehicleDelivery(int id) {
        vehicleDeliveryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        vehicleDeliveryRepository.deleteById(id);
    }
}
