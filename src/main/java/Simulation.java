import java.util.List;
import java.util.Scanner;

public class Simulation {
    private final Map map;
    private int stepCounter = 0;

    private ConsoleRenderer renderer;
    private final List<InitAction> initActions;
    private List<TurnAction> turnActions;

    private String gameState = "Not started";


    public Simulation(Map map, List<InitAction> initAction, List<TurnAction> turnAction, ConsoleRenderer renderer) {
        this.map = map;
        this.initActions = initAction;
        this.turnActions = turnAction;
        this.renderer = renderer;
    }

    public void startSimulation() {
        this.gameState = "Started";
        this.initActions.forEach(iAction -> iAction.setEntities(this.map));
        renderer.render(this.map, this.map.ROWS_COUNT, this.map.COLUMN_COUNT);

        Scanner sc = new Scanner(System.in);

        while (this.gameState.equals("Started")) {
            turnActions.forEach(tAction -> tAction.makeOneRotation(map));
            renderer.render(this.map, this.map.ROWS_COUNT, this.map.COLUMN_COUNT);
            sc.nextLine();
        }
    }

    public void endSimulation() {
        this.gameState = "Finished";
    }

    public void pauseSimulation() {
        this.gameState = "Paused";
    }
}
