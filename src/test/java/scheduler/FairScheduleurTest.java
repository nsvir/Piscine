package scheduler;

import static org.junit.Assert.assertTrue;
import exception.ActionFinishedException;
import action.Action;

public class FairScheduleurTest extends SchedulerTest {

	@Override
	public Scheduler createTypeScheduler() {
		// TODO Auto-generated method stub
		return createFairScheduler();
	}

	@Override
	public void doStepTest() throws ActionFinishedException {
		// TODO Auto-generated method stub
		Action action1=createForeseebleAction(2);
		Action action2=createForeseebleAction(1);
		
		Scheduler scheduler=createFairScheduler();
		scheduler.addAction(action1);
		scheduler.addAction(action2);
		
		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		
		scheduler.doStep();
		
		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());
		
		scheduler.doStep();
		
		assertTrue(action1.isInProgress());
		assertTrue(action2.isFinished());
		
		scheduler.doStep();
		
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
	}

}
