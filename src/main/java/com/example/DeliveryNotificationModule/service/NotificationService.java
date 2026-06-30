package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import java.util.List;
public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto);
    NotificationDto getNotificationById(Long id);
    List<NotificationDto> getAllNotifications();
    NotificationDto updateNotification(Long id, NotificationDto notificationDto);
    String deleteNotification(Long id);
    NotificationDto markAsRead(Long id);
}
