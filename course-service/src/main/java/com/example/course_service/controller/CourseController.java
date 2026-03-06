package com.example.course_service.controller;

import com.example.course_service.dto.CourseDTO;
import com.example.course_service.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    // get a course
//    @GetMapping("/{id}")
//    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
//        CourseDTO courseDTO = courseService.getCourse(id);
//        return ResponseEntity.ok(courseDTO);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(
            @PathVariable Long id,
            @RequestHeader Map<String, String> headers) {

        log.info("==== Incoming headers from Enrollment Service ====");
        headers.forEach((key, value) -> log.info("{} : {}", key, value));
        log.info("=================================================");

        CourseDTO courseDTO = courseService.getCourse(id);
        return ResponseEntity.ok(courseDTO);
    }

    // add a course api
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    // delete course by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
