package com.example.delivery_notification.service;

import com.example.delivery_notification.dto.NotificationDto;
import com.example.delivery_notification.entity.Notification;
import com.example.delivery_notification.repository.NotificationRepository;
import com.example.delivery_notification.util.NotificationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class NotificationServiceImp implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification entity = notificationMapper.toEntity(notificationDto); // DTO -> Entity
        Notification savedEntity = notificationRepository.save(entity);
        return notificationMapper.toDto(savedEntity);
    }
    @Override
    public NotificationDto getNotificationById(int id) {
        Notification existing=notificationRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        return notificationMapper.toDto(existing);

    }
    @Override
    public List<NotificationDto> getAllNotifications() {
        return notificationRepository.findAll().stream().map(notificationMapper::toDto).toList();
    }
    @Override
    public NotificationDto updateNotification(int id, NotificationDto notificationDto) {
        Notification existing=notificationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existing.setMessage(notificationDto.getMessage());
        Notification updatedEntity=notificationRepository.save(existing);
        return  notificationMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteNotification(int id) {
        notificationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        notificationRepository.deleteById(id);
        return "deleted successfully";
    }
    @Override
    public NotificationDto markAsRead(int id) {
        return null;
    }
}
