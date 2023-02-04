import java.util.Comparator;
public class TeamComparator implements Comparator<Team> {
    public int compare(Team o1, Team o2) {
        return o2.getScore() - o1.getScore();
    }
}