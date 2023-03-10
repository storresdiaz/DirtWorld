package com.dw.core.tntEngine.ECS.system;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dw.core.tntEngine.ECS.component.ComponentProperties;
import com.dw.core.tntEngine.ECS.entity.Entity;

public class RenderSystem {


    public static OrthographicCamera cameraMain;
    public static StretchViewport viewportMain;
    public static ShapeRenderer shapeRenderer;

    private static Entity followEntity;

    public static void initialize(){
        cameraMain = new OrthographicCamera();
        cameraMain.setToOrtho(true);
        cameraMain.position.set(0, 0, 0);
        viewportMain = new StretchViewport(1920, 1080, cameraMain);

        shapeRenderer = new ShapeRenderer();


    }

    public static void update(){
        cameraMain.update(true);
        shapeRenderer.setProjectionMatrix(cameraMain.combined);

        followEntity();
    }

    /**
     * Method that dictates how the camera follows the follow Entity
     */
    private static void followEntity(){

        try{
            ComponentProperties componentProperties = (ComponentProperties) followEntity.findComponent(ComponentProperties.class);
            cameraMain.position.lerp(new Vector3(componentProperties.getPosX() + componentProperties.getWidth() / 2, componentProperties.getPosY() + componentProperties.getHeight() / 2, 0), 0.10f);
        }catch (Exception e){

        }

    }

    public static void resize(int width, int height){
        viewportMain.update(width, height);
    }

    /**
     * @param entity The entity for the camera to follow
     */
    public static void setCameraFollow(Entity entity){
        followEntity = entity;
    }



}
