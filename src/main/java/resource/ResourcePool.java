package resource;

/**
 * Created by nsvir on 22/10/15.
 * n.svirchevsky@gmail.com
 */
public interface ResourcePool {

    void provideResource();
    void freeResource(Resource r);
}
