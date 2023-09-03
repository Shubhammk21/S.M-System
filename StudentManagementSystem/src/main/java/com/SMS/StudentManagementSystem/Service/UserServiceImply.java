package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.Exceptions.UserException;
import com.SMS.StudentManagementSystem.Models.User;
import com.SMS.StudentManagementSystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImply implements UserService{

    @Autowired
    private UserRepo ur;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(User user) throws UserException {

        if(ur.findByPhoneNumber(user.getPhoneNumber()) != null) {
            throw new UserException("Phone number is already Registered " + user.getPhoneNumber()) ;
        }

        user.setRole("ROLE_"+user.getRole());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return ur.save(user);

    }
    @Override
    public User registerStudentAsUser(User user) throws UserException {

        if(ur.findByPhoneNumber(user.getPhoneNumber()) != null) {
            throw new UserException("Phone number is already Registered " + user.getPhoneNumber()) ;
        }
        user.setRole("ROLE_NORMAL");

        return ur.save(user);

    }

}
