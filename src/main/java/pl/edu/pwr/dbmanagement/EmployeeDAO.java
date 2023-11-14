package pl.edu.pwr.dbmanagement;

import pl.edu.pwr.model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    ArrayList<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
