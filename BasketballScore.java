public class BasketballScore implements ScoreStrategy {
    public double getScore(Team team) {
        int avg = 0;
        if (team.getNumberOfPlayers() != 0) {
            for (int i = 0; i < team.getNumberOfPlayers(); i++) {
                avg += team.getPlayer(i).getScore();;
            }
            return (double)avg / team.getNumberOfPlayers();
        } else {
            return 0;
        }
    }
}