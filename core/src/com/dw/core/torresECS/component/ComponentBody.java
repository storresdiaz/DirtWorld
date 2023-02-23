package com.dw.core.torresECS.component;

import com.badlogic.gdx.math.Rectangle;
import com.dw.core.torresECS.entity.Entity;

public class ComponentBody extends Component {

    private float lastPosX, lastPosY, posX, posY;

    private float sizeX, sizeY;

    private Rectangle rectangle;

    public ComponentBody(Entity parentEntity) {
        super(parentEntity);
        rectangle = new Rectangle();

    }

    public ComponentBody(Entity parentEntity, float posX, float posY, float sizeX, float sizeY){
        super(parentEntity);
        rectangle = new Rectangle();
        rectangle.set(posX, posY, sizeX, sizeY);
        setSizeX(sizeX);
        setSizeY(sizeY);
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void update() {
        super.update();
        rectangle.set(posX, posY, sizeX, sizeY);
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getSizeX() {
        return sizeX;
    }

    public void setSizeX(float sizeX) {
        this.sizeX = sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }

    public void setSizeY(float sizeY) {
        this.sizeY = sizeY;
    }

    public float getLastPosX() {
        return lastPosX;
    }

    public void setLastPosX(float lastPosX) {
        this.lastPosX = lastPosX;
    }

    public float getLastPosY() {
        return lastPosY;
    }

    public void setLastPosY(float lastPosY) {
        this.lastPosY = lastPosY;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
