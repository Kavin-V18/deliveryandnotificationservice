package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import com.example.DeliveryNotificationModule.entity.Notification;
import com.example.DeliveryNotificationModule.repository.NotificationRepository;
import com.example.DeliveryNotificationModule.util.NotificationMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationServiceImp implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    public NotificationServiceImp(NotificationRepository notificationRepository, NotificationMapper notificationMapper){
            this.notificationRepository=notificationRepository;
            this.notificationMapper=notificationMapper;
    }
    @Override
    public Notification createNotification(Notification notification) {
       return notificationRepository.save(notification);
    }
    @Override
    public Notification getNotificationById(int id) {
        return notificationRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Notification not found with id: " + id));
    }
    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
    @Override
    public Notification updateNotification(int id,Notification notification) {
        Notification existing = getNotificationById(id);
        existing.setRecipientRole(notification.getRecipientRole());
        existing.setMessage(notification.getMessage());
        existing.setNotificationType(notification.getNotificationType());
        existing.setIsRead(notification.getIsRead());

        return notificationRepository.save(existing);
    }
    @Override
    public String deleteNotification(int id) {

        Notification existing = getNotificationById(id);
        notificationRepository.delete(existing);
        return "deleted successfully";
    }
    @Override
    public Notification markAsRead(int id) {
        Notification notification = getNotificationById(id);
        notification.setIsRead(true);
        return notificationRepository.save(notification);
    }
}
