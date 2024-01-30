import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {

    private Scanner scanner;

    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        this.scanner = new Scanner(file);
    }

    /*public List<MatchResult> readFile() {
        List<MatchResult> matchResults = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            MatchResult matchResult = parseLineToMatchResult(line);
            matchResults.add(matchResult);
        }
        scanner.close(); // Luk scanneren efter brug
        return matchResults;
    }*/
    public List<MatchResult> readFile() {
        List<MatchResult> matchResults = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            MatchResult matchResult = parseLineToMatchResult(line);
            if (matchResult != null) {
                matchResults.add(matchResult);
            }
        }
        return matchResults;
    }

    private MatchResult parseLineToMatchResult(String line) {
        String[] parts = line.split(";");

        // Opdeling af holdnavne, antager at de er adskilt af et bindestreg
        String[] teams = parts[0].split("-");
        String team1 = teams[0];
        String team2 = teams[1];

        List<String> goalScorers = new ArrayList<>();
        if (parts.length > 1 && !parts[1].isEmpty()) {
            goalScorers.addAll(Arrays.asList(parts[1].split(",")));
        }

        // Antal mål for hvert hold (kan ikke udledes fra de nuværende data)
        int goalsTeam1 = 0;
        int goalsTeam2 = 0;

        return new MatchResult(team1, team2, goalsTeam1, goalsTeam2, goalScorers);
    }

}
