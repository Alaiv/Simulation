import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Map {
    private final HashMap<Coordinate, Tile> map = new HashMap<>();
    private int amount = 0;
    private final int MAX_AMOUNT = 100;

    public final int ROWS_COUNT = 10;
    public final int COLUMN_COUNT = 10;

    public Map() {
        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                List<Coordinate> moves = Stream.of(
                                new Coordinate(i + 1, j),
                                new Coordinate(i - 1, j),
                                new Coordinate(i, j + 1),
                                new Coordinate(i, j - 1)
                        )
                        .filter(item -> item.getY() >= 0 && item.getX() >= 0)
                        .filter(item -> item.getY() < COLUMN_COUNT && item.getX() < ROWS_COUNT)
                        .toList();

                Tile tile = new Tile(null, moves);
                tile.setTileCoordinate(coordinate);

                map.put(coordinate, tile);
            }
        }
    }

    public void addEntity(Coordinate cord, Entity ent) {
        map.get(cord).setEntity(ent);
        if (ent instanceof Creature) {
            ((Creature) ent).setCurrentCoordinate(cord);
        }
        amount += 1;
    }

    public Tile getTile(Coordinate c) {
        return map.get(c);
    }

    public int getAmount() {
        return amount;
    }

    public void removeEntity(Coordinate cord) {
        map.get(cord).removeEntity();
        amount -= 1;
    }

    public Entity getEntity(Coordinate cord) {
        return map.get(cord).getEntity();
    }

    public boolean cellIsTaken(Coordinate cord) {
        return map.get(cord).getEntity() != null;
    }

    public boolean isFull() {
        return amount == MAX_AMOUNT;
    }

    public List<Creature> getCreaturesList() {
        List<Creature> ents = new ArrayList<>();

        for (Tile value : map.values()) {
            if (value.getEntity() != null && value.getEntity() instanceof Creature) {
                ents.add((Creature) value.getEntity());
            }
        }

        return ents;
    }


    public Coordinate dfs(Character item, Coordinate cord) {
        Queue<Coordinate> cords = new PriorityQueue<>();
        cords.add(cord);
        Set<Coordinate> visited = new HashSet<>();

        while (cords.size() > 0) {
            Coordinate location = cords.remove();
            Entity ent = this.getEntity(location);
            visited.add(location);
            Tile tile = this.map.get(location);

            if (ent != null && ent.getType() == item) {
                return location;
            }


            List<Coordinate> availableMoves = tile.getAvailableMoves();

            availableMoves.forEach(c -> {
                if (!visited.contains(c) && !cellIsTaken(c) || getEntity(c) != null && getEntity(c).getType() == item) {
                    Tile t = this.map.get(c);
                    t.setPathWeight(tile.getPathWeight() + 1);
                    if (!t.getPrevCord().contains(location))
                        t.setPrevCord(location);
                    cords.add(c);
                }
            });

        }
        return null;
    }

    public Tile getNextTileCoordinate(Coordinate coordinate, Coordinate start) {

        Boolean found = false;
        Tile tile = getTile(coordinate);
        List<Tile> res = new ArrayList<>();

        while (!found) {
            Tile ts = tile.getPrevCord().stream()
                    .map(this::getTile)
                    .filter(Objects::nonNull)
                    .min(Comparator.comparingInt(Tile::getPathWeight))
                    .get();
            res.add(ts);
            tile = ts;

            if (tile.getPrevCord().contains(start)) {
                found = true;
            }
        }

        System.out.println(Arrays.toString(res.stream().map(x -> x.getTileCoordinate().toString()).toArray()));
        return tile;
    }
}
