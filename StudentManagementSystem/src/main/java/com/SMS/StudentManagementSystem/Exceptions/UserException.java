package com.SMS.StudentManagementSystem.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserException extends Exception{
    public UserException(String message){
        super(message);
    }
}
