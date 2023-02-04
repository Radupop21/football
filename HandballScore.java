public class HandballScore implements ScoreStrategy {
    public double getScore(Team team) {
        Boolean isMasculin = team.getGender().equals("masculin");
        int res = 0;
        if (team.getNumberOfPlayers() != 0) {
            for (int i = 0; i < team.getNumberOfPlayers(); i++) {
                int localscore = team.getPlayer(i).getScore();
                if (isMasculin) {
                    res += localscore;
                } else {
                    if (res == 0) {
                        res = localscore;
                    } else {
                        res *= localscore;
                    }
                }
            }
        }
        return res;
    }
}