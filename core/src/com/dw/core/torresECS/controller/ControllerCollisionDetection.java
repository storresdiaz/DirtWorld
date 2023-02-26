package com.dw.core.torresECS.controller;

import com.dw.core.torresECS.component.ComponentCollisionBody;
import com.dw.core.torresECS.entity.Entity;

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
