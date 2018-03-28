/**
 * Created by karlhayek on 2/21/18.
 */
public class FSM {
    State currentState, initialState;
    int currentIndex = 0, t, nextIndex;
    State[] states;
    Transition[] transitions;
    Transition currentTransition, initialTransition;
    Port[] ports;
    String name = "FSM", variableName = "t";

    public FSM(State[] states, State initialState, Transition[] transitions, Port[] ports, int initialT) {
        this.states = states;
        this.transitions = transitions;
        this.ports = ports;

        currentTransition = initialTransition = transitions[0];
        currentState = this.initialState = initialState;
        for (Port p : ports)
            p.setFsm(this); // specify which FSM the ports belong to
        t = initialT;
    }

    public void printPorts() {
        System.out.print(name + " Ports: ");
        for (Port p : ports)
            System.out.print(Boolean.toString(p.getValue()) + ", ");
        System.out.println("\n");
    }

    public void printStates() {
        System.out.print(name + " States: ");
        for (State s : states)
            System.out.print(s.getName() + ", ");
        System.out.println("\n");
    }

    public void drawFSM() {
        System.out.println(name + " Transitions:");
        for (int i = 0; i < transitions.length; i++){
            System.out.print("Transition " + Integer.toString(i) + ": ");
            Transition tr = transitions[i];
            System.out.print(tr.getOriginState().getName() + " -> " + tr.getNextState().getName());
            System.out.println("; Port " + (tr.getPort().getValue() ? "enabled" : "disabled" ));
        }
        System.out.println();
    }

    public void run(int nbSteps) {
        System.out.println("Running " + name + ":");
//        printPorts();
        for (int i = 0; i < nbSteps; i++) {

            if (!currentTransition.isValid(t)) {
                // go to next transition
                currentIndex = (currentIndex + 1) % transitions.length;
                currentTransition = transitions[currentIndex];
            }

            if (currentTransition.isValid(t)) {
                System.out.println("i: " + Integer.toString(i) + "; " + variableName + ": " + Integer.toString(t) + "; State: " + currentState.getName());

                t = currentTransition.executeAction(t);     // execute the action in the current transition

                currentState = currentTransition.getNextState();    // go to next state in the current transition
            }
        }
        System.out.println("End. " + variableName + ": " + Integer.toString(t) + "; State: " + currentState.getName() + "\n");
    }

    public void reset() {  // reset to initial state in the FSM
        currentState = initialState;

        t = 0; currentIndex = 0;
        currentTransition = initialTransition;
    }
}
