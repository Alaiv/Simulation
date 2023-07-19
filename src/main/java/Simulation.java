import java.util.List;

public class Simulation {
    private final Map map;
    private int stepCounter = 0;

    private ConsoleRenderer renderer;
    private final List<InitAction> initActions;
    private List<TurnAction> turnAction;



    public Simulation(Map map, List<InitAction> initAction, List<TurnAction> turnAction, ConsoleRenderer renderer) {
        this.map = map;
        this.initActions = initAction;
        this.turnAction = turnAction;
        this.renderer = renderer;
    }

    public void startSimulation() {
        this.initActions.forEach(iAction -> iAction.setEntities(this.map));
        renderer.render(this.map, this.map.ROWS_COUNT, this.map.COLUMN_COUNT);
    }

    public void endSimulation() {

    }

    public void pauseSimulation() {

    }
}
