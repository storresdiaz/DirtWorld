package com.dw.core.torresECS.entity;

import com.dw.core.torresECS.component.ComponentBody;
import com.dw.core.torresECS.controller.ControllerCollisionDetection;
import com.dw.core.torresECS.controller.ControllerRenderDebug;

public class EntityDebugBox extends Entity {

    public EntityDebugBox(){
        super();

        addComponent(new ComponentBody(this, 400, 400, 200, 200));

        addController(new ControllerRenderDebug(this));
        addController(new ControllerCollisionDetection(this));
    }
}
