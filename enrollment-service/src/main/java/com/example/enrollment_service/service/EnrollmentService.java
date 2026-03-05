package com.example.enrollment_service.service;

import com.example.enrollment_service.dto.request.EnrollmentRequest;

public interface EnrollmentService {
    void createEnrollment(EnrollmentRequest request);
}
