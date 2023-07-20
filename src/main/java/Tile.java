import java.util.List;

public class Tile {
    Entity entity;
    List<EntityCoordinate> availableMoves;

    public Tile(Entity entity, List<EntityCoordinate> moves) {
        this.entity = entity;
        this.availableMoves = moves;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void removeEntity() {
        this.entity = null;
    }

    public List<EntityCoordinate> getAvailableMoves() {
        return availableMoves;
    }
}
