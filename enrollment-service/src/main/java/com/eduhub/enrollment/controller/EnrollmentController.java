package com.eduhub.enrollment.controller;

import com.eduhub.enrollment.dto.EnrollmentDto;
import com.eduhub.enrollment.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDto> enroll(@RequestBody EnrollmentDto dto) {
        return ResponseEntity.ok(enrollmentService.enroll(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EnrollmentDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(enrollmentService.getByUserId(userId));
    }
}
