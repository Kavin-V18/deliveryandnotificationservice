package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import com.example.DeliveryNotificationModule.entity.Notification;
import java.util.List;
public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto);
    NotificationDto getNotificationById(int id);
    List<NotificationDto> getAllNotifications();
    NotificationDto updateNotification(int id, NotificationDto notificationDto);
    String deleteNotification(int id);
    NotificationDto markAsRead(int id);
}
