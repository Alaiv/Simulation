package location;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class MapFactory {
    private static final HashMap<Coordinate, Tile> map = new HashMap<>();
    public static HashMap<Coordinate, Tile> createMap(int rows, int columns) throws Exception {
        if (rows < 5 || columns < 5) {
            throw new Exception();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                List<Coordinate> moves = Stream.of(
                                new Coordinate(i + 1, j),
                                new Coordinate(i - 1, j),
                                new Coordinate(i, j + 1),
                                new Coordinate(i, j - 1)
                        )
                        .filter(item -> item.getY() >= 0 && item.getX() >= 0)
                        .filter(item -> item.getY() < columns && item.getX() < rows)
                        .toList();

                Tile tile = new Tile(null, moves);
                tile.setTileCoordinate(coordinate);

                map.put(coordinate, tile);
            }
        }

        return map;
    }
}
