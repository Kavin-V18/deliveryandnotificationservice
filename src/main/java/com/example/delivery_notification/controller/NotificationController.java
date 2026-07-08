package com.example.delivery_notification.controller;

import com.example.delivery_notification.dto.NotificationDto;
import com.example.delivery_notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
      private final  NotificationService notificationService;

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
    @PutMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable int id,@Valid @RequestBody NotificationDto notificationDto){
            return  notificationService.updateNotification(id, notificationDto);
    }
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){
            return notificationService.deleteNotification(id);
    }
}
