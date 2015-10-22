package scheduler;

import exception.ActionFinishedException;
import action.Action;

public class SequentialScheduler extends Scheduler {

	@Override
	public void reallyDoStepTwo() {
		// TODO Auto-generated method stub
		Action nextAction = actions.get(0);
		try {
			nextAction.doStep();
		} catch (ActionFinishedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nextAction.isFinished())
			actions.remove(0);
	}

}
