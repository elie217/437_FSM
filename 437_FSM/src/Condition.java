/**
 * Created by karlhayek on 2/21/18.
 */

interface ConditionListener{
    // interface used in order to pass a function to Condition
    public boolean evaluateCondition(int t);    // the function passed should return a boolean
}

public class Condition {
    ConditionListener listener; // listener is the object that contains the function passed in the constructor

    public Condition(ConditionListener listener){
        this.listener = listener;
    }

    public boolean evaluate(int t){
        return listener.evaluateCondition(t);
    }
}
