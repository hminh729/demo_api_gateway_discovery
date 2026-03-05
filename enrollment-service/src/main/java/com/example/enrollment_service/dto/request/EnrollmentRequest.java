package com.example.enrollment_service.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentRequest {
    private Long userId;
    private Long courseId;
}
