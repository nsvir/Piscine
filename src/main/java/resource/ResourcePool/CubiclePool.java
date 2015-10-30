package resource.resourcePool;

import resource.cubicle;

/**
 * Created by nanosvir on 30 Oct 15.
 * n.svirchevsky@gmail.com
 */
public class CubiclePool extends ResourcePool {

    public CubiclePool(int capacityNumber) {
        while (capacityNumber-- > 0) {
            pool.push(new cubicle());
        }
    }
}
