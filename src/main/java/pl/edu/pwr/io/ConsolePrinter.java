package pl.edu.pwr.io;

public class ConsolePrinter {

    public void displayMenu(){
        System.out.println("1. Dodaj pracownika");
        System.out.println("2. Usun pracownika");
        System.out.println("3. Edytuj dane pracownika");
        System.out.println("4. Dodaj opinie o prawcowniku");
        System.out.println("5. Usun opinie");
        System.out.println("6. Edytuj opinie");
        System.out.println("7. Wyświetl trend opinii pracownika");
        System.out.println("8. Wyjście");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }




}
