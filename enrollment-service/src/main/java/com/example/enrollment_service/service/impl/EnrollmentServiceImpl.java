package com.example.enrollment_service.service.impl;

import com.example.enrollment_service.client.CourseClient;
import com.example.enrollment_service.dto.CourseDTO;
import com.example.enrollment_service.entity.Enrollment;
import com.example.enrollment_service.repository.EnrollmentRepository;
import com.example.enrollment_service.dto.request.EnrollmentRequest;
import com.example.enrollment_service.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseClient courseClient;

    @Override
    public void createEnrollment(EnrollmentRequest request) {
        CourseDTO course = courseClient.getCourseById(request.getCourseId());

        if (course == null) {
            throw new RuntimeException("Course not found");
        }
        
        if (enrollmentRepository.existsByUserIdAndCourseId(request.getUserId(), request.getCourseId())) {
            throw new RuntimeException("User is already enrolled in this course");
        }

        Enrollment enrollment = Enrollment.builder()
                .userId(request.getUserId())
                .courseId(request.getCourseId())
                .priceAtEnrollment(course.getPrice())
                .status("enrolled")
                .currency(course.getCurrency())

                .build();

        enrollmentRepository.save(enrollment);

    }
}
