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
    public void makeMove() {
        System.out.println("Moving as Herbivore");
    }
}
