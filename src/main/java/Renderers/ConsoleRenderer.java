package Renderers;

import entities.Entity;
import location.Coordinate;
import location.Map;

public class ConsoleRenderer {
    public void render(Map map, int rows, int cols) {

        StringBuilder resultMap = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Entity ent = map.getEntity(coordinate);
                if (ent != null) {
                    switch (ent.getType()) {
                        case HERBIVORE -> resultMap.append("🐐");
                        case PREDATOR -> resultMap.append("🐺");
                        case ROCK -> resultMap.append("⛰");
                        case GRASS -> resultMap.append("🌾");
                        case TREE -> resultMap.append("🌳");
                    }
                } else {
                    resultMap.append(" ");
                }
            }
            resultMap.append("\n");
        }
        System.out.println("-----------------------------------");
        System.out.print(resultMap);
        System.out.println("-----------------------------------");
    }
}
