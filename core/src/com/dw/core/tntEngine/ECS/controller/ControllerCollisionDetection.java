package com.dw.core.tntEngine.ECS.controller;

import com.dw.core.tntEngine.ECS.entity.Entity;
import com.dw.core.tntEngine.ECS.component.ComponentCollisionBody;

public class ControllerCollisionDetection extends Controller{

    private ComponentCollisionBody componentCollisionBody, componentCollisionBodyTarget;

    public ControllerCollisionDetection(Entity parentEntity) {
        super(parentEntity);
    }

    @Override
    public void update() {

        try{
            componentCollisionBody = (ComponentCollisionBody) findComponent(ComponentCollisionBody.class);
            componentCollisionBodyTarget = (ComponentCollisionBody) getTargetEntity().findComponent(ComponentCollisionBody.class);

            if(componentCollisionBody.getRectangle().overlaps(componentCollisionBodyTarget.getRectangle()) &&
               getParentEntity().getEntityID() != getTargetEntity().getEntityID()){
                addTargetEntity(getTargetEntity());
            }else{
                removeTargetEntity(getTargetEntity());
            }


        }catch (Exception e){

        }

    }

}
