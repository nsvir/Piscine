package exception;

public class ActionFinishedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionFinishedException(){
		super("The action is already finished.");
	}
}
