/**
 * Clasa de context
 */
public class CalcScore {
    ScoreStrategy strategy = null;
    public CalcScore(ScoreStrategy strategy) {
        this.strategy = strategy;
    }
    public double getScore(Team team) {
        return strategy.getScore(team);
    }
}