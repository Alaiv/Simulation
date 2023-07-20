import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        List<InitAction> initActions = List.of(new InitAction());
        List<TurnAction> turnAction = List.of(new TurnAction());
        ConsoleRenderer renderer = new ConsoleRenderer();
        EntityCoordinate c = new EntityCoordinate(0, 1);
        map.addEntity(c, new Herbivore(1, 10));
        map.addEntity(new EntityCoordinate(7, 10), new Grass());

        map.dfs('G', c);
//        Simulation sim = new Simulation(map, initActions, turnAction, renderer);
//
//        sim.startSimulation();


    }
}
