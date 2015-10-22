package foreseebleAction;
import action.Action;


public class ForeseebleAction extends Action {
	
	protected int totalTime;
	protected int remainingTime;
	
	public ForeseebleAction(int timeToEnd) {
		// TODO Auto-generated constructor stub
		this.totalTime=timeToEnd;
		this.remainingTime=timeToEnd;
	}
	
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return remainingTime==totalTime;
	}
	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return !isReady()&&!isFinished();
	}
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return remainingTime<=0;
	}
	@Override
	public void reallyDoStep() {
		// TODO Auto-generated method stub
		remainingTime--;
	}
	
}
