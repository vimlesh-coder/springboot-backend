package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Employees;

import java.util.List;

public interface EmployeeService {

    Employees saveEmployee(Employees employee);


    Employees getEmployeesById(long id);

    List<Employees> getAllEmployees();

    Boolean updateEmployees(Employees employee);

    void deleteEmployees(long id);
}
