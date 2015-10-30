package action.foreseebleAction;

import resource.Resource;
import resource.resourcePool.ResourcePool;
import resource.ResourcefulUser;

/**
 * Created by nanosvir on 30 Oct 15.
 * n.svirchevsky@gmail.com
 */
public class TakeResourceAction extends ResourceAction {

    protected ResourcePool resourcePool;
    protected ResourcefulUser<? extends Resource> resourcefulUser;

    public TakeResourceAction(ResourcePool resourcePool, ResourcefulUser<? extends Resource> resourcefulUser) {
        this.resourcePool = resourcePool;
        this.resourcefulUser = resourcefulUser;
    }

    @Override
    public void reallyDoStep() {
        super.reallyDoStep();
    }

    @Override
    protected void reallyDoStepTwo() {

    }
}
