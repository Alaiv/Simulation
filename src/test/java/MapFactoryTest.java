import entities.Entity;
import entities.Herbivore;
import location.Coordinate;
import location.MapFactory;
import location.Tile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MapFactoryTest {

    @Test
    public void createMapWithValidLength() throws Exception {
        int r = 5;
        int c = 5;
        int expectedSize = r * c;

        Map<Coordinate, Tile> m = MapFactory.createMap(r, c);

        assertEquals(m.size(), expectedSize);
    }

    @Test
    public void createMapWithInvalidLength() {
        int r = 3;
        int c = 0;

        try {
            MapFactory.createMap(r, c);
        } catch (Exception e) {
            assertNotEquals(null, e);
        }
    }

    @Test
    public void haveTiles() throws Exception {
        int r = 5;
        int c = 5;

        Map<Coordinate, Tile> m = MapFactory.createMap(r, c);
        Tile tile1 = new Tile(new Herbivore(1, 1), new ArrayList<>());

        m.values().forEach(tile -> assertInstanceOf(tile1.getClass(), tile));
    }

    @Test
    public void tilesHaveCoordinates() throws Exception {
        int r = 5;
        int c = 5;

        Map<Coordinate, Tile> m = MapFactory.createMap(r, c);
        Coordinate coordinate = new Coordinate(1, 1);

        m.values().forEach(tile -> assertInstanceOf(coordinate.getClass(), tile.getTileCoordinate()));
    }
}
