package lille1.piscine.model;

import java.util.ArrayList;

/**
 * Created by svirchevsky on 15/10/15.
 */
public class SchedulerAction extends Action {

    protected final ArrayList<Action> actions = new ArrayList<Action>();

    protected boolean isReady = false;
    protected boolean isInitialized = false;

    public SchedulerAction() {
    }

    @Override
    public boolean isReady() {
        return isInitialized && isReady;
    }

    @Override
    public boolean isInProgress() {
        return isInitialized && !isReady() && !isFinished();
    }

    @Override
    public boolean isFinished() {
        return isInitialized && !isReady() && actions.isEmpty();
    }

    public void doStep() {
        isReady = false;
        Action nextAction = actions.get(0);
        nextAction.doStep();
        if (nextAction.isFinished()) {
            actions.remove(0);
        }
    }

    public void addAction(Action subAction) {
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
