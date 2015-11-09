import exception.ActionFinishedException;
import resource.resourcePool.BasketPool;
import resource.resourcePool.CubiclePool;
import resource.resourcePool.ResourcePool;
import action.scheduler.FairScheduler;

public class Swim {

    static BasketPool basket;
    static CubiclePool cubicles;

    public static Swimmer createSwimmer(String name, int dressTime, int swimTime, int undressTime) {
        return new Swimmer(name, basket, cubicles, dressTime, swimTime, undressTime);
    }

	public static void main(String[] args) {
        basket = new BasketPool(10);
        cubicles = new CubiclePool(5);

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
