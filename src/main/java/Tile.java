import java.util.List;

public class Tile {
    Entity entity;
    List<Coordinates> availableMoves;

    public Tile(Entity entity, List<Coordinates> moves) {
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

    public List<Coordinates> getAvailableMoves() {
        return availableMoves;
    }
}
