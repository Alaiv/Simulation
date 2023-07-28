import Renderers.ConsoleRenderer;
import actions.InitAction;
import actions.TurnAction;
import location.Map;

import javax.swing.*;
import java.util.List;

public class Simulation extends JFrame {
    private final Map map;
    private int stepCounter = 0;
    private final int MAX_STEP = 25;
    private final ConsoleRenderer renderer;
    private final List<InitAction> initActions;
    private final List<TurnAction> turnActions;

    private GameStates gameState = GameStates.NOT_STARTED;

    public Simulation(Map map, List<InitAction> initAction, List<TurnAction> turnAction, ConsoleRenderer renderer) {
        this.map = map;
        this.initActions = initAction;
        this.turnActions = turnAction;
        this.renderer = renderer;
    }

    public void startSimulation() throws InterruptedException {
        System.out.println("Simulation started.");
        this.gameState = GameStates.STARTED;
        this.initActions.forEach(iAction -> iAction.activate(this.map));
        renderer.render(this.map, this.map.getRowsCount(), this.map.getColumnCount());

        while (this.gameState.equals(GameStates.STARTED) || this.gameState.equals(GameStates.PAUSED)) {
            if (this.gameState.equals(GameStates.PAUSED)) {
                continue;
            }
            turnActions.forEach(tAction -> tAction.makeOneRotation(map));
            renderer.render(this.map, this.map.getRowsCount(), this.map.getColumnCount());
            Thread.sleep(1000);
            this.stepCounter++;

            if (this.stepCounter == MAX_STEP) {
                this.endSimulation();
                System.out.println("Simulation ended.");
            }

            if (this.stepCounter == 10) {
                this.pauseSimulation();
                System.out.println("Sumulation paused for 2 seconds");
                Thread.sleep(2000);
                this.gameState = GameStates.STARTED;
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
