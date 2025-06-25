package com.eduhub.enrollment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDto {
    private Long userId;
    private Long courseId;
    private LocalDateTime enrollmentDate;
}
