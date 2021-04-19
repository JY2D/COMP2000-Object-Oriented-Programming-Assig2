import java.util.*;

public class SelectingMenuItem implements State {

    public void Action(int x, int y, Stage stg, StateOperator stateController){
        for(MenuItem mi : stg.menuOverlay){
            if (mi.contains(x,y)){
                mi.action.run();
                stg.menuOverlay = new ArrayList<MenuItem>();
            }
        }
    }
    
    public String toString() {
        return "SelectingMenuItem";
    }

}