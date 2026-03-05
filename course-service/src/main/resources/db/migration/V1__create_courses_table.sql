CREATE TABLE courses (
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

                         code VARCHAR(50) NOT NULL UNIQUE,
                         title VARCHAR(255) NOT NULL,
                         description TEXT,

                         instructor_id BIGINT NOT NULL,

                         price DECIMAL(12,2) DEFAULT 0,
                         currency VARCHAR(10) DEFAULT 'VND',

                         status VARCHAR(50) NOT NULL,

                         level VARCHAR(50),
                         category VARCHAR(100),

                         thumbnail_url VARCHAR(500),

                         published_at TIMESTAMP,

                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                         is_deleted BOOLEAN DEFAULT FALSE
);