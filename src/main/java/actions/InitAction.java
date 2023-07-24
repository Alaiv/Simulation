package actions;

import entities.*;
import location.Map;

import java.util.ArrayList;
import java.util.List;

public class InitAction {

    public void activate(Map map) {


        List<Entity> entities = new ArrayList<>();
        EntityCreator creator = new EntityCreator();

        for (int i = 0; i < 4; i++) {
            entities.add(creator.createNewEntity(EntityTypes.HERBIVORE));
            entities.add(creator.createNewEntity(EntityTypes.GRASS));
            entities.add(creator.createNewEntity(EntityTypes.PREDATOR));
            entities.add(creator.createNewEntity(EntityTypes.ROCK));
            entities.add(creator.createNewEntity(EntityTypes.TREE));
        }


        EntityPlacer placer = new EntityPlacer();
        placer.placeEntities(entities, map);
    }
}
