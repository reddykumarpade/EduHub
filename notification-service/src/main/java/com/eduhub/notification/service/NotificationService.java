package com.eduhub.notification.service;

import com.eduhub.notification.dto.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    public void sendNotification(NotificationRequest request) {
        // Simulate sending an email or message
        log.info("Sending notification to user {}: {}", request.getUserId(), request.getMessage());
    }
}
