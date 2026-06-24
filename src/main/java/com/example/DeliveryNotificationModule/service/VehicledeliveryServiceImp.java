package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.VehicleDeliveryDto;
import com.example.DeliveryNotificationModule.entity.VehicleDelivery;
import com.example.DeliveryNotificationModule.repository.VehicleDeliveryRepository;
import com.example.DeliveryNotificationModule.util.VehicleDeliveryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicledeliveryServiceImp implements VehicleDeliveryService   {

    private final VehicleDeliveryRepository vehicleDeliveryRepository;
    private final VehicleDeliveryMapper vehicleDeliveryMapper;


    @Override
    public VehicleDeliveryDto createVehicleDelivery(VehicleDeliveryDto vehicleDeliveryDto) {
        VehicleDelivery entity = vehicleDeliveryMapper.toEntity(vehicleDeliveryDto); // DTO -> Entity
        VehicleDelivery savedEntity = vehicleDeliveryRepository.save(entity);
        return vehicleDeliveryMapper.toDto(savedEntity);
    }
    @Override
    public VehicleDeliveryDto getVehicleDeliveryById(int id) {
        VehicleDelivery existing=vehicleDeliveryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        VehicleDeliveryDto vehicleDeliveryDto= vehicleDeliveryMapper.toDto(existing);
        return  vehicleDeliveryDto;
    }
    @Override
    public List<VehicleDeliveryDto> getAllvehicleDelivery() {
        return vehicleDeliveryRepository.findAll().stream().map(vehicleDeliveryMapper::toDto).toList();
    }
    @Override
    public VehicleDeliveryDto updateVehicleDelivery(int id, VehicleDeliveryDto vehicleDeliveryDto) {
        VehicleDelivery existing=vehicleDeliveryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
         existing.setInvoiceAmount(vehicleDeliveryDto.getInvoiceAmount());
         existing.setInvoiceNumber(vehicleDeliveryDto.getInvoiceNumber());
         existing.setDeliveryDate(vehicleDeliveryDto.getDeliveryDate());
         existing.setDeliveredByEmployeeId(vehicleDeliveryDto.getDeliveredByEmployeeId());
         VehicleDelivery savedEntity = vehicleDeliveryRepository.save(existing);
         return vehicleDeliveryMapper.toDto(savedEntity);
    }

    @Override
    public void deleteVehicleDelivery(int id) {
        VehicleDelivery existing=vehicleDeliveryRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        vehicleDeliveryRepository.deleteById(id);
    }
}
