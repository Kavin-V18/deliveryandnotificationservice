package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.entity.VehicleDelivery;
import com.example.DeliveryNotificationModule.repository.VehicleDeliveryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VehicledeliveryServiceImp implements VehicleDeliveryService   {

    private final VehicleDeliveryRepository vehicleDeliveryRepository;

    public VehicledeliveryServiceImp(VehicleDeliveryRepository vehicleDeliveryRepository){
          this.vehicleDeliveryRepository=vehicleDeliveryRepository;
    }
@Override
    public VehicleDelivery createVehicleDelivery(VehicleDelivery vehicleDelivery){

          return vehicleDeliveryRepository.save(vehicleDelivery);
    }
    @Override
    public VehicleDelivery getVehicleDeliveryById(int id){

        return vehicleDeliveryRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicledelivery not found with id: " + id));
    }
    @Override
    public List<VehicleDelivery> getAllvehicleDelivery(){

         return vehicleDeliveryRepository.findAll();
    }
   @Override
    public VehicleDelivery updateVehicleDelivery(int id,VehicleDelivery vehicleDelivery){
           VehicleDelivery existing=getVehicleDeliveryById(id);
               existing.setInvoiceNumber(vehicleDelivery.getInvoiceNumber());
               existing.setInvoiceAmount(vehicleDelivery.getInvoiceAmount());
               existing.setDeliveryDate(vehicleDelivery.getDeliveryDate());
               return  vehicleDeliveryRepository.save(existing);
   }
   @Override
    public void deleteVehicleDelivery(int id){
           VehicleDelivery existing=getVehicleDeliveryById(id);
           vehicleDeliveryRepository.delete(existing);
   }
}
