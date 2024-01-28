package com.devmix.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

import javax.management.MXBean;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@Data
public class StudentEntity implements Serializable {

    @Id
    private String studentId;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @NotEmpty(message = "first name cannot be null")
    private String firstName;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @NotEmpty(message = "last name cannot be null")
    private String lastName;

    private String middleName;
    @Min(value = 5,message = "cannot be less than ")
    @Max(value = 99,message = "cannot exceeds from ")
    private int age;
    @Email(message = "invalid email")
    private String email;
    @NotNull (message = "cannot be null")
    @NotBlank(message = "cannot be empty")
    @Pattern(regexp = "^\\d{10}$",message = "invalid phone number")
    private String phoneNumber;
}
