package com.dw.core.torresECS.system;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dw.core.torresECS.component.ComponentBody;
import com.dw.core.torresECS.entity.Entity;

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

    private static void followEntity(){

        try{
            ComponentBody componentBody = (ComponentBody) followEntity.findComponent(ComponentBody.class);
            cameraMain.position.lerp(new Vector3(componentBody.getPosX() + componentBody.getSizeX() / 2, componentBody.getPosY() + componentBody.getSizeY() / 2, 0), 0.2f);
        }catch (Exception e){

        }

    }

    public static void resize(int width, int height){
        viewportMain.update(width, height);
    }

    public static void setCameraFollow(Entity entity){
        followEntity = entity;
    }



}
