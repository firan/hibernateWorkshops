package com.example.productdata.Repository;

import com.example.productdata.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudents();

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsPartialData(@Param("firstName") String firstName);

    @Query("from Student where score>:min and score<:max")
    List<Student> findStudentsWithScoresBetween(@Param("min") int min, @Param("max") int max);
}