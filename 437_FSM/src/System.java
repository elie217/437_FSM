/**
 * Created by elietamer on 4/4/18.
 */
public class System {
    private Interaction[] interactions;

    public System (Interaction[] interactions){
        this.interactions=interactions;
    }

    public void execute(int nbSteps){
        for (Interaction i : interactions)
            i.run(nbSteps);
    }
}
