package resource.resourcePool;

import org.junit.Before;
import org.junit.Test;

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
    public void testProvideResource() {
        basketPool = new BasketPool(expected);
        for (int i = 0; i < expected; i++) {
            assertNotNull(basketPool.provideResource());
        }
    }

    @Test (expected = EmptyStackException.class)
    public void testProvideResourceEmpty() {
        emptyBasketPool.provideResource();
    }


    @Test
    public void testFreeResource() throws Exception {

    }
}