package entities;

import location.Coordinate;
import location.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Creature extends Entity {
    private final int speed;
    protected int health;

    private Coordinate currentCoordinate;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    public abstract void makeMove(Map map, Coordinate start);

    public Coordinate checkTilesForMoves(List<Coordinate> list, EntityTypes item, Map map) {
        List<Coordinate> moves = new ArrayList<>(List.copyOf(list));
        Collections.reverse(moves);
        moves = moves.subList(0, Math.min(this.getSpeed(), moves.size()));
        Coordinate result = moves.get(moves.size() - 1);


        for (var move : moves) {
            if (map.getEntity(move) != null && map.getEntity(move).getType().equals(item))
                result = move;
        }

        return result;
    }
}
