package com.SMS.StudentManagementSystem.DTO;

import com.SMS.StudentManagementSystem.Models.Course;
import com.SMS.StudentManagementSystem.Models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsOfCourse {

    private int courseID;
    private String name;

    private List<Student> students = new ArrayList<>();
}
