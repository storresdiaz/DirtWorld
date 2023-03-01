package com.dw.core.torresECS.component;

import com.badlogic.gdx.math.Rectangle;
import com.dw.core.torresECS.entity.Entity;

import java.util.HashMap;


public class ComponentBodyParts extends Component {

    public class BodyPart{
        private float relativePosX, relativePosY, worldPosX, worldPosY;
        private String name;

        private Rectangle collisionRect;

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

        public void setName(String name) {
            this.name = name;
        }
    }

    private HashMap<String, BodyPart> bodyParts;

    public ComponentBodyParts(Entity parentEntity) {
        super(parentEntity);
        bodyParts = new HashMap<>();
    }

    @Override
    public void update() {
        super.update();
        for(BodyPart bodyPart: bodyParts.values()){
            bodyPart.setWorldPosX(getParentEntity().getProperties().getPosX() + bodyPart.getRelativePosX());
            bodyPart.setWorldPosY(getParentEntity().getProperties().getPosY() + bodyPart.getRelativePosY());
            bodyPart.update();
        }
    }

    public void addBodyPart(BodyPart bodyPart){
        if(!bodyParts.containsKey(bodyPart.getName())){
            bodyParts.put(bodyPart.getName(), bodyPart);
        }
    }

    public void removeBodyPart(String name){
        if(bodyParts.containsKey(name)){
            bodyParts.remove(name);
        }
    }

    public HashMap<String, BodyPart> getBodyParts(){
        return bodyParts;
    }

}
