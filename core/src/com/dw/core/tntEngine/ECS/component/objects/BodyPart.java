package com.dw.core.tntEngine.ECS.component.objects;

import com.badlogic.gdx.math.Rectangle;

public class BodyPart{
    private float relativePosX, relativePosY, worldPosX, worldPosY;
    private String name;

    private Sprite sprite;

    private Rectangle collisionRect;

    private boolean isVisible = true;

    public BodyPart(String name){
        this.name = name;
        collisionRect = new Rectangle();
    }

    public void update(){
        collisionRect.setPosition(worldPosX, worldPosY);
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

    public String getName() {
        return name;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(Rectangle collisionRect) {
        this.collisionRect = collisionRect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
