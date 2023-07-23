package Renderers;

import location.Coordinate;
import location.Map;

public class Predator extends Creature {
    private int damage;
    public Predator(int speed, int health, int damage) {
        super(speed, health);
        this.damage = damage;
    }

    //to-do

    @Override
    public Character getType() {
        return 'P';
    }

    @Override
    public void makeMove(Map map, Coordinate start) {
        if (map.getHerbivoreAmount() == 0)
            return;

        map.dfs('H', start);
        Coordinate newTileCoordinate = this.checkTilesForMoves(map.checkForPath(start), 'H', map);
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
