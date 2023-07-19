import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        List<InitAction> initActions = List.of(new InitAction());
        List<TurnAction> turnAction = List.of(new TurnAction());
        ConsoleRenderer renderer = new ConsoleRenderer();

        Simulation sim = new Simulation(map, initActions, turnAction, renderer);

        sim.startSimulation();


    }
}
