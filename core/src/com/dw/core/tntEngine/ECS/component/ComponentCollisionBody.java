package com.dw.core.tntEngine.ECS.component;

import com.badlogic.gdx.math.Rectangle;
import com.dw.core.tntEngine.ECS.entity.Entity;

public class ComponentCollisionBody extends Component {

    private float width, height, posX, posY;
    private Rectangle rectangle;

    public ComponentCollisionBody(Entity parentEntity) {
        super(parentEntity);
        rectangle = new Rectangle();

    }

    public ComponentCollisionBody(Entity parentEntity, float width, float height){
        super(parentEntity);
        rectangle = new Rectangle();
        this.width = width;
        this.height = height;
        rectangle.setSize(width, height);

    }

    @Override
    public void update() {
        super.update();
        try{
            ComponentProperties componentProperties = (ComponentProperties) getParentEntity().findComponent(ComponentProperties.class);
            setPosX(componentProperties.getPosX());
            setPosY(componentProperties.getPosY());
            rectangle.setPosition(posX, posY);
        }catch (Exception e){

        }
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
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

}
