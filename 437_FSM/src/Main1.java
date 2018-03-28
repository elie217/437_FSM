/**
 * Created by karlhayek on 2/21/18.
 */
public class Main1 {
    public static void main(String[] args) {
//        State red = new State("red");
//        State green = new State("green");
//        State yellow = new State("yellow");
//
//        Port reset = new Port();
//        Port increment = new Port();
//        Port idle = new Port();
//
//        Condition lessThan10 = new Condition(t -> t < 10);
//        Condition lessThan5 = new Condition(t -> t < 5);
//        Condition equals10 = new Condition(t -> t == 10);
//        Condition equals5 = new Condition(t -> t == 5);
//
//        Action incrementT = new Action(t -> t + 1 );
//        Action resetT = new Action(t -> 0);
//
//        Transition t1 = new Transition(red, red, increment, lessThan10, incrementT);
//        Transition t2 = new Transition(red, green, reset, equals10, resetT);
//
//        Transition t3 = new Transition(green, green, increment, lessThan10, incrementT);
//        Transition t4 = new Transition(green, yellow, reset, equals10, resetT);
//
//        Transition t5 = new Transition(yellow, yellow, increment, lessThan5, incrementT);
//        Transition t6 = new Transition(yellow, red, reset, equals5, resetT);
//
//
//        State[] states = {red, green, yellow};
//        Transition[] transitions = {t1, t2, t3, t4, t5, t6};
//        Port[] ports = {reset, increment, idle};
//
//        FSM m = new FSM(states, red, transitions, ports);
//        m.printPorts();
//        m.printStates();
//        m.drawFSM();
//
//        m.run(40);    // run the FSM for 40 steps
//
//        m.reset();      // reset the FSM to its original state and transition
//
//        m.run(20);

        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");

        Condition smallerEqThan5 = new Condition(t -> t <= 5);
        Condition greaterThan4 = new Condition(t -> t > 4);
        Condition smallerThan4 = new Condition(t -> t < 4);
        Condition smallerEqThan10 = new Condition(t -> t <= 10);
        Condition greaterThan3 = new Condition(t -> t > 3);

        Action incrementT = new Action(t -> t + 1 );
        Action decrementT = new Action(t -> t - 1 );

        Port p0 = new Port(), p1 = new Port(), p2 = new Port(), p3 = new Port();




        Transition t0 = new Transition(q0, q0, p1, greaterThan4, decrementT);
        Transition t1 = new Transition(q0, q1, p0, smallerThan4, incrementT);
        Transition t2 = new Transition(q1, q1, p1, greaterThan3, decrementT);
        Transition t3 = new Transition(q1, q0, p0, smallerEqThan10, incrementT);

        Transition t4 = new Transition(q2, q2, p3, greaterThan4, decrementT);
        Transition t5 = new Transition(q2, q3, p2, smallerThan4, incrementT);
        Transition t6 = new Transition(q3, q3, p3, greaterThan3, decrementT);
        Transition t7 = new Transition(q3, q2, p2, smallerEqThan10, incrementT);


        State[] states1 = {q0, q1};
        Transition[] transitions1 = {t0, t1, t2, t3};
        Port[] ports1 = {p0, p1};
        FSM m1 = new FSM(states1, q0, transitions1, ports1, 1); // x = 1
        m1.name = "FSM1"; m1.variableName = "x";

        State[] states2 = {q2, q3};
        Transition[] transitions2 = {t4, t5, t6, t7};
        Port[] ports2 = {p2, p3};
        FSM m2 = new FSM(states2, q2, transitions2, ports2, 9); // y = 9
        m2.name = "FSM2"; m2.variableName = "y";

        Interaction interaction = new Interaction(p1, p2, smallerEqThan5, incrementT, 0,transitions1,transitions2);  // z = 0
        interaction.run(2);

    }



}
