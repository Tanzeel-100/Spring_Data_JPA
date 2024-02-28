package com.tanzeel.spring.data.jpa.repository;

import com.tanzeel.spring.data.jpa.entity.Course;
import com.tanzeel.spring.data.jpa.entity.CourseMaterial;
import com.tanzeel.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courseList =  courseRepository.findAll();
        System.out.println("List of courses:" + courseList);
    }

    @Test
    public void saveCourse() {
        Teacher teacher = Teacher.builder()
                .firstName("Virat")
                .lastName("Kohli")
                .build();

        Course course = Course.builder()
                .title("DBMS")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}