import Renderers.ConsoleRenderer;
import actions.InitAction;
import actions.RefillGrassAction;
import actions.RefillHerbivoreAction;
import actions.TurnAction;
import location.Map;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        List<InitAction> initActions = List.of(new InitAction());
        List<TurnAction> turnAction = List.of(new TurnAction(), new RefillGrassAction(), new RefillHerbivoreAction());
        ConsoleRenderer renderer = new ConsoleRenderer();
        Simulation sim = new Simulation(map, initActions, turnAction, renderer);

        sim.startSimulation();
    }
}
