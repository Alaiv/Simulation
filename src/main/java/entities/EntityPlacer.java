package entities;

import location.Coordinate;
import location.Map;

import java.util.List;

public class EntityPlacer {

    public void placeEntities(List<Entity> entities, Map map) {
        entities.forEach((e) -> {
            Coordinate c = Coordinate.getRandomCoordinate(map.ROWS_COUNT, map.COLUMN_COUNT);

            while (map.cellIsTaken(c)) {
                c = Coordinate.getRandomCoordinate(map.ROWS_COUNT, map.COLUMN_COUNT);
            }

            map.addEntity(c, e);
            if (e instanceof Creature) {
                ((Creature) e).setCurrentCoordinate(c);
            }
        });
    }
}
