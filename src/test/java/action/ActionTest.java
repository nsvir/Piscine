package action;

import static org.junit.Assert.*;

import org.junit.Test;

import scheduler.FairScheduler;
import scheduler.SequentialScheduler;
import exception.ActionFinishedException;
import foreseebleAction.ForeseebleAction;

public abstract class ActionTest {
	
	protected ForeseebleAction createForeseebleAction(int timeToEnd){
		return new ForeseebleAction(timeToEnd);
	}
	
	protected FairScheduler createFairScheduler(){
		return new FairScheduler();
	}
	
	protected SequentialScheduler createSequentialScheduler(){
		return new SequentialScheduler();
	}

	public abstract Action createAction();
	
	@Test
	public void onlyOneValidStateAtEachMoment() {
		Action action = createAction();
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		
		while(!action.isFinished()){
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertFalse(action.isReady());
			assertTrue(action.isFinished()==!action.isInProgress());
		}
		
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
	
	@Test(expected = ActionFinishedException.class, timeout = 20000)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException {
		Action action = createAction();
		while(!action.isFinished()){
			try {
				action.doStep();
			} catch (ActionFinishedException e){
				fail("action was not supposed to be finished, we just checked");
			}
		}
		assertTrue(action.isFinished());
		action.doStep();
	}

}
