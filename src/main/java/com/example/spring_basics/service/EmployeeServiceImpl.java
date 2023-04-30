package com.example.spring_basics.service;
import java.util.List;
import java.util.Optional;

import com.example.spring_basics.exception.ResourceNotFoundException;
import com.example.spring_basics.model.Employee;
import com.example.spring_basics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;



@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(long id) {

        return employeeRepository.findById(id).get();

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("id do not exists"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("id do not exists"));
        employeeRepository.deleteById(id);
    }

    @Override
    public String save1Employee(Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findByEmail(employee.getEmail());
        if ((employee1.isPresent()))
             return "email already there!";
        else
           employeeRepository.save(employee);
        return "data saved";
    }
}
