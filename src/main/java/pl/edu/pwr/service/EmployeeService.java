package pl.edu.pwr.service;

import pl.edu.pwr.model.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    void addEmployee( Employee employee);

    void updateEmployeeData(Employee employee);

    void deleteEmployee(int employeeId);

}

