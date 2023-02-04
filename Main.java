import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Citirea din fisiere se realizeaza in Main. De aici se schimba desfasurarea
 * Programului.
 */
public class Main {
    public static void main(String [] argv) throws FileNotFoundException {
        File file = new File(argv[1]); // IN1
        Scanner input = new Scanner (file);
        String [] args;
        ArrayList<Team> teams = new ArrayList<>();
        int numberOfTeams = 0;
        // isncrierea echipelor in baza de date se face in orice caz.
        while (input.hasNextLine()) {
            args = (input.nextLine()).split(", ");
            int numberOfPlayers = Integer.parseInt(args[3]);
            Team team = SimpleTeamFactory.getInstance().createTeam(args[0],args[1], args[2], numberOfPlayers);

            teams.add(team);
            numberOfTeams++;
            while (numberOfPlayers > 0) {
                args = (input.nextLine()).split(", ");
                team.addPlayer(new Player(args[0], Integer.parseInt(args[1])));
                numberOfPlayers--;
            }
        }
        input.close();
        if (argv[0].equals("inscriere")) {
            for (int i = 0; i < numberOfTeams; i++) {
                teams.get(i).print();
                System.out.println();
            }
        } else if (argv[0].equals("competitie")) {
            file = new File(argv[2]); // IN2
            input = new Scanner (file);
            args = (input.nextLine()).split(", ");
            Team team = null;
            Competition competition = new Competition(args[0], args[1]);

            while (input.hasNextLine()) {
                args = (input.nextLine()).split(", ");
                for (int i = 0; i < numberOfTeams; i++) {
                    if (teams.get(i).getName().equals(args[0])) {
                        team = teams.get(i);
                    }
                }
                if (team != null) {
                    competition.addTeam(team);
                    competition.addRankedTeam(team); 
                    competition.attach(team);
                }
            }
            competition.compete();
            competition.printTop();
            competition.printRanking();
        }
    }
}