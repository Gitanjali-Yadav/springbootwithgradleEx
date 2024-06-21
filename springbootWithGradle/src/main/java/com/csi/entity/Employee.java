package com.csi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Size(min = 2, message = "Employee Name must contain atleast 2 characters")
    private String empName;

    private String empAddress;

    private long empContactNumber;

    private Date empDOB;

    @Email(message = "Email Id must be Valid")
    private String empEmailId;

    @Size(min = 4 , message = "Password must be 4 characters")
    private String empPassword;
}
