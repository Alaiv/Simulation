package entities;

import location.Coordinate;
import location.Map;

public class Grass extends Entity {
    @Override
    public EntityTypes getType() {
        return EntityTypes.GRASS;
    }

    public void getEaten(Map map, Coordinate cord) {
        map.removeEntity(cord);
    }
}
