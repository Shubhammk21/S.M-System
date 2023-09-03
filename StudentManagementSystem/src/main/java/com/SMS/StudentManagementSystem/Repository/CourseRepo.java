package com.SMS.StudentManagementSystem.Repository;

import com.SMS.StudentManagementSystem.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{

    @Query("Select c from Course c where c.topics LIKE %:m% or c.name LIKE %:m%")
    public List<Course> getCoursesByTopic(@Param("m") String topic);

}