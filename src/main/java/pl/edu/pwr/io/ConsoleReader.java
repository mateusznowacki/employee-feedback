package pl.edu.pwr.io;

import pl.edu.pwr.dbmanagement.RecordFinder;
import pl.edu.pwr.model.Employee;
import pl.edu.pwr.model.Feedback;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;


public class ConsoleReader {
    private final Scanner scanner;
    private final InputValidator inputValidator;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
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
        if (employeeId != 0) {
            firstName = inputValidator.getCorrectFirstName();
            lastName = inputValidator.getCorrectLastName();
            email = inputValidator.getCorrectEmail();

            return new Employee(employeeId, firstName, lastName, email);
        } else {
            return new Employee(0, "NONE", "NONE", "NONE");
        }
    }


    public int getEmployeeIdFromUser() {
        int employeeID = 0;

        System.out.println("Wybierz opcje z menu:");
        System.out.println("1. Podaj id pracownika");
        System.out.println("2. Znajdz pracownika po imieniu i nazwisku");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("Podaj id pracownika");
                employeeID = inputValidator.getCorrectID();
                break;
            }
            case 2: {
                String firstName = inputValidator.getCorrectFirstName();
                String lastName = inputValidator.getCorrectLastName();

                RecordFinder finder = new RecordFinder();
                finder.findClosestRecord(firstName + "," + lastName);
                System.out.println("Wpisz wybrane id");
                employeeID = inputValidator.getCorrectID();
                break;
            }
            default: {
                System.out.println("Musisz podac id pracownika ");
                employeeID = inputValidator.getCorrectID();
                break;
            }
        }
        return employeeID;
    }

    public String getTimePeriod() {
        String timePeriod;

        System.out.println("Wybierz opcje z menu:");
        System.out.println("1. Trend tygodniowy");
        System.out.println("2. Trend miesięczny");
        System.out.println("3. Trend roczny");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                timePeriod = "-1 week";
                break;
            }
            case 2: {
                timePeriod = "-1 month";
                break;
            }
            case 3: {
                timePeriod = "-1 year";
                break;
            }
            default: {
                System.out.println("Nie wybrales zadnej opcji domyslnie to trend miesięczny");
                timePeriod = "-1 month";
                break;
            }
        }
        return timePeriod;
    }

    public Feedback getFeedbackUpdateData() {
        int feedbackID;
        boolean isPositive;
        int weight;
        String comment;

        feedbackID = getFeedbackIdFromUser();
        isPositive = inputValidator.getCorrectGrade();
        weight = inputValidator.getCorrectOpionionWeight();
        comment = inputValidator.getComment();

        return new Feedback(feedbackID, isPositive, weight, comment);
    }

    public int getFeedbackIdFromUser() {
        int opinionID;

        System.out.println("Jeśli znasz numer opinii wpisz 0, jeśli chcesz znależć opinię po pracowniku 1");
        int decision = Integer.parseInt(scanner.nextLine().trim());

        if (decision == 1) {
            RecordFinder finder = new RecordFinder();
            finder.findAllEmployeeOpinions(getEmployeeIdFromUser());
        }
        System.out.println("Podaj id opinii ");
        opinionID = inputValidator.getCorrectID();

        return opinionID;
    }

    public Feedback getFeedbackData() {
        int employeeID;
        Date date;
        boolean isPositive;
        int weight;
        String comment;

        employeeID = getEmployeeIdFromUser();
        date = Date.valueOf(LocalDate.now());
        isPositive = inputValidator.getCorrectGrade();
        weight = inputValidator.getCorrectOpionionWeight();
        comment = inputValidator.getComment();

        return new Feedback(employeeID, date, isPositive, weight, comment);
    }
}
