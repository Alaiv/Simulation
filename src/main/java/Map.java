import java.util.*;
import java.util.stream.Stream;

public class Map {
    private final HashMap<EntityCoordinate, Tile> map = new HashMap<>();
    private int amount = 0;
    private final int MAX_AMOUNT = 100;

    public final int ROWS_COUNT = 15;
    public final int COLUMN_COUNT = 30;

    public Map() {
        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                EntityCoordinate coordinate = new EntityCoordinate(i, j);
                List<EntityCoordinate> moves = Stream.of(
                        new EntityCoordinate(i + 1, j),
                        new EntityCoordinate(i - 1, j),
                        new EntityCoordinate(i, j + 1),
                        new EntityCoordinate(i, j - 1)
                )
                        .filter(item -> item.getY() >= 0 && item.getX() >= 0)
                        .filter(item -> item.getY() < COLUMN_COUNT && item.getX() < ROWS_COUNT)
                        .toList();

                Tile tile = new Tile(null, moves);

                map.put(coordinate, tile);
            }
        }
    }

    public void addEntity (EntityCoordinate cord, Entity ent) {
        map.get(cord).setEntity(ent);
        if(ent instanceof Creature) {
            ((Creature) ent).setCurrentCoordinate(cord);
        }
        amount += 1;
    }

    public int getAmount() {
        return amount;
    }

    public void removeEntity (EntityCoordinate cord) {
        map.get(cord).removeEntity();
        amount -= 1;
    }

    public Entity getEntity(EntityCoordinate cord) {
        return map.get(cord).getEntity();
    }

    public boolean isCellTaken(EntityCoordinate cord) {
        return map.get(cord).getEntity() != null;
    }

    public boolean isFull() {
        return amount == MAX_AMOUNT;
    }

    public void dfs(Character item, EntityCoordinate cord) {
        Queue<EntityCoordinate> cords = new PriorityQueue<>();
        cords.add(cord);
        Set<EntityCoordinate> visited = new HashSet<>();

        while (cords.size() > 0) {
            EntityCoordinate location = cords.remove();
            Entity ent = this.getEntity(location);
            visited.add(location);

            if (ent != null && ent.getType() == item) {
                System.out.println(location.toString());
                return;
            }

            Tile tile = this.map.get(location);
            List<EntityCoordinate> availableMoves = tile.getAvailableMoves();
            availableMoves.forEach(c -> {
                if(!visited.contains(c)) {
                    cords.add(c);
                }
            });
        }
        System.out.println("Nothing!");
    }
}
