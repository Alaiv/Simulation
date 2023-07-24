package Renderers;

import entities.Entity;
import location.Coordinate;
import location.Map;

public class ConsoleRenderer {
    public void render(Map map, int rows, int cols) {

        String res = "";

        for (int i = 0; i < rows; i++) {
            res += "|";
            for (int j = 0; j < cols; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Entity ent = map.getEntity(coordinate);
                if (ent != null) {
                    res += ent.getType().name().charAt(0);
                } else {
                    res += ' ';
                }
            }
            res += "|";
            res += "\n";
        }
        System.out.println("--------------------------------");
        System.out.print(res);
        System.out.println("--------------------------------");
    }
}
