package lille1.piscine.model;


public abstract class Action
{
    public abstract boolean isReady();

    public abstract boolean isInProgress();

    public abstract boolean isFinished();

	public abstract void doStep();
}

