public class Predator extends Creature {
    private int damage;
    public Predator(int speed, int health, int damage) {
        super(speed, health);
        this.damage = damage;
    }

    //to-do
    @Override
    public void makeMove() {
        System.out.println("Moving as predator");
    }

    @Override
    public Character getType() {
        return 'P';
    }
}
