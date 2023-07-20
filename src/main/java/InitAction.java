import java.util.ArrayList;
import java.util.List;

public class InitAction {


    public void setEntities(Map map) {


        List<Entity> entities = List.of(
                new Predator(4, 10, 3),
                new Predator(2, 10, 10),
                new Predator(2, 10, 5),
                new Predator(1, 10, 22),
                new Herbivore(1, 10),
                new Herbivore(1, 15),
                new Herbivore(1, 25),
                new Herbivore(1, 5),
                new Grass(),
                new Grass(),
                new Grass(),
                new Grass(),
                new Rock(),
                new Rock(),
                new Rock(),
                new Rock(),
                new Tree(),
                new Tree(),
                new Tree(),
                new Tree()
        );


//        entities.forEach((e) -> {
//            Coordinates c = Coordinates.getRandomCoordinate(map.ROWS_COUNT, map.COLUMN_COUNT);
//
//            while (map.isCellTaken(c)) {
//                c = Coordinates.getRandomCoordinate(map.ROWS_COUNT, map.COLUMN_COUNT);
//            }
//
//            map.addEntity(c, e);
//        });


    }

}
