import Renderers.ConsoleRenderer;
import actions.*;
import location.Map;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("𓃵");

        Map map = new Map();
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
