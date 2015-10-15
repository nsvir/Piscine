package lille1.piscine.model;

import java.util.ArrayList;

/**
 * Created by svirchevsky on 15/10/15.
 */
public class BadAction {
    protected final int totalTime;
    protected int remainingTime;
    protected boolean isReady = true;
    protected boolean isInitialized = false;
    protected final boolean isScheduler;
    // this variable is only used for schedulers (isScheduler = true)
    protected final ArrayList<BadAction> actions = new ArrayList<BadAction>();
    /**
     * Either create a foreseeable action or a scheduler based on the value of
     * <code>timeToEnd</code>.
     *
     * @param timeToEnd
     *            For a foreseeable action, indicate the number of
     *            <code>doStep()</code> calls required. For a scheduler, must be
     *            0.
     */
    public BadAction(int timeToEnd) {
        this.totalTime = timeToEnd;
        if (timeToEnd == 0) {
            isScheduler = true;
        } else {
            isScheduler = false;
            this.remainingTime = timeToEnd;
        }
    }
    public boolean isReady() {
        if (!isScheduler) {
            return remainingTime == totalTime;
        } else {
            return isInitialized && isReady;
        }
    }
    public boolean isInProgress() {
        if (!isScheduler) {
            return !isReady() && !isFinished();
        } else {
            return isInitialized && !isReady() && !isFinished();
        }
    }
    public boolean isFinished() {
        if (!isScheduler) {
            return remainingTime <= 0;
        } else {
            return isInitialized && !isReady() && actions.isEmpty();
        }
    }
    public void doStep() {
        if (!isScheduler) {
            remainingTime--;
        } else {
            isReady = false;
            BadAction nextAction = actions.get(0);
            nextAction.doStep();
            if (nextAction.isFinished()) {
                actions.remove(0);
            }
        }
    }
    public void addAction(BadAction subAction) {
        isInitialized = true;
        if (subAction.isFinished()) {
            throw new IllegalArgumentException(
                    "Can’t add an already finished action");
        }
        if (isFinished()) {
            throw new IllegalStateException(
                    "You can’t add an action to a finished scheduler");
        } else {
            actions.add(subAction);
        }
    }
}