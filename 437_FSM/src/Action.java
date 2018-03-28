/**
 * Created by karlhayek on 2/21/18.
 */

interface ActionListener {
    // interface used in order to pass a function to Action
    public int executeAction(int t);    // the function passed should return an int
}

public class Action {
    ActionListener listener;    // listener contains the function passed in the constructor

    public Action(ActionListener listener) {
        this.listener = listener;
    }

    public int execute(int t){
        return listener.executeAction(t);
    }
}
