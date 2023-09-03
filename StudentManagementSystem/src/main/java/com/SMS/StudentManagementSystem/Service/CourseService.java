package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.DTO.CoursesOfStudent;
import com.SMS.StudentManagementSystem.DTO.StudentsOfCourse;
import com.SMS.StudentManagementSystem.Exceptions.CourseException;
import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Models.Course;
import com.SMS.StudentManagementSystem.Models.Student;

import java.util.List;

public interface CourseService {

    public Course addCourse(Course c) throws CourseException;

    public CoursesOfStudent assignCourseToStudent(int studentId, int courseId) throws CourseException, StudentException;

    public StudentsOfCourse getStudentsFromCourse(int courseId) throws CourseException;

    public List<Course> getCoursesByTopic(String topicName) throws CourseException;

    public Course removeCourse(int courseId) throws CourseException;

    public StudentsOfCourse converterToStudentsOfCourse(List<Student> students,Course course);
}
