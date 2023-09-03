package com.SMS.StudentManagementSystem.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "courseName cannot be empty")
    private String name;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "cannot be empty")
    private String courseType;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "description cannot be empty")
    @Size(min = 5,max = 225,message = "description size should be of 5-225")
    private String description;
    @NotNull()
    @NotBlank()
    @NotEmpty(message = "cannot be empty")
    private String duration;

    @NotNull()
    @NotBlank()
    @NotEmpty(message = "cannot be empty")
    private String topics;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students= new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(getName(), course.getName()) && Objects.equals(getCourseType(), course.getCourseType()) && Objects.equals(getDescription(), course.getDescription()) && Objects.equals(getDuration(), course.getDuration()) && Objects.equals(getTopics(), course.getTopics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCourseType(), getDescription(), getDuration(), getTopics());
    }
}
