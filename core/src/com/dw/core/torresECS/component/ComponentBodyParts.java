package com.dw.core.torresECS.component;

import com.dw.core.torresECS.entity.Entity;

public class ComponentBodyPart extends Component {

    private String name;
    private float relativePosX, relativePosY, worldPosX, worldPosY;

    public ComponentBodyPart(Entity parentEntity, String name) {
        super(parentEntity);
        this.name = name;
    }

    public ComponentBodyPart(Entity parentEntity, String name, float relativePosX, float relativePosY) {
        super(parentEntity);
        this.name = name;
        this.relativePosX = relativePosX;
        this.relativePosY = relativePosY;
    }

    @Override
    public void update() {
        super.update();
        try{
            setWorldPosX(getParentEntity().getProperties().getPosX() + relativePosX);
            setWorldPosY(getParentEntity().getProperties().getPosY() + relativePosY);
        }catch (Exception e){

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRelativePosX() {
        return relativePosX;
    }

    public void setRelativePosX(float relativePosX) {
        this.relativePosX = relativePosX;
    }

    public float getRelativePosY() {
        return relativePosY;
    }

    public void setRelativePosY(float relativePosY) {
        this.relativePosY = relativePosY;
    }

    public float getWorldPosX() {
        return worldPosX;
    }

    public void setWorldPosX(float worldPosX) {
        this.worldPosX = worldPosX;
    }

    public float getWorldPosY() {
        return worldPosY;
    }

    public void setWorldPosY(float worldPosY) {
        this.worldPosY = worldPosY;
    }
}
