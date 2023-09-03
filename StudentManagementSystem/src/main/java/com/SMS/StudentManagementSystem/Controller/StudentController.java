package com.SMS.StudentManagementSystem.Controller;

import com.SMS.StudentManagementSystem.DTO.*;
import com.SMS.StudentManagementSystem.Exceptions.CourseException;
import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Models.Address;
import com.SMS.StudentManagementSystem.Models.Course;
import com.SMS.StudentManagementSystem.Models.Student;
import com.SMS.StudentManagementSystem.Service.AddressService;
import com.SMS.StudentManagementSystem.Service.CourseService;
import com.SMS.StudentManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService ss;
    @Autowired(required = false)
    private CourseService cs;

    @Autowired
    private AddressService as;

    @PatchMapping("/students/update/")
    public ResponseEntity<Student> updateEmailAndPhoneHandler(@RequestBody StudentUpdateDetail sud)
            throws StudentException {

        Student studentDTO = ss.updateEmailAndPhone(sud);
        return new ResponseEntity<Student>(studentDTO, HttpStatus.OK);

    }

    @PatchMapping("/students/update/address")
    public ResponseEntity<Student> updateAddressHandler(@Valid @RequestBody Address address, @RequestParam("studentID") int studentID)
            throws StudentException {

        Student student = as.updateStudentAddress(address, studentID);
        return new ResponseEntity<Student>(student, HttpStatus.OK);

    }

    @PutMapping("/students/add/address")
    public ResponseEntity<Student> addAddressHandler(@Valid @RequestBody Address address, @RequestParam("studentID") int studentID)
            throws StudentException {

        Student student = as.addNewAddress(address, studentID);
        return new ResponseEntity<Student>(student, HttpStatus.OK);

    }

    @DeleteMapping("/students/courses")
    public ResponseEntity<CoursesOfStudent> leaveCourseHandler(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId) throws StudentException, CourseException {

        CoursesOfStudent cos = ss.leaveCourse(studentId, courseId);
        return new ResponseEntity<CoursesOfStudent>(cos, HttpStatus.OK);

    }

    @GetMapping("/students/courses")
    public ResponseEntity<CoursesOfStudent> getStudentCoursesHandler(@RequestParam("studentId") int studentId,
                                                                  @RequestParam("dob,dd-MM-yyyy") String dateOfBirth) throws StudentException{

        CoursesOfStudent cos = ss.getCoursesOfStudent(studentId, dateOfBirth) ;
        return new ResponseEntity<CoursesOfStudent>(cos, HttpStatus.OK);

    }
    @GetMapping("/courses/topic")
    public ResponseEntity<List<Course>> getCoursesByTopic(@RequestParam("topicName") String topicName) throws CourseException {

        List<Course> courses=  cs.getCoursesByTopic(topicName);
        return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);

    }
}
