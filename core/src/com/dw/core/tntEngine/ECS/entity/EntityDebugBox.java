package com.dw.core.tntEngine.ECS.entity;

import com.dw.core.tntEngine.ECS.component.ComponentCollisionBody;
import com.dw.core.tntEngine.ECS.controller.ControllerCollisionDetection;
import com.dw.core.tntEngine.ECS.controller.ControllerRenderDebug;

public class EntityDebugBox extends Entity {

    public EntityDebugBox(){
        super();

        addComponent(new ComponentCollisionBody(this, 400, 400));
        addController(new ControllerRenderDebug(this));
        addController(new ControllerCollisionDetection(this));
    }
}
