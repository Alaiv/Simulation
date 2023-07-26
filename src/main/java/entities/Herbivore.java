package entities;

import location.Coordinate;
import location.Map;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public EntityTypes getType() {
        return EntityTypes.HERBIVORE;
    }

    @Override
    public void makeMove(Map map, Coordinate start) {
        if (this.health < 0) {
            map.removeEntity(this.getCurrentCoordinate());
            return;
        }
        if (map.getGrassAmount() == 0)
            return;

        map.dfs(EntityTypes.GRASS, start);
        Coordinate newTileCoordinate = this.checkTilesForMoves(map.checkForPath(start), EntityTypes.GRASS, map);
        Entity ent = map.getEntity(newTileCoordinate);

        if (ent instanceof Grass) {
            ((Grass) ent).getEaten(map, newTileCoordinate);
        } else {
            map.removeEntity(start);
            map.addEntity(newTileCoordinate, this);
            this.setCurrentCoordinate(newTileCoordinate);
        }
    }

    public int takeDamage(int damage) {
        this.health -= damage;

        return this.health;
    }
}
