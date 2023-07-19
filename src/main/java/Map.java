import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {
    private final HashMap<Coordinates, Tile> map = new HashMap<>();
    private int amount = 0;
    private final int MAX_AMOUNT = 100;

    public final int ROWS_COUNT = 15;
    public final int COLUMN_COUNT = 30;

    public Map() {
        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                Coordinates coordinate = new Coordinates(i, j);
                List<Coordinates> moves = Stream.of(
                        new Coordinates(i + 1, j),
                        new Coordinates(i - 1, j),
                        new Coordinates(i, j + 1),
                        new Coordinates(i, j - 1)
                ).filter(item -> item.getY() >= 0 && item.getX() >= 0).toList();

                Tile tile = new Tile(null, moves);

                map.put(coordinate, tile);
            }
        }
    }

    public void addEntity (Coordinates cord, Entity ent) {
        map.get(cord).setEntity(ent);

        amount += 1;
    }

    public int getAmount() {
        return amount;
    }

    public void removeEntity (Coordinates cord) {
        map.get(cord).removeEntity();
        amount -= 1;
    }

    public Entity getEntity(Coordinates cord) {
        return map.get(cord).getEntity();
    }

    public boolean isCellTaken(Coordinates cord) {
        return map.get(cord).getEntity() != null;
    }

    public boolean isFull() {
        return amount == MAX_AMOUNT;
    }
}
