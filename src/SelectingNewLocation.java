import java.util.*;

public class SelectingNewLocation implements State {

    public void Action(int x, int y, Stage stg, StateOperator stateOperator){
        Optional<Cell> clicked = Optional.empty();
        for (Cell c : stg.cellOverlay) {
            if (c.contains(x, y)) {
                clicked = Optional.of(c);
            }
        }
        if (clicked.isPresent() && stg.actorInAction.isPresent()) {
            stg.actorInAction.get().setLocation(clicked.get());
            stg.actorInAction.get().turns--;
            stg.cellOverlay = new ArrayList<Cell>();
            stg.menuOverlay.add(new MenuItem("Fire", x, y, () -> {
                stg.cellOverlay = stg.grid.getRadius(stg.actorInAction.get().loc, stg.actorInAction.get().range, false);
                stg.cellOverlay.remove(stg.actorInAction.get().loc);
                stateOperator.setState(stateOperator.SelectingTarget);
            }));
            stateOperator.setState(stateOperator.SelectingMenuItem);
        } 
    }
    
    public String toString() {
        return "SelectingNewLocation";
    }

}