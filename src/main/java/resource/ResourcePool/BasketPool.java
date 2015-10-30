package resource.resourcePool;

import resource.Basket;

/**
 * Created by nanosvir on 30 Oct 15.
 * n.svirchevsky@gmail.com
 */
public class BasketPool extends ResourcePool {

    public BasketPool(int capacityNumber) {
        while (capacityNumber-- > 0) {
            pool.push(new Basket());
        }
    }
}
