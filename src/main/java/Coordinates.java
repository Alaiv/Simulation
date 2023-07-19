public class Coordinates {
    private final Integer x;
    private final Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public static Coordinates getRandomCoordinate(int r, int c) {
        int x = (int)(Math.random() * r);
        int y = (int)(Math.random() * c);

        return new Coordinates(x, y);

    }

    @Override
    public int hashCode() {
        return x.hashCode() * 31 + y.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        int objX = ((Coordinates) obj).getX();
        int objY = ((Coordinates) obj).getY();

        return objX == getX() && objY == getY();
    }
}
