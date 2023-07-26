package actions;

import entities.Creature;
import location.Map;

import java.util.List;

public class MoveAction extends  TurnAction{
    public void makeOneRotation(Map map) {
        List<Creature> creatures = map.getCreaturesList();

        creatures.forEach(c -> {
            c.makeMove(map, c.getCurrentCoordinate());
        });
    }
}
