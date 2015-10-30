import exception.ActionFinishedException;
import resource.ResourcePool;
import action.scheduler.FairScheduler;

public class Swim {

    static ResourcePool basket;
    static ResourcePool cubicles;

    public static Swimmer createSwimmer(String name, int dressTime, int swimTime, int undressTime) {
        return new Swimmer(name, basket, cubicles, dressTime, swimTime, undressTime);
    }

	public static void main(String[] args) {
        basket = null;
        cubicles = null;
		FairScheduler s = new FairScheduler();

		s.addAction(createSwimmer("Valerie", 10, 20, 3));
		s.addAction(createSwimmer("Jack", 5, 3, 10));
		s.addAction(createSwimmer("Pistachio", 3, 10, 3));

        int nbSteps = 0;
        while (!s.isFinished()) {
            nbSteps++;
            try {
                s.doStep();
            } catch (ActionFinishedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished in " + nbSteps + " steps");
	}

}
