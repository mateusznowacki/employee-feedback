package pl.edu.pwr.app;

import pl.edu.pwr.dbmanagement.ConnectionManager;
import pl.edu.pwr.io.ConsolePrinter;
import pl.edu.pwr.io.ConsoleReader;
import pl.edu.pwr.service.EmployeeController;
import pl.edu.pwr.service.FeedbackController;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();

        ConsoleReader userInput = new ConsoleReader();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        EmployeeController employeeController = new EmployeeController(connection);
        FeedbackController feedbackController = new FeedbackController(connection);

        int choice = 0;
        while (choice != 8) {
            consolePrinter.printMessage("Wybierz opcje z menu:");
            consolePrinter.displayMenu();
            choice = userInput.getChoice();
            switch (choice) {

                case 1: {
                    employeeController.addEmployee(userInput.getEmployeeDataFromUser());
                    break;
                }
                case 2: {
                    int id = userInput.getEmployeeIdFromUser();
                    employeeController.deleteEmployee(id);
                    feedbackController.deleteFeedback(id, true);
                    break;
                }
                case 3: {
                    employeeController.updateEmployeeData(userInput.getEmployeeUpdateData());
                    break;
                }
                case 4: {
                    feedbackController.addFeedback(userInput.getFeedbackData());
                    break;
                }
                case 5: {
                    feedbackController.deleteFeedback(userInput.getEmployeeIdFromUser(), false);
                    break;
                }
                case 6: {
                    feedbackController.editFeedback(userInput.getEmployeeIdFromUser());
                    break;
                }
                case 7: {
                    // Logika dla Zadania 6
                    break;
                }
                case 8: {
                    connectionManager.closeConnection();
                    break;
                }
                default:
                    consolePrinter.printMessage("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    public static void abc() {
        System.out.println("sfdfsdgfd");
    }

}














