public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public Character getType() {
        return 'H';
    }

    //to-do
    @Override
    public void makeMove(Map map, Coordinate start) {
            Coordinate grassLocation = map.dfs('G', start);
//            Tile nextTile = map.getNextTileCoordinate(grassLocation, start);
//            System.out.println("Tile stuff: " + nextTile.getTileCoordinate().toString());
//            Tile prevTile = map.getTile(start);
//            prevTile.removeEntity();
//            nextTile.setEntity(this);
//            this.setCurrentCoordinate(nextTile.getTileCoordinate());

    }
}
