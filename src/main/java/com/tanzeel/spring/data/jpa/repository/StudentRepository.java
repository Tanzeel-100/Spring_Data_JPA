package com.tanzeel.spring.data.jpa.repository;

import com.tanzeel.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student findStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String findStudentFirstNameByEmailAddress(String emailId);

    //Native Query
    @Query(
            value = "select * from tbl_students s where s.student_email = ?1",
            nativeQuery = true
    )
    public Student findStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(
            value = "select * from tbl_students s where s.student_email = :emailId",
            nativeQuery = true
    )
    public Student findStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

}
