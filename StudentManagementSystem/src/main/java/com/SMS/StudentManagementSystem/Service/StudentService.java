package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.DTO.CoursesOfStudent;
import com.SMS.StudentManagementSystem.DTO.StudentUpdateDetail;
import com.SMS.StudentManagementSystem.Exceptions.CourseException;
import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Models.Course;
import com.SMS.StudentManagementSystem.Models.Student;

import java.util.List;

public interface StudentService {

    public Student registerStudent(Student student) throws StudentException;

    public List<Student> getStudentByName(String name) throws StudentException;

    public Student updateEmailAndPhone(StudentUpdateDetail dto) throws StudentException;

    public CoursesOfStudent getCoursesOfStudent (int studentId, String dateOfBirth) throws StudentException;

    public CoursesOfStudent leaveCourse(int studentId, int courseId) throws StudentException, CourseException;

    public CoursesOfStudent converterToCoursesOfStudent(List<Course> courses, Student student);

}