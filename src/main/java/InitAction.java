import java.util.List;

public class InitAction {


    public void setEntities(Map map) {


        List<Entity> entities = List.of(
//                new Predator(4, 10, 3),
                new Herbivore(1, 10),
                new Herbivore(1, 15),
//                new Herbivore(1, 25),
//                new Herbivore(1, 5),
                new Grass(),
                new Grass()
//                new Grass(),
//                new Grass(),
//                new Rock(),
//                new Rock(),
//                new Tree()
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
