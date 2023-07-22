import java.util.ArrayList;
import java.util.List;

public class Tile {
    Entity entity;
    List<Coordinate> availableMoves;
    private int pathWeight = 0;
    private List<Coordinate> prevCord = new ArrayList<>();

    public Coordinate getTileCoordinate() {
        return tileCoordinate;
    }

    public void setTileCoordinate(Coordinate tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    private Coordinate tileCoordinate;

    public int getPathWeight() {
        return pathWeight;
    }

    public void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }

    public List<Coordinate> getPrevCord() {
        return prevCord;
    }

    public void setPrevCord(Coordinate prevCord) {
        this.prevCord.add(prevCord);
    }


    public Tile(Entity entity, List<Coordinate> moves) {
        this.entity = entity;
        this.availableMoves = moves;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.prevCord.clear();
        this.setPathWeight(0);
        this.entity = entity;
    }

    public void removeEntity() {
        this.prevCord.clear();
        this.setPathWeight(0);
        this.entity = null;
    }

    public List<Coordinate> getAvailableMoves() {
        return availableMoves;
    }
}
