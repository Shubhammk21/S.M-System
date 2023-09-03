package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.DTO.CoursesOfStudent;
import com.SMS.StudentManagementSystem.DTO.StudentsOfCourse;
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
public class CourseServiceImply implements CourseService{

    @Autowired
    private CourseRepo cr;

    @Autowired
    private StudentRepo sr;

    @Autowired
    private StudentService ss;

    @Override
    public Course addCourse(Course c) throws CourseException {
        return cr.save(c);
    }

    @Override
    public CoursesOfStudent assignCourseToStudent(int studentId, int courseId) throws CourseException, StudentException {

        Course course= cr.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId));
        Student student= sr.findById(studentId).orElseThrow(()-> new StudentException("Invalid StudentId "+ studentId));

        course.getStudents().add(student);
        cr.save(course);
        student.getCourses().add(course);
        return ss.converterToCoursesOfStudent(student.getCourses(),student);

    }

    @Override
    public StudentsOfCourse getStudentsFromCourse(int courseId) throws CourseException {

        Course course= cr.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId));
        if(course.getStudents().isEmpty())
            throw new CourseException("No students are present in the Course: "+ course.getName()) ;

        return converterToStudentsOfCourse(course.getStudents(),course);

    }

    @Override
    public List<Course> getCoursesByTopic(String topicName) throws CourseException {
        List<Course> courses= cr.getCoursesByTopic(topicName);
        if(courses.isEmpty())
            throw new CourseException("Not found with name : "+topicName);
        return courses;
    }

    @Override
    public Course removeCourse(int courseId) throws CourseException {

        Course course= cr.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId: "+courseId));
        cr.delete(course);
        return course;

    }

    @Override
    public StudentsOfCourse converterToStudentsOfCourse(List<Student> students,Course course){
        return new StudentsOfCourse(course.getCourseID(),course.getName(),students);
    }

}
