package lille1.piscine.model;

/**
 * Created by svirchevsky on 15/10/15.
 */
public class ForeseeableTest extends ActionTest{

    private int timeRemaining = 10;

    @Override
    protected Action createAction() {
        return new Foreseeable(timeRemaining);
    }
}
