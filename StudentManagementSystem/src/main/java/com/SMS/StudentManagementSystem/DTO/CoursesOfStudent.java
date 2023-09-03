package com.SMS.StudentManagementSystem.DTO;

import com.SMS.StudentManagementSystem.Models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesOfStudent {
    private int StudentId;
    private String name;

    private List<Course> courses = new ArrayList<>();
}
