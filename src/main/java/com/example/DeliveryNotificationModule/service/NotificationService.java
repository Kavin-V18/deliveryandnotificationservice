package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.entity.Notification;
import java.util.List;
public interface NotificationService {
    Notification createNotification(Notification notification);
    Notification getNotificationById(int id);
    List<Notification> getAllNotifications();
    Notification updateNotification(int id, Notification notification);
    String deleteNotification(int id);
    Notification markAsRead(int id);
}
