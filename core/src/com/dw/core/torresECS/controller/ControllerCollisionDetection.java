package com.dw.core.torresECS.controller;

import com.dw.core.torresECS.component.ComponentBody;
import com.dw.core.torresECS.entity.Entity;

public class ControllerCollisionDetection extends Controller{

    private ComponentBody componentBody, componentBodyTarget;

    public ControllerCollisionDetection(Entity parentEntity) {
        super(parentEntity);
    }

    @Override
    public void update() {

        try{
            componentBody = (ComponentBody) findComponent(ComponentBody.class);
            componentBodyTarget = (ComponentBody) getTargetEntity().findComponent(ComponentBody.class);

            if(componentBody.getRectangle().overlaps(componentBodyTarget.getRectangle()) &&
               getParentEntity().getEntityID() != getTargetEntity().getEntityID()){
                addTargetEntity(getTargetEntity());
            }else{
                removeTargetEntity(getTargetEntity());
            }


        }catch (Exception e){

        }

    }

}
