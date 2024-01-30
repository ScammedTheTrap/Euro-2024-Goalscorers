import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            String filename = "Euro2024QualifyingRound.csv";

            // Opretter en instans af Statistics
            Statistics stats = new Statistics(filename);

            // Viser et sæt af unikke målscorere
            System.out.println("Unique Goal Scorers:");
            for (String scorer : stats.getGoalScorers()) {
                System.out.println(scorer);
            }

            // Viser antallet af mål for hver målscorer
            System.out.println("\nGoal Scorers with Totals:");
            stats.getGoalScorersWithTotals().forEach((scorer, total) ->
                    System.out.println(scorer + ": " + total));

            // Du kan også tilføje mere funktionalitet her efter behov
        } catch (FileNotFoundException e) {
            System.err.println("Filen blev ikke fundet: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Der opstod en fejl: " + e.getMessage());
        }
    }
}
