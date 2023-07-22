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

    }
}
