public class FootballScore implements ScoreStrategy {
    public double getScore(Team team) {
        Boolean isMasculin = team.getGender().equals("masculin");
        //CalcScore cscore = new CalcScore(new FootballScore());
        int extreme;
        int sum = 0;
        if (team.getNumberOfPlayers() != 0) {
            extreme = team.getPlayer(0).getScore();
            for (int i = 0; i < team.getNumberOfPlayers(); i++) {
                int localscore = team.getPlayer(i).getScore();
                if ((isMasculin && extreme < localscore) || (!isMasculin && extreme > localscore)) {
                    extreme = localscore;
                }
                sum += localscore;
            }
            sum += extreme;
        }
        return sum;
    }
}