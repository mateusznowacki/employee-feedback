package pl.edu.pwr.io;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public String getCorrectEmail() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        int id;
        do {
            String input = scanner.nextLine().trim();
            try {
                id = Integer.parseInt(input);
                if (id >= 0) {
                    break; // Poprawne ID, przerywamy pętlę
                } else {
                    System.out.println("Identyfikator ID powinien być dodatnią liczbą całkowitą");
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędny identyfikator (ID). Spróbuj ponownie.");
            }
        } while (true);

        return id;
    }


    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidFirstName(String firstName) {
        // Przykładowa walidacja: Imię powinno składać się tylko z liter i zaczynać się wielką literą
        return firstName.matches("[A-Z][a-z]*");
    }

}
