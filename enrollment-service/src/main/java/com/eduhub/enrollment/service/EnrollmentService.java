package com.eduhub.enrollment.service;

import com.eduhub.enrollment.dto.EnrollmentDto;
import com.eduhub.enrollment.model.Enrollment;
import com.eduhub.enrollment.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentDto enroll(EnrollmentDto dto) {
        Enrollment enrollment = Enrollment.builder()
                .userId(dto.getUserId())
                .courseId(dto.getCourseId())
                .enrollmentDate(LocalDateTime.now())
                .build();
        return mapToDto(repository.save(enrollment));
    }

    public List<EnrollmentDto> getByUserId(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private EnrollmentDto mapToDto(Enrollment enrollment) {
        return EnrollmentDto.builder()
                .userId(enrollment.getUserId())
                .courseId(enrollment.getCourseId())
                .enrollmentDate(enrollment.getEnrollmentDate())
                .build();
    }
}
