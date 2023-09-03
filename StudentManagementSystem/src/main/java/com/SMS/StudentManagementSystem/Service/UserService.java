package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.Exceptions.UserException;
import com.SMS.StudentManagementSystem.Models.User;

public interface UserService {

    public User registerUser(User user) throws UserException;

    public User registerStudentAsUser(User user) throws UserException;
}
