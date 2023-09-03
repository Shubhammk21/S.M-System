package com.SMS.StudentManagementSystem.Service;

import com.SMS.StudentManagementSystem.Exceptions.StudentException;
import com.SMS.StudentManagementSystem.Models.Address;
import com.SMS.StudentManagementSystem.Models.Student;
import com.SMS.StudentManagementSystem.Repository.AddressRepo;
import com.SMS.StudentManagementSystem.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImply implements AddressService{

    @Autowired
    private AddressRepo ar;
    @Autowired
    private StudentRepo sr;

    @Override
    public Student updateStudentAddress(Address address,int studentId) throws StudentException {

        Student student= sr.findById(studentId).orElseThrow(()-> new StudentException("Invalid StudentId "+ studentId));

        student.getAddresses().forEach(i->{
            if(i.getAddressId() == address.getAddressId()) {
                ar.save(address) ;
            }
        });

        return student;
    }

    @Override
    public Student addNewAddress(Address address, int studentId) throws StudentException {

        Student student= sr.findById(studentId).orElseThrow(()-> new StudentException("Invalid StudentId "+ studentId));
        student.getAddresses().add(address);

        return sr.save(student);
    }

}
