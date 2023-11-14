package pl.edu.pwr.service;

import pl.edu.pwr.dbmanagement.ConnectionManager;
import pl.edu.pwr.dbmanagement.EmployeeDAO;
import pl.edu.pwr.model.Employee;

import java.util.ArrayList;

public class EmployeeService implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();












        connectionManager.closeConnection();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();





        connectionManager.closeConnection();
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();







        connectionManager.closeConnection();
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();

        connectionManager.closeConnection();
    }

    @Override
    public void deleteEmployee(int employeeId) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.getConnection();




        connectionManager.closeConnection();
    }
}
