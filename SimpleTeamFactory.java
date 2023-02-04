public class SimpleTeamFactory {
    private static SimpleTeamFactory uniqueInstance;
    public static SimpleTeamFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SimpleTeamFactory();
        }
        return uniqueInstance;
    }
    public Team createTeam(String type, String teamName, String gender, int numberOfPlayers) {
        Team team = null;
        if (type.equals("football")) {
            team = new FootballTeam(type, teamName, gender, numberOfPlayers);
        } else if (type.equals("basketball")) {
            team = new BasketballTeam(type, teamName, gender, numberOfPlayers);
        } else if (type.equals("handball")) {
            team = new HandballTeam(type, teamName, gender, numberOfPlayers);
        }
        return team;
    }
}
