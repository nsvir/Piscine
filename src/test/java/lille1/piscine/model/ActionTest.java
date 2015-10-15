package lille1.piscine.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by svirchevsky on 15/10/15.
 */
public abstract class ActionTest {

    protected Action action;

    @Before
    public void setup() {
        action = createAction();
    }

    @Test
    public void foreseeableAction() {

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

    protected abstract Action createAction();

    @Test
    public void onlyOneValidStateAtEachMoment() {
        assertTrue(action.isReady());
        assertFalse(action.isInProgress());
        assertFalse(action.isFinished());
    }

}
