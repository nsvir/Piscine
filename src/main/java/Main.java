import exception.ActionFinishedException;
import resource.ResourcePool;
import action.scheduler.FairScheduler;

public class Main {

	public static void main(String[] args) {
		ResourcePool basket;
		ResourcePool cubicles;
		FairScheduler s = new FairScheduler();

		s.addAction(null);

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
