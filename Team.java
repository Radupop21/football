
import java.util.ArrayList;

public abstract class Team implements CompetitionObserver {
    private String type;
    private String teamName;
    private String gender;
    private int numberOfPlayers;
    private int score = 0;
    private int rank;
    private ArrayList<Player> list;
    public Team(String type, String teamName, String gender, int numberOfPlayers) {
        this.type = type;
        this.teamName = teamName;
        this.gender = gender;
        this.numberOfPlayers = numberOfPlayers;
    }
    public void updateScore(int score) {
        this.score+= score;
    }
    public void updateRank(ArrayList<Team> ranking, int n) {
        for (int i = 1 ; i <= n; i++) {
            if (this == ranking.get(i - 1)) {
                this.rank = i;
            }
        }
    }
    public void addPlayer(Player player) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(player);
    }
    public int getScore() {
        return this.score;
    }
    public String getGender() {
        return this.gender;
    }
    public int getRank() {
        return this.rank;
    }
    public String getType() {
        return this.type;
    }
    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }
    public Player getPlayer(int i) {
        return list.get(i);
    }
    public abstract void accept(ConcreteTeamVisitor visitor);
    public String getName() {
        return this.teamName;
    }
    // metoda afiseaza informatia despre echipa
    public void print() {
        System.out.print("{");
        System.out.print("teamName: " + this.teamName);
        System.out.print(", ");
        System.out.print("gender: " + this.gender);
        System.out.print(", ");
        System.out.print("numberOfPlayers: " + this.numberOfPlayers);
        System.out.print(", ");
        System.out.print("players: [");
        for (int i = 0; i < this.numberOfPlayers; i++) {
           list.get(i).print();
           if (i + 1 < this.numberOfPlayers) {
               System.out.print(", ");
           }
        }
        System.out.print("]}");
    }
}
