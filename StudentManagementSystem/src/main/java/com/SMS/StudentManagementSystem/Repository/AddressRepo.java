package com.SMS.StudentManagementSystem.Repository;

import com.SMS.StudentManagementSystem.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {

}
