package com.dw.core.torresECS.entity;

import com.dw.core.torresECS.component.ComponentCollisionBody;
import com.dw.core.torresECS.controller.ControllerCollisionDetection;
import com.dw.core.torresECS.controller.ControllerRenderDebug;

public class EntityDebugBox extends Entity {

    public EntityDebugBox(){
        super();

        addComponent(new ComponentCollisionBody(this, 400, 400));
        addController(new ControllerRenderDebug(this));
        addController(new ControllerCollisionDetection(this));
    }
}
