package location;

import entities.Entity;

import java.util.List;

public class Tile {
    Entity entity;
    List<Coordinate> availableMoves;
    private int pathWeight = 0;
    private Coordinate tileCoordinate;

    private Coordinate prevLocation;

    public Coordinate getPrevLocation() {
        return prevLocation;
    }

    public void setPrevLocation(Coordinate prevLocation) {
        this.prevLocation = prevLocation;
    }

    public Tile(Entity entity, List<Coordinate> moves) {
        this.entity = entity;
        this.availableMoves = moves;
    }

    public Coordinate getTileCoordinate() {
        return tileCoordinate;
    }

    public void setTileCoordinate(Coordinate tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }


    public int getPathWeight() {
        return pathWeight;
    }

    public void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }


    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.setPathWeight(0);
        this.entity = entity;
        this.prevLocation = null;
    }

    public void removeEntity() {
        this.setPathWeight(0);
        this.entity = null;
        this.prevLocation = null;
    }

    public List<Coordinate> getAvailableMoves() {
        return availableMoves;
    }
}
