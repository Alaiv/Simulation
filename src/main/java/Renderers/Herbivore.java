package Renderers;

import location.Coordinate;
import location.Map;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public Character getType() {
        return 'H';
    }

// изменить логику поедания травы
    @Override
    public void makeMove(Map map, Coordinate start) {
        if (this.health < 0)
        {
            map.removeEntity(this.getCurrentCoordinate());
            return;
        }
        if (map.getGrassAmount() == 0)
            return;

        map.dfs('G', start);
        Coordinate newTileCoordinate = this.checkTilesForMoves(map.checkForPath(start), 'G', map);

        map.removeEntity(start);
        map.removeEntity(newTileCoordinate);
        map.addEntity(newTileCoordinate, this);
        this.setCurrentCoordinate(newTileCoordinate);
    }



    public int takeDamage(int damage) {
        this.health -= damage;

        return this.health;
    }
}
