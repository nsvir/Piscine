package resource;

import resource.Resource;

/**
 * Created by nanosvir on 30 Oct 15.
 * n.svirchevsky@gmail.com
 */
public class ResourcefulUser<R extends Resource> {

    protected R resource;

    public R getResource() {
        return resource;
    }
    public void setResource(R resource) {
        this.resource = resource;
    }
    public void resetResource() {
        this.resource = null;
    }
}
