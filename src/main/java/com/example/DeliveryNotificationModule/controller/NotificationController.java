package com.example.DeliveryNotificationModule.controller;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import com.example.DeliveryNotificationModule.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
      private final  NotificationService notificationService;
        public NotificationController(NotificationService notificationService){
            this.notificationService=notificationService;
        }
    @GetMapping()
    public List<NotificationDto> getNotifications() {
        return notificationService.getAllNotifications();
    }
    @PostMapping()
    public NotificationDto createNotification(@Valid  @RequestBody NotificationDto notificationDto){
           return notificationService.createNotification(notificationDto);
    }
    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable int id){
            return notificationService.getNotificationById(id);
    }
    @PostMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable int id,@Valid @RequestBody NotificationDto notificationDto){
            return  notificationService.updateNotification(id, notificationDto);
    }
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){
            return notificationService.deleteNotification(id);
    }
}
