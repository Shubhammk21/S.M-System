package com.SMS.StudentManagementSystem.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentException extends Exception {
    public StudentException(String message){
        super(message);
    }
}
