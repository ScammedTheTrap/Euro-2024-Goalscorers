
import java.util.List;

public class MatchResult {
    private String team1;
    private String team2;
    private int goalsTeam1;
    private int goalsTeam2;
    private List<String> goalScorers;

    public MatchResult(String team1, String team2, int goalsTeam1, int goalsTeam2, List<String> goalScorers) {
        this.team1 = team1;
        this.team2 = team2;
        this.goalsTeam1 = goalsTeam1;
        this.goalsTeam2 = goalsTeam2;
        this.goalScorers = goalScorers;
    }

    public List<String> getGoalScorers() {
        return goalScorers;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getGoalsTeam1() {
        return goalsTeam1;
    }

    public int getGoalsTeam2() {
        return goalsTeam2;
    }
}
