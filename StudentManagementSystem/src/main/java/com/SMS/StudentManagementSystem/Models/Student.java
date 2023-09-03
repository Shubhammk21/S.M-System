package com.SMS.StudentManagementSystem.Models;

import com.SMS.StudentManagementSystem.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @NotNull()
    @NotBlank()
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull()
    @NotBlank()
    @NotEmpty(message = "name cannot be empty")
    private LocalDate dob;
    @NotNull()
    @NotBlank()
    @NotEmpty(message = "name cannot be empty")
    private Gender gender;
    @NotNull()
    @NotBlank()
    @NotEmpty(message = "name cannot be empty")
    private String parentName;
    @NotNull()
    @NotBlank()
    @NotEmpty(message = "name cannot be empty")
    @Email(message = "Invalid format")
    private String email;

    @Pattern(regexp = "[6-9][0-9]{9}",message = "Enter Valid Number")
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses= new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
    private List<Course> courses= new ArrayList<>();
}
