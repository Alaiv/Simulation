import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Map {
    private final HashMap<Coordinate, Tile> map = new HashMap<>();
    private int amount = 0;
    private int grassAmount = 0;
    private int herbivoreAmount = 0;
    private final int MAX_AMOUNT = 100;

    public final int ROWS_COUNT = 10;
    public final int COLUMN_COUNT = 10;
    private List<Tile> stuff;

    public int getGrassAmount() {
        return grassAmount;
    }

    public int getHerbivoreAmount() {
        return herbivoreAmount;
    }

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
        this.getTile(cord).setEntity(ent);

        if (ent instanceof Creature) {
            ((Creature) ent).setCurrentCoordinate(cord);
        }

        if (ent instanceof Herbivore) {
            this.herbivoreAmount++;
        }

        if (ent instanceof Grass) {
            this.grassAmount++;
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
        Tile t = this.getTile(cord);
        if (t.getEntity() instanceof Herbivore) {
            this.herbivoreAmount--;
        }

        if (t.getEntity() instanceof Grass) {
            this.grassAmount--;
        }

        t.removeEntity();
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


    public void dfs(Character item, Coordinate cord) {
        this.stuff = new ArrayList<>();
        Queue<Coordinate> cords = new PriorityQueue<>();
        cords.add(cord);
        Set<Coordinate> visited = new HashSet<>();
        visited.add(cord);

        while (cords.size() > 0) {
            Coordinate location = cords.remove();
            Entity ent = this.getEntity(location);
            Tile tile = this.map.get(location);

            if (ent != null && ent.getType() == item && !stuff.contains(tile)) {
                stuff.add(tile);
            }

            List<Coordinate> availableMoves = tile.getAvailableMoves();

            availableMoves.forEach(c -> {
                if (!visited.contains(c) && (!cellIsTaken(c) || (getEntity(c) != null && getEntity(c).getType() == item))) {
                    Tile t = this.map.get(c);
                    t.setPathWeight(tile.getPathWeight() + 1);
                    t.setPrevLocation(location);
                    cords.add(c);
                    visited.add(c);
                }

                if (getEntity(c) != null && getEntity(c).getType() == item) {
                    Tile t = this.map.get(c);
                    int prevPathWeight = getTile(t.getPrevLocation()).getPathWeight();
                    int newWeight = Math.min(prevPathWeight, tile.getPathWeight());
                    Coordinate newPrevCord = tile.getPathWeight() < prevPathWeight ? location : t.getPrevLocation();

                    t.setPrevLocation(newPrevCord);
                    t.setPathWeight(newWeight);
                }
            });

        }
    }

    public Coordinate checkForPath(Coordinate start) {
        Tile end = this.stuff.stream().min(Comparator.comparingInt(Tile::getPathWeight)).get();
        List<Coordinate> path = new ArrayList<>();

        while (!end.getTileCoordinate().equals(start)) {
            path.add(end.getTileCoordinate());
            end = getTile(end.getPrevLocation());
        }

        System.out.println(Arrays.toString(path.stream().map(Coordinate::toString).toArray()));
        return path.get(path.size() - 1);
    }
}
