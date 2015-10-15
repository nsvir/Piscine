package lille1.piscine.model;

/**
 * Created by svirchevsky on 15/10/15.
 */
public class Foreseeable extends Action {

    protected final int totalTime;
    protected int remainingTime;

    /**
     * Either create a foreseeable action or a scheduler based on the value of
     * <code>timeToEnd</code>.
     *
     * @param timeToEnd For a foreseeable action, indicate the number of
     *                  <code>doStep()</code> calls required. For a scheduler, must be
     *                  0.
     */
    public Foreseeable(int timeToEnd) {
        this.totalTime = timeToEnd;
        this.remainingTime = timeToEnd;
    }

    @Override
    public boolean isReady() {
        return remainingTime == totalTime;
    }

    @Override
    public boolean isInProgress() {
        return !isReady() && !isFinished();
    }

    @Override
    public boolean isFinished() {
        return remainingTime <= 0;
    }

    @Override
    public void doStep() {
        remainingTime--;
    }
}
