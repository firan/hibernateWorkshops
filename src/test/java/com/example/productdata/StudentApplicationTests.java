package com.example.productdata;

import com.example.productdata.Entity.Student;
import com.example.productdata.Repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

// Query, Delete, Native Query
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {

    @Autowired
    StudentRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testStudentCreate() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Ferguson");
        student.setScore(88);

        Student student2 = new Student();
        student2.setFirstName("Bill");
        student2.setLastName("Gates");
        student2.setScore(75);

        repository.save(student);
        repository.save(student2);
    }

    @Test
    public void findAllStudents() {
        repository.findAllStudents(
                PageRequest.of(0, 5, Sort.Direction.DESC, "firstName"))
                .forEach(student ->
                        System.out.println(student.toString()
                        )
                );
    }

    @Test
    public void findAllStudentsNames() {
        repository.findAllStudentsPartialData().forEach(stnames -> System.out.println(stnames[0] + " " + stnames[1]));
    }

    @Test
    public void findStudentsByScore() {
        repository.findStudentsWithScoresBetween(10, 100).forEach(students -> System.out.println(students.toString()));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteStudentsByFirstName() {
        repository.deleteStudentsByFirstName("Bill");
    }

    @Test
    public void findAllStudentsNQ() {
        repository.findAllStudentsNQ()
                .forEach(student ->
                        System.out.println(student.toString()
                        )
                );
    }

    @Test
    public void findByFirstNameNQ() {
        repository.findByFirstNameNQ("Bill")
                .forEach(student ->
                        System.out.println(student.toString()
                        )
                );
    }
}