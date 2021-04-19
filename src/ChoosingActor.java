import java.util.Optional;

public class ChoosingActor implements State {

    public void Action(int x, int y, Stage stg, StateOperator stateOperator){
        stg.actorInAction = Optional.empty();
        for (Actor actor : stg.actors) {
            if (actor.loc.contains(x, y) && actor.isTeamRed() && actor.turns > 0) {
                stg.actorInAction = Optional.of(actor);
                stg.cellOverlay = stg.grid.getRadius(actor.loc, actor.moves, true);
                stateOperator.setState(stateOperator.SelectingNewLocation);
            }
        }
        if(!stg.actorInAction.isPresent()){
            stateOperator.setState(stateOperator.SelectingMenuItem);
            stg.menuOverlay.add(new MenuItem("Oops", x, y, () -> stateOperator.setState(stateOperator.ChoosingActor)));
            stg.menuOverlay.add(new MenuItem("End Turn", x, y+MenuItem.height, () -> stateOperator.setState(stateOperator.CPUMoving)));
            stg.menuOverlay.add(new MenuItem("End Game", x, y+MenuItem.height*2, () -> System.exit(0)));
        }
    }
    
    public String toString() {
        return "ChoosingActor";
    }

}