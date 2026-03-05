package com.example.course_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.course_service.entity.Course;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Course entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDTO {

    private Long id;

    @NotNull
    @Size(max = 50)
    private String code;

    @NotNull
    @Size(max = 255)
    private String title;

    private String description;

    @NotNull
    private Long instructorId;

    private BigDecimal price;

    @Size(max = 10)
    private String currency;

    @NotNull
    @Size(max = 50)
    private String status;

    @Size(max = 50)
    private String level;

    @Size(max = 100)
    private String category;

    @Size(max = 500)
    private String thumbnailUrl;

    private LocalDateTime publishedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean isDeleted;

    public static CourseDTO fromEntity(Course c) {
        if (c == null) return null;
        return CourseDTO.builder()
                .id(c.getId())
                .code(c.getCode())
                .title(c.getTitle())
                .description(c.getDescription())
                .instructorId(c.getInstructorId())
                .price(c.getPrice())
                .currency(c.getCurrency())
                .status(c.getStatus())
                .level(c.getLevel())
                .category(c.getCategory())
                .thumbnailUrl(c.getThumbnailUrl())
                .publishedAt(c.getPublishedAt())
                .createdAt(c.getCreatedAt())
                .updatedAt(c.getUpdatedAt())
                .isDeleted(c.getIsDeleted())
                .build();
    }

    public Course toEntity() {
        Course c = new Course();
        c.setId(this.id);
        c.setCode(this.code);
        c.setTitle(this.title);
        c.setDescription(this.description);
        c.setInstructorId(this.instructorId);
        c.setPrice(this.price);
        c.setCurrency(this.currency);
        c.setStatus(this.status);
        c.setLevel(this.level);
        c.setCategory(this.category);
        c.setThumbnailUrl(this.thumbnailUrl);
        c.setPublishedAt(this.publishedAt);
        c.setCreatedAt(this.createdAt);
        c.setUpdatedAt(this.updatedAt);
        c.setIsDeleted(this.isDeleted);
        return c;
    }
}
