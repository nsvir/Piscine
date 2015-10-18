package action;

import exception.ActionFinishedException;

public abstract class Action {
	
	public abstract boolean isReady();
	public abstract boolean isInProgress();
	public abstract boolean isFinished();
	
	public void doStep() throws ActionFinishedException{
		if(isFinished())
			throw new ActionFinishedException();
		reallyDoStep();
	}
	
	public abstract void reallyDoStep();
}
