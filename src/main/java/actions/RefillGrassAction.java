package actions;

import entities.EntityTypes;
import location.Map;

public class RefillGrassAction extends TurnAction {
    @Override
    public void makeOneRotation(Map map) {
        if (map.getGrassAmount() <= 1)
            this.addAndPlaceEntities(EntityTypes.GRASS, map);
    }
}
