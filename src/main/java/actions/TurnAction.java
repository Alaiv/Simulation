package actions;

import entities.Entity;
import entities.EntityCreator;
import entities.EntityPlacer;
import entities.EntityTypes;
import location.Map;

import java.util.ArrayList;
import java.util.List;

public abstract class TurnAction {

    public abstract void makeOneRotation(Map map);

    protected void addAndPlaceEntities(EntityTypes type, Map map) {
        List<Entity> entities = new ArrayList<>();
        EntityCreator creator = new EntityCreator();

        for (int i = 0; i < 3; i++) {
            entities.add(creator.createNewEntityWithRandomStats(type));
        }

        EntityPlacer placer = new EntityPlacer();
        placer.placeEntities(entities, map);
    }
}
