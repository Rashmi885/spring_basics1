package com.example.spring_basics.service;
import com.example.spring_basics.model.Employee;
import java.util.List;


public interface EmployeeService {
    String save1Employee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}