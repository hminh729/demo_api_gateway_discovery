CREATE TABLE enrollments (
                             id BIGSERIAL PRIMARY KEY,

                             user_id BIGINT NOT NULL,
                             course_id BIGINT NOT NULL,

                             status VARCHAR(50) NOT NULL,

                             price_at_enrollment DECIMAL(12,2),
                             currency VARCHAR(10),

                             enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             completed_at TIMESTAMP,

                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT uk_user_course UNIQUE (user_id, course_id)
);