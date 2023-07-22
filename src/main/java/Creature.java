public abstract class Creature extends Entity{
    private int speed;
    private int health;

    private Coordinate currentCoordinate;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }


    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    public abstract void makeMove(Map map, Coordinate start);
}
