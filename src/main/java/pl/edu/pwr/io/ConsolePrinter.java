package pl.edu.pwr.io;

import pl.edu.pwr.model.Feedback;

import java.util.ArrayList;

public class ConsolePrinter {

    public void displayMenu() {
        System.out.println("1. Dodaj pracownika");
        System.out.println("2. Usun pracownika");
        System.out.println("3. Edytuj dane pracownika");
        System.out.println("4. Dodaj opinie o pracowniku");
        System.out.println("5. Usun opinie");
        System.out.println("6. Edytuj opinie");
        System.out.println("7. Wyświetl trend opinii pracownika");
        System.out.println("8. Wyjście");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printTrend(ArrayList<Feedback> feedbackList) {
        int opinionsCounter = 0;
        int positiveOpinions = 0;
        int negativeOpinions = 0;
        int totalWeight = 0;
        int weightedSum = 0;

        for (Feedback feedback : feedbackList) {
            int opinionValue = 0;
            if (feedback.isPositive()) {
                opinionValue = 1;
                positiveOpinions++;
            } else {
                opinionValue = -1;
                negativeOpinions++;
            }

            int weightedOpinionValue = feedback.getWeight() * opinionValue;
            weightedSum += weightedOpinionValue;
            totalWeight += feedback.getWeight();
            opinionsCounter++;
        }
        double avgWeight = (totalWeight / opinionsCounter);

        if (totalWeight == 0) {
            System.out.println("Brak danych do analizy");
        } else {
            double weightedAverage = (weightedSum / totalWeight);

            if (weightedAverage > 0) {
                System.out.println("Trend opinii jest pozytywny");
                System.out.println("Przeważają opinie pozytywne: " + positiveOpinions + " do " + negativeOpinions + " negatywnych");
                System.out.println("Średnia waga opinii to: " + avgWeight);
            } else if (weightedAverage < 0) {
                System.out.println("Trend opinii jest negatywny");
                System.out.println("Przeważają opinie negatywne: " + negativeOpinions + " do " + positiveOpinions + " pozytywnych");
                System.out.println("Średnia waga opinii to: " + avgWeight);
            } else {
                System.out.println("Trend opinii jest neutralny.");
                System.out.println("Liczba opinii pozytywnych to: " + positiveOpinions + " a negatywnych to: " + negativeOpinions);
                System.out.println("Średnia waga opinii to: " + avgWeight);
            }
        }
    }
}
