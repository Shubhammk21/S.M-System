package com.SMS.StudentManagementSystem.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CourseException extends Exception {
    public CourseException(String message){
        super(message);
    }
}
