public class StateOperator {

    State ChoosingActor;
    State CPUMoving;
    State SelectingMenuItem;
    State SelectingNewLocation;
    State SelectingTarget;
    State state;

    public StateOperator() {
        ChoosingActor = new ChoosingActor();
        CPUMoving = new CPUMoving();
        SelectingMenuItem = new SelectingMenuItem();
        SelectingNewLocation = new SelectingNewLocation();
        SelectingTarget = new SelectingTarget();
    }

    public void action(int x, int y, Stage stg, StateOperator stateOperator){
        state.Action(x, y, stg, stateOperator);
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return this.state;
    }
    
}