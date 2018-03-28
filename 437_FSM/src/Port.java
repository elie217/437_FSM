/**
 * Created by karlhayek on 2/21/18.
 */
public class Port {
    private boolean value;

    private FSM fsm;    // the fsm to which it belongs to

    public Port(){
        value = false;
    }

    public FSM getFsm() {
        return fsm;
    }

    public void setFsm(FSM fsm) {
        this.fsm = fsm;
    }
    public void enable() {
        value = true;
    }
    public void disable() {
        value = false;
    }

    public boolean getValue() {
        return value;
    }
}
