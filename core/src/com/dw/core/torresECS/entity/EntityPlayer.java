package com.dw.core.torresECS.entity;

import com.dw.core.torresECS.component.ComponentBody;
import com.dw.core.torresECS.controller.ControllerCollisionDetection;
import com.dw.core.torresECS.controller.ControllerPlayerMovement;
import com.dw.core.torresECS.controller.ControllerRenderDebug;
import com.dw.core.torresECS.entity.Entity;
import com.dw.core.torresECS.system.RenderSystem;

public class EntityPlayer extends Entity {

    public EntityPlayer(){
        super();
        RenderSystem.setCameraFollow(this);
        addComponent(new ComponentBody(this, 10, 10, 100, 100));

        addController(new ControllerPlayerMovement(this));
        addController(new ControllerCollisionDetection(this));
        addController(new ControllerRenderDebug(this));
    }

}
