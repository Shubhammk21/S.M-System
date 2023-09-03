package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.DTO.*;
import com.SMS.StudentManagementSystem.Exceptions.CourseException;
import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Models.Course;
import com.SMS.StudentManagementSystem.Models.Student;
import com.SMS.StudentManagementSystem.Repository.CourseRepo;
import com.SMS.StudentManagementSystem.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImply implements StudentService{

    @Autowired
    private StudentRepo sr;

    @Autowired
    private CourseRepo cr;

    @Override
    public Student registerStudent(Student student) throws StudentException {
        return sr.save(student);
    }

    @Override
    public List<Student> getStudentByName(String name) throws StudentException {
        List<Student> students= sr.getStudentsByName(name);
        if(students.isEmpty())
            throw new StudentException("No student found with name : "+name);

        return students;

    }

    @Override
    public Student updateEmailAndPhone(StudentUpdateDetail dto) throws StudentException {

        Student student= sr.findById(dto.getStudentId()).orElseThrow(()->new StudentException("Invalid data"));
        if(!student.getDob().equals(dto.getDob())){
            throw new StudentException("Invalid data");
        }
        student.setEmail(dto.getNewEmail());
        student.setPhoneNumber(dto.getNewPhoneNumber());
        return sr.save(student);

    }

    @Override
    public CoursesOfStudent getCoursesOfStudent(int studentId, String dateOfBirth) throws StudentException {
        Student student= sr.findById(studentId).orElseThrow(()-> new StudentException("Invalid StudentId "+ studentId));
        if(student.getCourses().isEmpty())
            throw new StudentException("No courses are present in the Student: "+ student.getName()) ;

        return converterToCoursesOfStudent(student.getCourses(),student);

    }

    @Override
    public CoursesOfStudent leaveCourse(int studentId, int courseId) throws StudentException, CourseException{

        Student student= sr.findById(studentId).orElseThrow(()->new StudentException("Invalid StudentId "+ studentId));
        Course course= cr.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId));

        student.getCourses().remove(course);
        course.getStudents().remove(student);

        cr.save(course);
        sr.save(student);

        return converterToCoursesOfStudent(student.getCourses(),student);
    }

    @Override
    public CoursesOfStudent converterToCoursesOfStudent(List<Course> courses, Student student) {
        return new CoursesOfStudent(student.getStudentId(),student.getName(),courses);
    }

}
