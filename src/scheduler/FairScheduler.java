package scheduler;

import exception.ActionFinishedException;
import action.Action;

public class FairScheduler extends Scheduler {
	
	private int idNextAction = 0;
	
	@Override
	public void reallyDoStepTwo() {
		// TODO Auto-generated method stub
		Action nextAction = actions.get(idNextAction);
		try {
			nextAction.doStep();
		} catch (ActionFinishedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nextAction.isFinished())
			actions.remove(idNextAction);
		else
			idNextAction++;
		if(idNextAction>=actions.size())
			idNextAction=0;
	}

}
