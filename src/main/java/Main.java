import Renderers.ConsoleRenderer;
import actions.*;
import location.Map;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(10, 30);
        List<InitAction> initActions = List.of(new InitAction());
        List<TurnAction> turnAction = List.of(new MoveAction(), new RefillGrassAction(), new RefillHerbivoreAction());
        ConsoleRenderer renderer = new ConsoleRenderer();
        Simulation sim = new Simulation(map, initActions, turnAction, renderer);

        try{
            sim.startSimulation();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
