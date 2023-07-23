package actions;

import Renderers.*;
import location.Coordinate;
import location.Map;

import java.util.List;

public class InitAction {


    public void setEntities(Map map) {


        List<Entity> entities = List.of(
                new Renderers.Predator(2, 10, 10),
                new Herbivore(3, 10),
                new Herbivore(1, 15),
                new Renderers.Herbivore(2, 25),
                new Renderers.Herbivore(1, 5),
                new Grass(),
                new Grass(),
                new Renderers.Grass(),
                new Renderers.Grass(),
                new Renderers.Rock(),
                new Renderers.Rock(),
                new Renderers.Tree()
        );


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
