package com.example.enrollment_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.enrollment_service.entity.Enrollment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Enrollment entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentDTO {

    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private Long courseId;

    @NotNull
    @Size(max = 50)
    private String status;

    private BigDecimal priceAtEnrollment;

    @Size(max = 10)
    private String currency;

    private LocalDateTime enrolledAt;

    private LocalDateTime completedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static EnrollmentDTO fromEntity(Enrollment e) {
        if (e == null) return null;
        return EnrollmentDTO.builder()
                .id(e.getId())
                .userId(e.getUserId())
                .courseId(e.getCourseId())
                .status(e.getStatus())
                .priceAtEnrollment(e.getPriceAtEnrollment())
                .currency(e.getCurrency())
                .enrolledAt(e.getEnrolledAt())
                .completedAt(e.getCompletedAt())
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }

    public Enrollment toEntity() {
        Enrollment e = new Enrollment();
        e.setId(this.id);
        e.setUserId(this.userId);
        e.setCourseId(this.courseId);
        e.setStatus(this.status);
        e.setPriceAtEnrollment(this.priceAtEnrollment);
        e.setCurrency(this.currency);
        e.setEnrolledAt(this.enrolledAt);
        e.setCompletedAt(this.completedAt);
        e.setCreatedAt(this.createdAt);
        e.setUpdatedAt(this.updatedAt);
        return e;
    }
}
