public interface TeamVisitor {
    public void visit(HandballTeam team);
    public void visit(FootballTeam team);
    public void visit(BasketballTeam team);
    public double getScore();
}