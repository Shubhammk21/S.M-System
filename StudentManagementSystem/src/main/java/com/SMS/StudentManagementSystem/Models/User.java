package com.SMS.StudentManagementSystem.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "Name cannot be empty")
    private String password;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "Name cannot be empty")
    private String role;
    @Pattern(regexp = "[6-9][0-9]{9}",message = "Enter Valid Number")
    private String phoneNumber;
}
