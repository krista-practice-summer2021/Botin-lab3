package game;

import java.util.*;

import static game.InOutUtils.readStringsFromInputStream;
import static game.ProcessUtils.UTF_8;

/**
 * Main samplegame class.
 */
public class Main {

    public static void main(String[] args) {
        List<String> input = readStringsFromInputStream(System.in, UTF_8);
        if (!input.isEmpty()) {
            Round round = new Round(input);
            printMovingGroups(makeMove(round));
        }
        System.exit(0);
    }

    private static List<MovingGroup> makeMove(Round round) {
        List<Planet> myOwnPlanets = round.getOwnPlanets();
        List<MovingGroup> movingGroups = new ArrayList<>();
        int getMyId = round.getTeamId();
        // Место для Вашего кода.
        switch (getMyId) {
            case (1): {
                myOwnPlanets.stream().forEach(planet ->
                        {
                            int NeedToCapt = (planet.getPopulation() - 1) / 2;
                            movingGroups.add(new MovingGroup(planet.getId(), (planet.getId() - 1) % 10, NeedToCapt));
                            movingGroups.add(new MovingGroup(planet.getId(), (planet.getId() - 2) % 10, NeedToCapt));
                            //movingGroups.add(new MovingGroup(planet.getId(), (planet.getId() - 3) % 10, NeedToCapt));
                        }
                );
            }
            case (0): {
                myOwnPlanets.stream().forEach(planet ->
                        {
                            int NeedToCapt = (planet.getPopulation() - 1) / 2;
                            movingGroups.add(new MovingGroup(planet.getId(), (planet.getId() + 1) % 10, NeedToCapt));
                            movingGroups.add(new MovingGroup(planet.getId(), (planet.getId() + 2) % 10, NeedToCapt));
                            //movingGroups.add(new MovingGroup(planet.getId(), (planet.getId() + 3) % 10, NeedToCapt));
                        }
                );
            }


        }
        return movingGroups;
    }

    private static void printMovingGroups(List<MovingGroup> moves) {
        System.out.println(moves.size());
        moves.forEach(move -> System.out.println(move.getFrom() + " " + move.getTo() + " " + move.getCount()));
    }

}
