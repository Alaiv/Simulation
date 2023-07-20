public abstract class Creature extends Entity{
    private int speed;
    private int health;

    private EntityCoordinate currentCoordinate;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public abstract void makeMove();

    public EntityCoordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(EntityCoordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }
}
