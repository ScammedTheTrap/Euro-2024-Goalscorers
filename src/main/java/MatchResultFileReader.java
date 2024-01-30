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

    public List<MatchResult> readFile() {
        List<MatchResult> matchResults = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            MatchResult matchResult = parseLineToMatchResult(line);
            matchResults.add(matchResult);
        }
        scanner.close(); // Luk scanneren efter brug
        return matchResults;
    }

    private MatchResult parseLineToMatchResult(String line) {
        String[] data = line.split(";");
        String team1 = data[0];
        String team2 = data[1];
        int goalsTeam1 = Integer.parseInt(data[2]);
        int goalsTeam2 = Integer.parseInt(data[3]);
        List<String> goalScorers = new ArrayList<>();
        if (data.length > 4 && !data[4].isEmpty()) {
            goalScorers.addAll(Arrays.asList(data[4].split(",")));
        }
        return new MatchResult(team1, team2, goalsTeam1, goalsTeam2, goalScorers);
    }
}
