package com.example.DeliveryNotificationModule.service;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import com.example.DeliveryNotificationModule.entity.Notification;
import com.example.DeliveryNotificationModule.repository.NotificationRepository;
import com.example.DeliveryNotificationModule.util.NotificationMapper;
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
    public NotificationDto getNotificationById(Long id) {
        Notification existing=notificationRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        NotificationDto notificationDtos= notificationMapper.toDto(existing);
        return  notificationDtos;
    }
    @Override
    public List<NotificationDto> getAllNotifications() {
        return notificationRepository.findAll().stream().map(notificationMapper::toDto).toList();
    }
    @Override
    public NotificationDto updateNotification(Long id, NotificationDto notificationDto) {
        Notification existing=notificationRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        existing.setNotificationType(notificationDto.getNotificationType());
        existing.setMessage(notificationDto.getMessage());
        existing.setIsRead(notificationDto.getIsRead());
        existing.setRecipientRole(notificationDto.getRecipientRole());
        existing.setLast_modified_by(notificationDto.getLast_modified_by());
        Notification updatedEntity=notificationRepository.save(existing);
        return  notificationMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteNotification(Long id) {
        Notification existing=notificationRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        notificationRepository.deleteById(id);
        return "deleted successfully";
    }
    @Override
    public NotificationDto markAsRead(Long id) {
        return null;
    }
}
