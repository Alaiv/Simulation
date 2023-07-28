import entities.*;
import location.Coordinate;
import location.Map;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    public void initMapWithRowsAndColumns() {
        Map map = new Map(5, 5);

        assertEquals(map.getRowsCount(), 5);
        assertEquals(map.getColumnCount(), 5);
    }

    @Test
    public void addEntityToMap() {
        Map map = new Map(5, 5);
        Predator pred = new Predator(1, 1, 1);
        Rock rock = new Rock();
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(2, 2);
        map.addEntity(c1, pred);
        map.addEntity(c2, rock);

        assertEquals(map.getEntity(c1), pred);
        assertEquals(map.getEntity(c2), rock);
    }

    @Test
    public void removeEntityFromMap() {
        Map map = new Map(5, 5);
        Herbivore herb = new Herbivore(1, 1);
        Tree tree = new Tree();
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(2, 2);

        map.addEntity(c1, herb);
        map.addEntity(c2, tree);
        map.removeEntity(c1);
        map.removeEntity(c2);

        assertNull(map.getEntity(c1));
        assertNull(map.getEntity(c2));
    }

    @Test
    public void amountOfHerbsAndGrasses() {
        Map map = new Map(15, 15);
        Herbivore herb = new Herbivore(1, 1);
        Grass grass = new Grass();
        Grass grass1 = new Grass();
        Grass grass2 = new Grass();
        Grass grass3 = new Grass();
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(3, 2);
        Coordinate c3 = new Coordinate(4, 2);
        Coordinate c4 = new Coordinate(5, 2);
        Coordinate c5 = new Coordinate(6, 2);
        map.addEntity(c1, herb);
        map.addEntity(c2, grass);
        map.addEntity(c3, grass1);
        map.addEntity(c4, grass2);
        map.addEntity(c5, grass3);

        assertEquals(map.getHerbivoreAmount(), 1);
        assertEquals(map.getGrassAmount(), 4);
        assertEquals(map.getAmount(), 5);
    }

    @Test
    public void addOnTakenCoordinate() {
        Map map = new Map(15, 15);
        Herbivore herb = new Herbivore(1, 1);
        Grass grass = new Grass();

        Coordinate c1 = new Coordinate(1, 2);

        map.addEntity(c1, grass);
        map.addEntity(c1, herb);


        assertEquals(map.getEntity(c1), herb);
    }

    @Test
    public void getListOfEntities() {
        Map map = new Map(15, 15);
        Herbivore herb = new Herbivore(1, 1);
        Herbivore herb2 = new Herbivore(2, 3);
        Predator pred = new Predator(4, 4, 4);

        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(3, 2);
        Coordinate c3 = new Coordinate(2, 2);


        map.addEntity(c1, herb2);
        map.addEntity(c2, herb);
        map.addEntity(c3, pred);

        assertEquals(3, map.getCreaturesList().size());
        assertTrue(map.getCreaturesList().contains(herb));
        assertTrue(map.getCreaturesList().contains(herb2));
        assertTrue(map.getCreaturesList().contains(pred));
    }

    @Test
    public void getItemCoordinate() {
        Map map = new Map(5, 5);
        Herbivore herb = new Herbivore(1, 1);
        Grass g = new Grass();

        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(1, 2);

        map.addEntity(c1, herb);
        map.addEntity(c2, g);

        map.dfs(EntityTypes.GRASS, c1);
        List<Coordinate> l = map.checkForPath(c1);
        // пересмотреть реализацию веса для тайлов.
        assertEquals(2, map.getTile(c2).getPathWeight());
        assertEquals(l.get(0), c2);
    }
}
