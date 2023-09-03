package com.SMS.StudentManagementSystem.Config;

import com.SMS.StudentManagementSystem.Models.User;
import com.SMS.StudentManagementSystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByPhoneNumber(username);

        if(user == null)
            throw new UsernameNotFoundException("Invalid Number provided") ;

        return new UserLogDetails(user);
    }
}
