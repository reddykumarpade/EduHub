package com.eduhub.notification.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {
    private Long userId;
    private String message;
}
