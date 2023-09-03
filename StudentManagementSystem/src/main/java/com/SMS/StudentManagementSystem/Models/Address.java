package com.SMS.StudentManagementSystem.Models;

import com.SMS.StudentManagementSystem.Enums.AddressType;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @NotNull(message = "area cannot be Null")
    @NotBlank(message = "area cannot be blank")
    @NotEmpty(message = "area cannot be empty")
    private String area;

    @NotNull(message = "state cannot be Null")
    @NotBlank(message = "state cannot be blank")
    @NotEmpty(message = "state cannot be empty")
    private String state;

    @NotNull(message = "district cannot be Null")
    @NotBlank(message = "district cannot be blank")
    @NotEmpty(message = "district cannot be empty")
    private String district;

    @NotNull(message = "pinCode cannot be Null")
    @NotBlank(message = "pinCode cannot be blank")
    @NotEmpty(message = "pinCode cannot be empty")
    private String pinCode;
    private AddressType addressType;
}
