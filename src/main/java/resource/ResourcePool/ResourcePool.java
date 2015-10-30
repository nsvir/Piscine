package resource.resourcePool;

import resource.Resource;
import resource.resourcePool.exception.NoResourceAvailable;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by nsvir on 22/10/15.
 * n.svirchevsky@gmail.com
 */
public abstract class ResourcePool {

    Stack<Resource> pool = new Stack<>();

    public Resource provideResource() throws NoResourceAvailable {
        try {
            return pool.pop();
        } catch (EmptyStackException e) {
            throw new NoResourceAvailable();
        }
    }
    public void freeResource(Resource r) {
        pool.push(r);
    }
}
