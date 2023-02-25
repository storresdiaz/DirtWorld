package com.dw.core.torresECS.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.dw.core.torresECS.component.ComponentBody;
import com.dw.core.torresECS.entity.Entity;

public class ControllerPlayerMovement extends Controller {

    private ComponentBody componentBody;

    public ControllerPlayerMovement(Entity parentEntity) {
        super(parentEntity);
    }


    @Override
    public void update() {

        try{
            componentBody = (ComponentBody) findComponent(ComponentBody.class);

            // Right
            if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                componentBody.setPosX(componentBody.getPosX() + 5);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                componentBody.setPosX(componentBody.getPosX() - 5);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.W)){
                componentBody.setPosY(componentBody.getPosY() - 5);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.S)){
                componentBody.setPosY(componentBody.getPosY() + 5);
            }


        }catch(Exception e){

        }

    }

}
