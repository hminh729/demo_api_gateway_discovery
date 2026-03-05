package com.example.course_service.service;

import com.example.course_service.dto.CourseDTO;
import org.springframework.http.ResponseEntity;

public interface CourseService {
    CourseDTO getCourse(Long id);

    CourseDTO createCourse(CourseDTO request);

    void deleteCourse(Long id);
}
