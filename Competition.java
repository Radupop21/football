/**
 * Aceasta clasa raspunde de desfasurearea competitiilor
 */
import java.util.ArrayList;
public class Competition {
    private String type;
    private String gender;
    private ArrayList<Team> teams;
    private ArrayList<Team> ranking;
    private ArrayList<CompetitionObserver> observerlist;
    private int numberOfTeams = 0;
    public Competition(String type, String gender) {
        this.type = type;
        this.gender = gender;
    }
    public void addTeam(Team team) {
        if (!team.getGender().equals(this.gender)) return;
        if (!team.getType().equals(this.type)) return;
        if (this.teams == null) {
            this.teams = new ArrayList<>();
        }
        this.numberOfTeams++;
        this.teams.add(team);
    }
    // Methoda foloseste aceleasi referinte ca la addTeam care vor fi sortate
    public void addRankedTeam(Team team) {
        if (!team.getGender().equals(this.gender)) return;
        if (!team.getType().equals(this.type)) return;
        if (this.ranking == null) {
            this.ranking = new ArrayList<>();
        }
        this.ranking.add(team);
    }
    // Metoda care adauga Observeri care (tot aceleasi echipe)
    public void attach(CompetitionObserver observer) {
        if (this.observerlist == null) {
            this.observerlist = new ArrayList<>();
        }
        this.observerlist.add(observer);
    }
    // public void detach(CompetitionObserver observer); Inutil
    // metoda care notifica fiecare echipa depsre noul clasament
    public void mynotify() {
        if (observerlist == null) return;
        for (CompetitionObserver observer : observerlist) {
            observer.updateRank(this.ranking, numberOfTeams);
        }
    }
    // metoda care realizeaza competitia
    public void compete() {
        ConcreteTeamVisitor teamvisitor = new ConcreteTeamVisitor();
        for (int i = 0; i < this.numberOfTeams; i++) {
            this.teams.get(i).accept(teamvisitor);
            double teamScoreA = teamvisitor.getScore();
            for (int j = i; j < this.numberOfTeams; j++) {
                if (i != j) {
                   this.teams.get(j).accept(teamvisitor);
                   double teamScoreB = teamvisitor.getScore();
                    if (teamScoreA < teamScoreB) {
                        this.teams.get(i).updateScore(0);
                        this.teams.get(j).updateScore(3);
                    } else if (teamScoreA > teamScoreB) {
                        this.teams.get(i).updateScore(3);
                        this.teams.get(j).updateScore(0);
                    } else {
                        this.teams.get(i).updateScore(1);
                        this.teams.get(j).updateScore(1);
                    }
                    this.ranking.sort(new TeamComparator());
                    mynotify();
                }
            }
        }
    }
    // metoda afiseaza fiecare echipa in ordinea intrarii in concurs si
    // rank-ul obtinut
    public void printRanking() {
        for (Team team: this.teams) {
            System.out.println("Echipa " + team.getName() + " a ocupat locul " + team.getRank());
        }
    }
    // metoda afiseaza numele echipelor de top in cazul acesta (Top 3)
    public void printTop() {
        for (int i = 0; i < 3 && this.ranking.get(i) != null; i++) {
            System.out.println(this.ranking.get(i).getName());
        }
    }
    
}