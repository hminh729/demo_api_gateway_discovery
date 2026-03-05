package com.example.enrollment_service.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

}
