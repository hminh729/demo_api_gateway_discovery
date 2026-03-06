package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouteConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("enrollment-service", r -> r
                        .path("/api/enrollments/**")
                        .uri("lb://enrollment-service"))

                .route("course-service", r -> r
                        .path("/api/courses/**")
                        .uri("lb://course-service"))
                .build();
    }
}