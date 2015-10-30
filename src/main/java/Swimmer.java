import action.scheduler.SequentialScheduler;
import foreseebleAction.SwimAction;
import foreseebleAction.UndressAction;
import resource.ResourcePool;

/**
 * Created by nanosvir on 30 Oct 15.
 * n.svirchevsky@gmail.com
 */
public class Swimmer extends SequentialScheduler {

    protected String name;


    public  Swimmer(String name, ResourcePool baskets, ResourcePool cubicles, int undressTime, int swimTime, int dressTime) {
        this.name = name;
        assignTasks(baskets, cubicles, undressTime, swimTime, dressTime);
    }

    protected void assignTasks(ResourcePool baskets, ResourcePool cubicles, int undressTime, int swimTime, int dressTime) {
        this.addAction(new SwimAction(swimTime));
        this.addAction(new UndressAction(undressTime));
    }

    @Override
    public void reallyDoStep() {
        System.out.println(this.name + " try to execute " + actions.get(0).getClass());
        super.reallyDoStep();
    }
}
