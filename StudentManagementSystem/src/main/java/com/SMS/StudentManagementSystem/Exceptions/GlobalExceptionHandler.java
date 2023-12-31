package com.SMS.StudentManagementSystem.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // to handle Not found exception
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
                me.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyErrorDetails> illegealArgumentHandler(IllegalArgumentException cnf, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(cnf.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(AddressException.class)
    public ResponseEntity<MyErrorDetails> logInExceptionHandler(AddressException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<MyErrorDetails> logInExceptionHandler(StudentException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);


    }
    @ExceptionHandler(CourseException.class)
    public ResponseEntity<MyErrorDetails> logInExceptionHandler(CourseException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);


    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> logInExceptionHandler(UserException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);


    }

}
