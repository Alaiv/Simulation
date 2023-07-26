package entities;

public class EntityCreator {
    public Entity createNewEntityWithRandomStats(EntityTypes type) {

        switch (type) {
            case HERBIVORE -> {
                return new Herbivore(getRandomSpeed(), getRandomHealth());
            }
            case PREDATOR -> {
                return new Predator(getRandomSpeed(), getRandomHealth(), getRandomDamage());
            }
            case ROCK -> {
                return new Rock();
            }
            case GRASS -> {
                return new Grass();
            }
            case TREE -> {
                return new Tree();
            }
        }

        return null;
    }

    private int getRandomHealth() {
        return (int) (Math.random() * 20);
    }

    private int getRandomDamage() {
        return (int) (Math.random() * 10) + 10;
    }

    private int getRandomSpeed() {
        return (int) (Math.random() * 3) + 1;
    }
}
