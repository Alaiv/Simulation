public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public Character getType() {
        return 'H';
    }


    @Override
    public void makeMove(Map map, Coordinate start) {
        if (map.getGrassAmount() == 0)
            return;

        map.dfs('G', start);
        Coordinate newTileCoordinate = map.checkForPath(start);

        map.removeEntity(start);
        map.removeEntity(newTileCoordinate);
        map.addEntity(newTileCoordinate, this);
        this.setCurrentCoordinate(newTileCoordinate);
    }
}
