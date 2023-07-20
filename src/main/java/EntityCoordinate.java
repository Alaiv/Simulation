public class EntityCoordinate implements Comparable<EntityCoordinate> {
    private final Integer x;
    private final Integer y;

    public EntityCoordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public static EntityCoordinate getRandomCoordinate(int r, int c) {
        int x = (int)(Math.random() * r);
        int y = (int)(Math.random() * c);

        return new EntityCoordinate(x, y);

    }

    @Override
    public int hashCode() {
        return x.hashCode() * 31 + y.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        int objX = ((EntityCoordinate) obj).getX();
        int objY = ((EntityCoordinate) obj).getY();

        return objX == getX() && objY == getY();
    }

    @Override
    public String toString() {
        return this.getX() + " " + this.getY();
    }

    @Override
    public int compareTo(EntityCoordinate o) {
        return this.getX() - o.getX();
    }
}
