package com.dw.core.torresECS.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.dw.core.torresECS.component.Component;
import com.dw.core.torresECS.component.ComponentBody;
import com.dw.core.torresECS.entity.Entity;
import com.dw.core.torresECS.system.RenderSystem;

public class ControllerRenderDebug extends Controller {

    private ComponentBody componentBody;
    private ControllerCollisionDetection controllerCollision;

    public ControllerRenderDebug(Entity parentEntity) {
        super(parentEntity);
    }

    @Override
    public void update() {

        RenderSystem.shapeRenderer.setColor(Color.WHITE);

     try{
        controllerCollision = (ControllerCollisionDetection) findController(ControllerCollisionDetection.class);
        if(controllerCollision.getTargetEntities().size() > 0){
            RenderSystem.shapeRenderer.setColor(Color.GREEN);
        }
     }catch (Exception e){

     }

     try{
            componentBody = (ComponentBody) findComponent(ComponentBody.class);
            RenderSystem.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            RenderSystem.shapeRenderer.rect(componentBody.getPosX(), componentBody.getPosY(), componentBody.getSizeX(), componentBody.getSizeY());
            RenderSystem.shapeRenderer.end();

     }catch (Exception e){

     }

    }

}
