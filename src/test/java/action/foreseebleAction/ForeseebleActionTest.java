package action.foreseebleAction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exception.ActionFinishedException;
import action.Action;
import action.ActionTest;

public class ForeseebleActionTest extends ActionTest {
	
	@Override
	public Action createAction() {
		// TODO Auto-generated method stub
		return createForeseebleAction(10);
	}
	
	@Test
	public void doStepTest() throws ActionFinishedException {
		Action action = createForeseebleAction(2);
		
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}

}
