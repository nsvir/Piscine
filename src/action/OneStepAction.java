package action;

public class OneStepAction {

	private boolean finish=false;
	
	public void reallyDoStep(){
		finish=true;
	}
	
	public boolean isFinished(){
		return finish;
	}
	
}
