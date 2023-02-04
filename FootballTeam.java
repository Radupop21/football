public class FootballTeam extends Team {
    public FootballTeam(String type, String teamName, String gender, int numberOfPlayers) {
        super(type, teamName, gender, numberOfPlayers);
    }
    public void accept(ConcreteTeamVisitor visitor) {
        visitor.visit(this);
    }
}
