package com.example.course_service.service.impl;

import com.example.course_service.dto.CourseDTO;
import com.example.course_service.entity.Course;
import com.example.course_service.repository.CourseRepository;
import com.example.course_service.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseDTO getCourse(Long id) {
        log.info("Inside getCourse() of CourseServiceImpl");

        Course course = courseRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Course not found")
                );
        return CourseDTO.fromEntity(course);
    }

    @Override
    public CourseDTO createCourse(CourseDTO request) {
        log.info("Inside createCourse() of CourseServiceImpl");
        Course course = Course.builder()
                .code(request.getCode())
                .title(request.getTitle())
                .description(request.getDescription())
                .instructorId(request.getInstructorId())
                .price(request.getPrice())
                .currency(request.getCurrency())
                .status(request.getStatus())
                .level(request.getLevel())
                .category(request.getCategory())
                .thumbnailUrl(request.getThumbnailUrl())
                .publishedAt(request.getPublishedAt())
                .isDeleted(false)
                .build();

        Course savedCourse = courseRepository.save(course);
        return CourseDTO.fromEntity(savedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        log.info("Inside deleteCourse() of CourseServiceImpl");
        Course course = courseRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Course not found")
                );
        courseRepository.delete(course);
    }
}
