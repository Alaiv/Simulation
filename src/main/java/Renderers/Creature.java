package Renderers;

import location.Coordinate;
import location.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Creature extends Entity {
    private int speed;
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

    public Coordinate checkTilesForMoves(List<Coordinate> list, Character item, Map map) {
        List<Coordinate> moves = new ArrayList<>(List.copyOf(list));
        Collections.reverse(moves);
        moves = moves.subList(0, Math.min(this.getSpeed(), moves.size()));
        Coordinate result = moves.get(moves.size() - 1);

        System.out.println(Arrays.toString(moves.stream().map(Coordinate::toString).toArray()));

        for (var move : moves) {
            if (map.getEntity(move) != null && map.getEntity(move).getType() == item)
                result = move;
        }
        System.out.println(result.toString());
        return result;
    }
}
