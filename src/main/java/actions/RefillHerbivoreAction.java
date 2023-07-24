package actions;

import entities.EntityTypes;
import location.Map;

public class RefillHerbivoreAction extends TurnAction {
    @Override
    public void makeOneRotation(Map map) {
        if (map.getHerbivoreAmount() <= 1) {
            this.addAndPlaceEntities(EntityTypes.HERBIVORE, map);
        }
    }
}
