package com.eduhub.course.service;

import com.eduhub.course.dto.CourseDto;
import com.eduhub.course.model.Course;
import com.eduhub.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseDto create(CourseDto dto) {
        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .instructor(dto.getInstructor())
                .price(dto.getPrice())
                .build();
        return mapToDto(courseRepository.save(course));
    }

    public List<CourseDto> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public CourseDto getById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return mapToDto(course);
    }

    public CourseDto update(Long id, CourseDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructor(dto.getInstructor());
        course.setPrice(dto.getPrice());

        return mapToDto(courseRepository.save(course));
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    private CourseDto mapToDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .instructor(course.getInstructor())
                .price(course.getPrice())
                .build();
    }
}
