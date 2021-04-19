import java.util.*;

public class SelectingTarget implements State {

    public void Action(int x, int y, Stage stg, StateOperator stateOperator){
        for(Cell c: stg.cellOverlay){
            if (c.contains(x, y)){
                Optional<Actor> oa = stg.actorAt(c);
                if (oa.isPresent()){
                    oa.get().makeRedder(0.1f);
                }
            }
        }
        stg.cellOverlay = new ArrayList<Cell>();
        stateOperator.setState(stateOperator.ChoosingActor);
    }
    
    public String toString() {
        return "SelectingTarget";
    }

}