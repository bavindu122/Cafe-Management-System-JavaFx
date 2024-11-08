package com.example.demo.Controllers.Employee;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private String empId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String contact_Number;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", contact_Number='" + contact_Number + '\'' +
                '}';
    }

    public String getEmpId() {
        return empId;
    }


}
