package actions;

import entities.Entity;
import entities.EntityCreator;
import entities.EntityPlacer;
import entities.EntityTypes;
import location.Map;

import java.util.ArrayList;
import java.util.List;

public class InitAction {

    public void activate(Map map) {


        List<Entity> entities = new ArrayList<>();
        EntityCreator creator = new EntityCreator();

        for (int i = 0; i < 4; i++) {
            entities.add(creator.createNewEntityWithRandomStats(EntityTypes.HERBIVORE));
            entities.add(creator.createNewEntityWithRandomStats(EntityTypes.GRASS));
            entities.add(creator.createNewEntityWithRandomStats(EntityTypes.PREDATOR));
            entities.add(creator.createNewEntityWithRandomStats(EntityTypes.ROCK));
            entities.add(creator.createNewEntityWithRandomStats(EntityTypes.TREE));
        }


        EntityPlacer placer = new EntityPlacer();
        placer.placeEntities(entities, map);
    }
}
