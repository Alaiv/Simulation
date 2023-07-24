import Renderers.ConsoleRenderer;
import actions.InitAction;
import actions.TurnAction;
import location.Map;

import java.util.List;
import java.util.Scanner;

public class Simulation {
    private final Map map;
    private int stepCounter = 0;
    private final int MAX_STEP = 100;

    private ConsoleRenderer renderer;
    private final List<InitAction> initActions;
    private List<TurnAction> turnActions;

    private GameStates gameState = GameStates.NOT_STARTED;


    public Simulation(Map map, List<InitAction> initAction, List<TurnAction> turnAction, ConsoleRenderer renderer) {
        this.map = map;
        this.initActions = initAction;
        this.turnActions = turnAction;
        this.renderer = renderer;
    }

    public void startSimulation() {
        this.gameState = GameStates.STARTED;
        this.initActions.forEach(iAction -> iAction.activate(this.map));
        renderer.render(this.map, this.map.ROWS_COUNT, this.map.COLUMN_COUNT);

        Scanner sc = new Scanner(System.in);

        while (this.gameState.equals(GameStates.STARTED) || this.gameState.equals(GameStates.PAUSED)) {
            if (this.gameState.equals(GameStates.PAUSED)) {
                continue;
            }
            turnActions.forEach(tAction -> tAction.makeOneRotation(map));
            renderer.render(this.map, this.map.ROWS_COUNT, this.map.COLUMN_COUNT);
            sc.nextLine();
            this.stepCounter++;

            if (this.stepCounter == MAX_STEP) {
                this.endSimulation();
            }
        }
    }

    public void endSimulation() {
        this.gameState = GameStates.FINISHED;
    }

    public void pauseSimulation() {
        this.gameState = GameStates.PAUSED;
    }
}
