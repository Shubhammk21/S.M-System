package com.SMS.StudentManagementSystem.Repository;

import com.SMS.StudentManagementSystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("Select s from Student s where s.name LIKE %:name% ")
    public List<Student> getStudentsByName(String name) ;

}
