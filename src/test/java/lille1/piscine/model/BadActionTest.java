package lille1.piscine.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by svirchevsky on 15/10/15.
 */
public class BadActionTest {

    private BadAction createAction(int timeToEnd) {
        return new BadAction(timeToEnd);
    }

    @Test
    public void foreseeableAction() {
        BadAction action = createAction(2);
// 2 steps remaining
        assertTrue(action.isReady());
        assertFalse(action.isInProgress());
        assertFalse(action.isFinished());
        action.doStep();
// 1 step remaining
        assertFalse(action.isReady());
        assertTrue(action.isInProgress());
        assertFalse(action.isFinished());
        action.doStep();
// 0 step remaining
        assertFalse(action.isReady());
        assertFalse(action.isInProgress());
        assertTrue(action.isFinished());
    }

    @Test
    public void scheduler() {
        BadAction action1 = createAction(2);
        BadAction action2 = createAction(1);
        BadAction scheduler = createAction(0);
        scheduler.addAction(action1);
        scheduler.addAction(action2);
        assertTrue(action1.isReady());
        assertTrue(action2.isReady());
        scheduler.doStep();
        assertTrue(action1.isInProgress());
        assertTrue(action2.isReady());
        scheduler.doStep();
        assertTrue(action1.isFinished());
        assertTrue(action2.isReady());
        scheduler.doStep();
        assertTrue(action1.isFinished());
        assertTrue(action2.isFinished());
    }

    @Test
    public void schedulerWithScheduler() {
        BadAction action1 = createAction(2);
        BadAction subScheduler = createAction(0);
        BadAction scheduler = createAction(0);
        subScheduler.addAction(action1);
        scheduler.addAction(subScheduler);
        assertTrue(action1.isReady());
        assertTrue(subScheduler.isReady());
        scheduler.doStep();
        assertTrue(action1.isInProgress());
        assertTrue(subScheduler.isInProgress());
        scheduler.doStep();
        assertTrue(action1.isFinished());
        assertTrue(subScheduler.isFinished());
    }

    @Test
    public void onlyOneValidStateAtEachMomentForForeseebleAction() {
        onlyOneValidStateAtEachMoment(createAction(10));
    }

    @Test
    public void onlyOneValidStateAtEachMomentForScheduler() {
        BadAction scheduler = createAction(0);
        scheduler.addAction(createAction(1));
        onlyOneValidStateAtEachMoment(scheduler);
    }

    protected void onlyOneValidStateAtEachMoment(BadAction action) {
        assertTrue(action.isReady());
        assertFalse(action.isInProgress());
        assertFalse(action.isFinished());

    }
}