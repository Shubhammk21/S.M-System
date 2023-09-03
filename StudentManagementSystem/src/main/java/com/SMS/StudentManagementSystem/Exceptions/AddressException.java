package com.SMS.StudentManagementSystem.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressException extends Exception{
    public AddressException(String message){
        super(message);
    }
}
