/**
 * Created by elietamer on 3/12/18.
 */
public class Interaction {

    Condition condition;
    Action action;
    Port port1, port2;
    int t;
    Transition[] transitions1;
    Transition[] transitions2;

    public Interaction(Port port1, Port port2, Condition condition, Action action, int initialT,
                       Transition[] transitions1,Transition[] transitions2){
        this.action = action;
        this.condition = condition;
        this.port1 = port1;
        this.port2 = port2;
        this.transitions1=transitions1;
        this.transitions2=transitions2;
        t = initialT;
    }

    public void run(int nbSteps){
        for (int i = 0; i < nbSteps; i++){
            if (condition.evaluate(t)&&thereExist(transitions1,transitions2)){

                t = action.execute(t);
                // check if
                port1.enable(); port2.enable();
            }
            else {
                port1.disable(); port2.disable();
            }

            port1.getFsm().run(1);
            port2.getFsm().run(1);
        }
    }

//this function checks whether there exist a VALID transition with the appropriate ports in order for the interaction to take place
public boolean thereExist(Transition[] transitions1,Transition[] transitions2){

    for (Transition i :transitions1){
        for (Transition j : transitions2)
            if ((i.getPort().equals(port1) && j.getPort()==port2) && i.isValid(t)&&j.isValid(t))
                return true;


    }
    return false;
}



}
