package com.dw.core.tntEngine.ECS.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.dw.core.tntEngine.ECS.entity.Entity;
import com.dw.core.tntEngine.ECS.system.RenderSystem;
import com.dw.core.tntEngine.ECS.component.ComponentCollisionBody;

public class ControllerRenderDebug extends Controller {

    private ComponentCollisionBody componentCollisionBody;

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
            componentCollisionBody = (ComponentCollisionBody) findComponent(ComponentCollisionBody.class);
            RenderSystem.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            RenderSystem.shapeRenderer.rect(componentCollisionBody.getPosX(), componentCollisionBody.getPosY(), componentCollisionBody.getWidth(), componentCollisionBody.getHeight());
            RenderSystem.shapeRenderer.end();

     }catch (Exception e){

     }

    }

}
