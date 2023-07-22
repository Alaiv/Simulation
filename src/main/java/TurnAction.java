import java.util.List;

public class TurnAction {
    public void makeOneRotation(Map map) {
        List<Creature> creatures = map.getCreaturesList();

        creatures.forEach(c -> {
            c.makeMove(map, c.getCurrentCoordinate());
        });
    }
}
