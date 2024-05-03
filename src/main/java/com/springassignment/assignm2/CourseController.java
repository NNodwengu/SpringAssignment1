package com.springassignment.assignm2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Validated

public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Course> getCourseByCode(@PathVariable String code) {
        Course course = courseService.getCourseByCode(code);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
        Course savedCourse = courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Course> updateCourse(@PathVariable String code, @Valid @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(code, course);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String code) {
        courseService.deleteCourse(code);
        Course deletedCourse = courseService.getCourseByCode(code);
        if (deletedCourse == null) {
            return ResponseEntity.noContent().build(); // Course successfully deleted
        } else {
            return ResponseEntity.notFound().build(); // Course not found or deletion failed
        }
    }

    // New mappings for CRUD operations
    @GetMapping("/add")
    public String showAddCourseForm() {
        // Return HTML page for adding a new course
        return "add_course_form"; // Assuming you have a HTML template for the add course form
    }
    @GetMapping("/edit/{code}")
    public String showEditCourseForm(@PathVariable String code) {
        // Return HTML page for editing a course
        // You may need to fetch the course by its code and pass it to the HTML template
        return "edit_course_form"; // Assuming you have a HTML template for the edit course form
    }

    @GetMapping("/delete/{code}")
    public String showDeleteCourseForm(@PathVariable String code) {
        // Return HTML page for deleting a course
        // You may need to fetch the course by its code and pass it to the HTML template
        return "delete_course_confirmation"; // Assuming you have a HTML template for the delete course confirmation
    }
}

