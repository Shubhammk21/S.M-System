package com.SMS.StudentManagementSystem.Controller;

import com.SMS.StudentManagementSystem.DTO.*;
import com.SMS.StudentManagementSystem.Exceptions.CourseException;
import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Exceptions.UserException;
import com.SMS.StudentManagementSystem.Models.Course;
import com.SMS.StudentManagementSystem.Models.Student;
import com.SMS.StudentManagementSystem.Models.User;
import com.SMS.StudentManagementSystem.Service.CourseService;
import com.SMS.StudentManagementSystem.Service.StudentService;
import com.SMS.StudentManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private UserService us;

    @Autowired(required = false)
    private CourseService cs;

    @Autowired
    private StudentService ss;

    @PostMapping("/admin/register")
    public ResponseEntity<User> registerAdminHandler(@Valid @RequestBody User user) throws UserException{

        User registeredUser =  us.registerUser(user) ;
        return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED) ;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/courses/")
    public ResponseEntity<Course> addCourseHandler(@Valid @RequestBody Course course) throws CourseException {

        Course savedCourse = cs.addCourse(course);
        return new ResponseEntity<Course>(savedCourse,HttpStatus.CREATED) ;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/courses/assign")
    public ResponseEntity<CoursesOfStudent> assignStudentToCourseHandler(@RequestParam("studentId") int studentId,
                                                                      @RequestParam("courseId") int courseId) throws CourseException, StudentException{

        CoursesOfStudent assignedCourse =  cs.assignCourseToStudent(studentId, courseId);
        return new ResponseEntity<CoursesOfStudent>(assignedCourse,HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/courses/")
    public ResponseEntity<StudentsOfCourse> getStudentsFromCourseHandler(@RequestParam int courseId) throws CourseException {

        StudentsOfCourse courseStudents =  cs.getStudentsFromCourse(courseId);
        return new ResponseEntity<StudentsOfCourse>(courseStudents,HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/courses/")
    public ResponseEntity<Course> removeCourseHandler(@RequestParam int courseId) throws CourseException {

        Course removedCourse =  cs.removeCourse(courseId);
        return new ResponseEntity<Course>(removedCourse,HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students/")
    public ResponseEntity<Student> registerStudentHandler(@Valid @RequestBody Student student)
            throws StudentException, UserException {

        Student registeredStudent = ss.registerStudent(student);
        return new ResponseEntity<Student>(registeredStudent, HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/students/")
    public ResponseEntity<List<Student>> getStudentsByNameHandler(@RequestParam("name") String name)
            throws StudentException {

        List<Student> studentsList = ss.getStudentByName(name);
        return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);

    }

}
