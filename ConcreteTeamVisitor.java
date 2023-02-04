public class ConcreteTeamVisitor implements TeamVisitor {
    private double score = 0;
    public void visit(HandballTeam team) {
        CalcScore calc = new CalcScore(new HandballScore());
        this.score = calc.getScore(team);
    }
    public void visit(FootballTeam team) {
        CalcScore calc = new CalcScore(new FootballScore());
        this.score = calc.getScore(team);
    }
    public void visit(BasketballTeam team) {
        CalcScore calc = new CalcScore(new BasketballScore());
        this.score = calc.getScore(team);
    }
    public double getScore() {
        return this.score;
    }
}