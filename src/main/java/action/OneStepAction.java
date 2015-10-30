package action;

public abstract class OneStepAction extends Action {

	private boolean finish=false;

	public void reallyDoStep(){
		finish=true;
		reallyDoStepTwo();
	}

	protected abstract void reallyDoStepTwo();

	@Override
	public boolean isReady() {
		return !finish;
	}

	@Override
	public boolean isInProgress() {
		return !finish;
	}

	public boolean isFinished(){
		return finish;
	}
	
}
