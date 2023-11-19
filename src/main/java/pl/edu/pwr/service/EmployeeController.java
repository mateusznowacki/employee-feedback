package pl.edu.pwr.service;

import pl.edu.pwr.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController implements EmployeeService {

    private Connection connection;

    public EmployeeController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            String sqlCheckExistingEmail = "SELECT COUNT(*) FROM employee WHERE email = ?";
            try (PreparedStatement checkEmailStatement = connection.prepareStatement(sqlCheckExistingEmail)) {
                checkEmailStatement.setString(1, employee.getEmail());
                ResultSet resultSet = checkEmailStatement.executeQuery();
                resultSet.next();
                int existingEmailCount = resultSet.getInt(1);

                if (existingEmailCount > 0) {
                    System.out.println("Pracownik o takim emailu juz istnieje, pracownik musi miec unikalny email");
                } else {
                    String sqlInsertEmployee = "INSERT INTO employee (first_name, last_name, email) VALUES (?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertEmployee)) {
                        preparedStatement.setString(1, employee.getFirstName());
                        preparedStatement.setString(2, employee.getLastName());
                        preparedStatement.setString(3, employee.getEmail());

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("Pracownik zostal dodany prawwdlowo");
                        } else {
                            System.out.println("Blad podczas dodawania pracownika");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployeeData(Employee employee) {
        try {
            String sqlUpdateEmployee = "UPDATE employee SET first_name=?,last_name=?,email=? WHERE employee_id=? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateEmployee)) {
                preparedStatement.setString(1, employee.getFirstName());
                preparedStatement.setString(2, employee.getLastName());
                preparedStatement.setString(3, employee.getEmail());
                preparedStatement.setInt(4, employee.getEmployeeID());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Dane pracownika zostały zaktualizowane");
                } else {
                    System.out.println("Nie znaleziono pracownika do zaktualizowania");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            String sqlDeleteEmployee = "DELETE FROM employee WHERE employee_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteEmployee)) {
                preparedStatement.setInt(1, employeeId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Pracownik zostal usuniety prawidlowo");
                } else {
                    System.out.println("Blad podczas usuwania pracownika");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
