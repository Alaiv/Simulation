package location;

import entities.*;

import java.util.*;

public class Map {
    private HashMap<Coordinate, Tile> map = new HashMap<>();
    private int amount = 0;
    private int grassAmount = 0;
    private int herbivoreAmount = 0;
    private final int MAX_AMOUNT = 100;

    private int rowsCount = 10;
    private int columnCount = 30;
    private List<Tile> tilesWithDestinations;

    public int getGrassAmount() {
        return grassAmount;
    }

    public int getHerbivoreAmount() {
        return herbivoreAmount;
    }

    public Map(int rows, int columns) {
        try {
            this.map = MapFactory.createMap(rows, columns);
            this.rowsCount = rows;
            this.columnCount = columns;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Размер карты слишком мал. Количество строк и столбцов не может быть меньше 5.");
        }

    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColumnCount() {
        return columnCount;
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
        List<Creature> creatureList = new ArrayList<>();

        for (Tile value : map.values()) {
            if (value.getEntity() != null && value.getEntity() instanceof Creature) {
                creatureList.add((Creature) value.getEntity());
            }
        }

        return creatureList;
    }

    // to-do: улучшить логику поиска пути
    public void dfs(EntityTypes item, Coordinate cord) {
        this.tilesWithDestinations = new ArrayList<>();
        Queue<Coordinate> cords = new PriorityQueue<>();
        cords.add(cord);
        Set<Coordinate> visited = new HashSet<>();
        visited.add(cord);

        while (cords.size() > 0) {
            Coordinate location = cords.remove();
            Entity ent = this.getEntity(location);
            Tile tile = this.map.get(location);

            if (ent != null && ent.getType().equals(item) && !tilesWithDestinations.contains(tile)) {
                tilesWithDestinations.add(tile);
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

    public List<Coordinate> checkForPath(Coordinate start) {
        Tile end = this.tilesWithDestinations.stream().min(Comparator.comparingInt(Tile::getPathWeight)).get();
        List<Coordinate> path = new ArrayList<>();

        while (!end.getTileCoordinate().equals(start)) {
            path.add(end.getTileCoordinate());
            end = getTile(end.getPrevLocation());
        }
        return path;
    }
}
