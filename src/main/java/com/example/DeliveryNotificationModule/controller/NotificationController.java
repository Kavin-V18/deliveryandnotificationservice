package com.example.DeliveryNotificationModule.controller;


import com.example.DeliveryNotificationModule.entity.Notification;
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
    public List<Notification> getNotifications() {
        return notificationService.getAllNotifications();
    }
    @PostMapping()
    public  Notification createNotification(@Valid  @RequestBody Notification notification){
           return notificationService.createNotification(notification);
    }
    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable int id){
            return notificationService.getNotificationById(id);
    }
    @PostMapping("/{id}")
    public Notification updateNotification(@PathVariable int id,@Valid @RequestBody Notification notification){
            return  notificationService.updateNotification(id, notification);
    }
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){
            return notificationService.deleteNotification(id);
    }
}
