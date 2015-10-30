package resource.resourcePool;

import org.junit.Before;
import org.junit.Test;
import resource.resourcePool.exception.NoResourceAvailable;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Created by nanosvir on 30 Oct 15.
 * n.svirchevsky@gmail.com
 */
public class BasketPoolTest {

    private int expected = 5;
    private BasketPool basketPool;
    private BasketPool emptyBasketPool;

    @Before
    public void setUp() throws Exception {
        basketPool = new BasketPool(5);
        emptyBasketPool = new BasketPool(0);
    }

    @Test
    public void testProvideResource() throws NoResourceAvailable {
        basketPool = new BasketPool(expected);
        for (int i = 0; i < expected; i++) {
            assertNotNull(basketPool.provideResource());
        }
    }

    @Test (expected = NoResourceAvailable.class)
    public void testProvideResourceEmpty() throws NoResourceAvailable {
        emptyBasketPool.provideResource();
    }


    @Test
    public void testFreeResource() throws Exception {

    }
}