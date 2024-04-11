package com.springassignment.springassignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAssignment1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAssignment1Application.class, args);
    }

    @GetMapping("/courses")
    public String getCourses() {
        StringBuilder course = new StringBuilder();
        course.append("<h2>Foundation Courses:</h2>");
        course.append("<ul>");
        course.append("<li>(1)CSC 111F: Computer Literacy For Science</li>");
        course.append("<li>(2)CSC 121F: Introduction To Programming Concept</li>");
        course.append("</ul>");

        course.append("<h2>Undergraduate Courses:</h2>");
        course.append("<ul>");
        course.append("<li>(1)CSC 113: Introduction To Computing And Programming Concept</li>");
        course.append("<li>(2)CSC 121: Elementary Computer Programming</li>");
        course.append("<li>(3)CSC 211: Advanced Programming</li>");
        course.append("<li>(4)CSC 223: Data Structures And Algorithms</li>");
        course.append("<li>(5)CSC 313: Object oriented Programming</li>");
        course.append("</ul>");

        course.append("<h2>Honours Courses:</h2>");
        course.append("<ul>");
        course.append("<li>(1)CSC 501: Mini Project</li>");
        course.append("<li>(2)CSC 512: Computer Network</li>");
        course.append("<li>(3)CSC 513: Distributed And Parallel Computing</li>");
        course.append("<li>(4)CSC 515: Advanced Java</li>");
        course.append("</ul>");

        return course.toString();
    }
}
