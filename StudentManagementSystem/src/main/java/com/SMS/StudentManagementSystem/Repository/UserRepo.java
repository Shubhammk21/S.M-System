package com.SMS.StudentManagementSystem.Repository;

import com.SMS.StudentManagementSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByPhoneNumber(String pNum);
}
