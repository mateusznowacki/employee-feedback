package pl.edu.pwr.io;

import pl.edu.pwr.model.Employee;

import java.util.Scanner;


public class ConsoleReader {
    private final Scanner scanner;
    private final InputValidator inputValidator;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public int getChoice() {

        return scanner.nextInt();
    }

    public Employee getEmployeeDataFromUser() {
        String firstName;
        String lastName;
        String email;


        firstName = inputValidator.getCorrectFirstName();
        lastName = inputValidator.getCorrectLastName();
        email = inputValidator.getCorrectEmail();


        return new Employee(firstName, lastName, email);
    }


    public Employee getEmployeeUpdateData() {
        String firstName;
        String lastName;
        String email;

        int employeeId = getEmployeeIdFromUser();


        firstName = inputValidator.getCorrectFirstName();
        lastName = inputValidator.getCorrectLastName();
        email = inputValidator.getCorrectEmail();

        return new Employee(employeeId, firstName, lastName, email);
    }


    public int getEmployeeIdFromUser() {
        int employeeID;

        System.out.println("Wybierz opcje z menu:");
        System.out.println("1. Podaj id pracownika");
        System.out.println("2. Znajdz pracownika po imieniu i nazwisku lub emailu");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("Podaj id pracownika");
                employeeID = inputValidator.getCorrectID();
            }
            break;
            case 2: {
                System.out.println("Podaj imie pracownika");
                String firstName = scanner.next();
                System.out.println("Podaj nazwisko pracownika");
                String lastName = scanner.next();
                System.out.println("Podaj email pracownika");
                String email = scanner.next();

                //
                // do dodania wyszykanie w bazie danych
                //
                employeeID = inputValidator.getCorrectID();
            }
            break;
            default:
                System.out.println("Musisz podac id pracownika do usuniecia");
                employeeID = inputValidator.getCorrectID();
        }

        return employeeID;
    }


}
