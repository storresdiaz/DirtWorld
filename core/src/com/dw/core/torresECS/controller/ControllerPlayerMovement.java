package com.dw.core.torresECS.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.dw.core.torresECS.component.ComponentCollisionBody;
import com.dw.core.torresECS.component.ComponentProperties;
import com.dw.core.torresECS.entity.Entity;

public class ControllerPlayerMovement extends Controller {

    private ComponentProperties componentProperties;

    public ControllerPlayerMovement(Entity parentEntity) {
        super(parentEntity);
    }


    @Override
    public void update() {

        try{
            componentProperties = (ComponentProperties) findComponent(ComponentProperties.class);

            // Right
            if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                componentProperties.setPosX(componentProperties.getPosX() + 5);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                componentProperties.setPosX(componentProperties.getPosX() - 5);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.W)){
                componentProperties.setPosY(componentProperties.getPosY() - 5);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.S)){
                componentProperties.setPosY(componentProperties.getPosY() + 5);
            }


        }catch(Exception e){

        }

    }

}
