package actions;

import entities.*;
import location.Map;

import java.util.ArrayList;
import java.util.List;

public class TurnAction {
    public void makeOneRotation(Map map) {
        List<Creature> creatures = map.getCreaturesList();

        creatures.forEach(c -> {
            c.makeMove(map, c.getCurrentCoordinate());
        });
    }

    protected void addAndPlaceEntities(EntityTypes type, Map map) {
        List<Entity> entities = new ArrayList<>();
        EntityCreator creator = new EntityCreator();

        for (int i = 0; i < 3; i++) {
            entities.add(creator.createNewEntity(type));
        }

        EntityPlacer placer = new EntityPlacer();
        placer.placeEntities(entities, map);
    }
}
