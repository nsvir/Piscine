package resource.resourcePool;

import resource.Resource;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by nsvir on 22/10/15.
 * n.svirchevsky@gmail.com
 */
public abstract class ResourcePool {

    Stack<Resource> pool = new Stack<>();

    public Resource provideResource() {
        return pool.pop();
    }
    public void freeResource(Resource r) {
        pool.push(r);
    }
}
