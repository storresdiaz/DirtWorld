package com.dw.core.torresECS.component;

import com.dw.core.torresECS.entity.Entity;


/**
 * Automatically added to each Entity.
 */
public class ComponentProperties extends Component {

    private float posX, posY, width, height;

    private boolean isVisible = true;

    private String name;

    public ComponentProperties(Entity parentEntity){
        super(parentEntity);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
