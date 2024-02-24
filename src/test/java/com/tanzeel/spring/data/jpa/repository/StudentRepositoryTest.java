package com.tanzeel.spring.data.jpa.repository;

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
        Student student = Student
                            .builder()
                .firstName("Md Tanzeel")
                .lastName("Mujtaba")
                .emailId("001tanzeel@gmail.com")
                .guardianName("Md Imteyaz")
                .guardianEmail("abc@gmail.com")
                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("List of students: " + studentList);
    }

}