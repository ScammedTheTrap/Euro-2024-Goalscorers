import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Statistics {
    private List<MatchResult> matchResults;

    public Statistics(String filename) throws FileNotFoundException {
        MatchResultFileReader reader = new MatchResultFileReader(filename);
        this.matchResults = reader.readFile();
    }

    public Set<String> getGoalScorers() {
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult result : matchResults) {
            goalScorers.addAll(result.getGoalScorers());//i stedet for for-loop adder den selv
        }
        return goalScorers;
    }

    public Map<String, Integer> getGoalScorersWithTotals() {
        Map<String, Integer> scorersWithTotals = new HashMap<>();
        for (MatchResult result : matchResults) {
            for (String scorer : result.getGoalScorers()) {
                scorersWithTotals.put(scorer, scorersWithTotals.getOrDefault(scorer, 0) + 1);
            }
        }
        return scorersWithTotals;
    }

    public int getNumberOfGoals(String goalScorer) {
        int count = 0;
        for (MatchResult result : matchResults) {
            for (String scorer : result.getGoalScorers()) {
                if (scorer.equals(goalScorer)) {
                    count++;
                }
            }
        }
        return count;
    }
}
