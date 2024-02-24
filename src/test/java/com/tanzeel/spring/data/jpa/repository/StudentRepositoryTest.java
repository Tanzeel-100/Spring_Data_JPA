package com.tanzeel.spring.data.jpa.repository;

import com.tanzeel.spring.data.jpa.entity.Guardian;
import com.tanzeel.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save() {

        Guardian guardian = Guardian.builder()
                .email("abc@gmail.com")
                .name("David")
                .mobile("0987654321")
                .build();

        Student student = Student
                            .builder()
                .firstName("Peter")
                .lastName("Marks")
                .emailId("test@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("List of students: " + studentList);
    }

}