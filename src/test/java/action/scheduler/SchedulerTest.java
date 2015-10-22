package action.scheduler;

import org.junit.Test;

import exception.ActionFinishedException;
import action.Action;
import action.ActionTest;

public abstract class SchedulerTest extends ActionTest {

	@Test
	public abstract void doStepTest() throws ActionFinishedException;
	
	public Action createAction(){
		Scheduler scheduler = createTypeScheduler();
		scheduler.addAction(createForeseebleAction(1));
		return scheduler;
	}
	
	public abstract Scheduler createTypeScheduler();

}
