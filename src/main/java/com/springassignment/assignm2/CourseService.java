package com.springassignment.assignm2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class CourseService {
    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseByCode(String code) {
        return courses.stream()
                .filter(course -> course.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(String code, Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equals(code)) {
                courses.set(i, updatedCourse);
                return updatedCourse;
            }
        }
        return null;
    }

    public void deleteCourse(String code) {
        courses.removeIf(course -> course.getCode().equals(code));
}
}
