package entities;

import location.Coordinate;
import location.Map;

public class Predator extends Creature {
    private final int damage;
    public Predator(int speed, int health, int damage) {
        super(speed, health);
        this.damage = damage;
    }

    @Override
    public EntityTypes getType() {
        return EntityTypes.PREDATOR;
    }

    @Override
    public void makeMove(Map map, Coordinate start) {
        if (map.getHerbivoreAmount() == 0)
            return;

        map.dfs(EntityTypes.HERBIVORE, start);
        Coordinate newTileCoordinate = this.checkTilesForMoves(map.checkForPath(start), EntityTypes.HERBIVORE, map);
        Entity ent = map.getEntity(newTileCoordinate);

        if (ent instanceof Herbivore) {
            int herbivoreHealth = ((Herbivore) ent).takeDamage(this.damage);
            if (herbivoreHealth <= 0) {
                map.removeEntity(newTileCoordinate);
            }
        } else {
            map.removeEntity(start);
            map.addEntity(newTileCoordinate, this);
            this.setCurrentCoordinate(newTileCoordinate);
        }
    }
}
