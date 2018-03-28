/**
 * Created by karlhayek on 2/21/18.
 */
public class Transition {
    private State originState;
    private State nextState;
    private Port port;
    private Condition condition;
    private Action action;


    public State getOriginState() {
        return originState;
    }

    public State getNextState() {
        return nextState;
    }

    public Port getPort() {
        return port;
    }

    public Transition(State originState, State nextState, Port port, Condition condition, Action action) {
        this.originState = originState;
        this.nextState = nextState;
        this.port = port;
        this.condition = condition;
        this.action = action;
    }

    public boolean isValid(int t) {
        return  condition.evaluate(t);
    }

    public int executeAction(int t){
        return action.execute(t);
    }
}
