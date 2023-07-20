public class ConsoleRenderer {
    public void render(Map map, int rows, int cols) {

        String res = "";

        for (int i = 0; i < rows; i++) {
            res += "|";
            for (int j = 0; j < cols; j++) {
                EntityCoordinate coordinate = new EntityCoordinate(i, j);
                Entity ent = map.getEntity(coordinate);
                if (ent != null) {
                    switch (ent.getType()) {
                        case 'H':
                            res += 'H';
                            break;
                        case 'P':
                            res += 'P';
                            break;
                        case 'G':
                            res += 'G';
                            break;
                        case 'R':
                            res += 'R';
                            break;
                        case 'T':
                            res += 'T';
                            break;
                        default:
                            res += ' ';
                    }
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
