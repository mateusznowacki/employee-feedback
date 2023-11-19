package pl.edu.pwr.app;

import pl.edu.pwr.dbmanagement.ConnectionManager;
import pl.edu.pwr.io.ConsolePrinter;
import pl.edu.pwr.io.ConsoleReader;
import pl.edu.pwr.model.Employee;
import pl.edu.pwr.service.EmployeeController;
import pl.edu.pwr.service.FeedbackController;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();

        ConsoleReader inputReader = new ConsoleReader();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        EmployeeController employeeController = new EmployeeController(connection);
        FeedbackController feedbackController = new FeedbackController(connection);

        Employee employee = new Employee("Jan", "Kowalski", "abc2d@w.pl");


        int choice = 0;

        while (choice != 8) {
            consolePrinter.printMessage("Wybierz opcje z menu:");
            consolePrinter.displayMenu();
            choice = inputReader.getChoice();
            switch (choice) {
                case 1: {
                    employeeController.addEmployee(inputReader.getEmployeeDataFromUser());
                }
                break;
                case 2:
                    employeeController.deleteEmployee(inputReader.getEmployeeIdFromUser());
                    //delete all opinions
                    break;
                case 3:
                    employeeController.updateEmployeeData(inputReader.getEmployeeUpdateData());
                    break;
                case 4:
                    // Logika dla Zadania 4

                    break;
                case 5:
                    // Logika dla Zadania 5
                    break;
                case 6:
                    // Logika dla Zadania 6
                    break;
                case 7:
                    // Logika dla Zadania 6
                    break;


                case 8:
                    // Logika dla Zadania 9


                    connectionManager.closeConnection();
                    break;

                default:
                    consolePrinter.printMessage("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}
