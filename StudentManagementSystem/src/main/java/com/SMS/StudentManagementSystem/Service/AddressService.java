package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Models.Address;
import com.SMS.StudentManagementSystem.Models.Student;

public interface AddressService {
    public Student updateStudentAddress(Address address, int studentId) throws StudentException;
    public Student addNewAddress(Address address, int studentId) throws StudentException;
}
