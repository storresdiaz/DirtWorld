package com.dw.core.torresECS.entity;

import com.dw.core.torresECS.component.Component;
import com.dw.core.torresECS.component.ComponentBodyParts;
import com.dw.core.torresECS.component.ComponentCollisionBody;
import com.dw.core.torresECS.component.ComponentProperties;
import com.dw.core.torresECS.component.objects.BodyPart;
import com.dw.core.torresECS.controller.ControllerCollisionDetection;
import com.dw.core.torresECS.controller.ControllerPlayerMovement;
import com.dw.core.torresECS.controller.ControllerRenderDebug;
import com.dw.core.torresECS.system.RenderSystem;

public class EntityPlayer extends Entity {

    private ComponentProperties componentProperties;

    public EntityPlayer(){
        super();
        RenderSystem.setCameraFollow(this);

        addComponent(new ComponentCollisionBody(this, 100, 100));
        addComponent(new ComponentBodyParts(this));
        addController(new ControllerPlayerMovement(this));
        addController(new ControllerCollisionDetection(this));
        addController(new ControllerRenderDebug(this));

        ComponentBodyParts componentBodyParts = (ComponentBodyParts) findComponent(ComponentBodyParts.class);
        componentBodyParts.addBodyPart(new BodyPart("head"));

    }

}
