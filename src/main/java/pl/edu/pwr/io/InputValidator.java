package pl.edu.pwr.io;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private final Scanner scanner;

    public InputValidator() {
        this.scanner = new Scanner(System.in);
    }

    public String getCorrectEmail() {

        String email;
        System.out.println("Pamiętaj że mail ma format example@example.example");
        do {
            System.out.print("Podaj adres e-mail: ");
            email = scanner.nextLine().trim();
            if (InputValidator.isValidEmail(email)) {
                break; // Poprawny e-mail, przerywamy pętlę
            } else {
                System.out.println("Błędny adres e-mail. Spróbuj ponownie.");
            }
        } while (true);

        return email;
    }

    public String getCorrectFirstName() {
        String firstName;

        System.out.println("Pamietaj że imię rozpoczyna się dużą literą");
        do {
            System.out.print("Podaj imię: ");
            firstName = scanner.nextLine().trim();
            if (InputValidator.isValidFirstName(firstName)) {
                break; // Poprawne imię, przerywamy pętlę
            } else {
                System.out.println("Błędne imię. Spróbuj ponownie.");
            }
        } while (true);

        return firstName;
    }

    public String getCorrectLastName() {
        String lastName;
        System.out.println("Pamietaj że nazwisko rozpoczyna się dużą literą");
        do {
            System.out.print("Podaj nazwisko: ");
            lastName = scanner.nextLine().trim();
            if (InputValidator.isValidFirstName(lastName)) {
                break; // Poprawne imię, przerywamy pętlę
            } else {
                System.out.println("Błędne nazwisko. Spróbuj ponownie.");
            }
        } while (true);

        return lastName;
    }

    public int getCorrectID() {
        int id;
        do {
            String input = scanner.nextLine().trim();
            try {
                id = Integer.parseInt(input);
                if (id >= 0) {
                    break; // Poprawne ID, przerywamy pętlę
                } else {
                    System.out.println("id to liczba większa od 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędne id");
            }
        } while (true);

        return id;
    }

    public Date getCorrectDate() {
        int year;
        int month;
        int day;

        do {
            System.out.println("Podaj date w formacie dd-mm-yyyy");
            String date = scanner.nextLine().trim();

            if (isValidDate(date)) {
                String[] parts = date.split("-");
                day = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);
                break;
            } else {
                System.out.println("Podaj jeszcze raz prawidłową datę");
            }
        } while (true);

        return new Date(year, month, day);
    }


    public boolean getCorrectGrade() {
        int number;
        System.out.println("Jesli opinia jest pozytywna wpisz 1 jeśli jest negatywna wpisz 0");
        number = Integer.parseInt(scanner.nextLine().trim());
        return number == 1;
    }

    public int getCorrectOpionionWeight() {
        int weight;
        do {
            System.out.println("Podaj wage opinii od 0 do 10");
            String input = scanner.nextLine().trim();
            try {
                weight = Integer.parseInt(input);
                if (weight >= 0 && weight <= 10) {
                    break; // poprawna waga koniec
                } else {
                    System.out.println("Waga to liczba od 0 do 10");
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędna liczba, spróbuj ponownie");
            }
        } while (true);
        return weight;
    }

    public String getComment() {
        String comment;
        do {
            System.out.println("Wpisz komentarz do opinii");
            comment = scanner.nextLine();
            if (comment.length() > 0) {
                break; // jest komentarz
            } else {
                System.out.println("Nic nie zostało wpisane do komentarza");
            }
        } while (true);

        return comment;
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidFirstName(String firstName) {
        //  tylko z liter i wielka litera
        return firstName.matches("[A-Z][a-z]*");
    }

    private static boolean isValidDate(String date) {
        String[] parts = date.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 0 && year <= 9999;
    }

}
