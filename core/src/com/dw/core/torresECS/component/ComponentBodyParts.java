package com.dw.core.torresECS.component;

import com.badlogic.gdx.math.Rectangle;
import com.dw.core.torresECS.component.objects.BodyPart;
import com.dw.core.torresECS.entity.Entity;

import java.util.HashMap;


public class ComponentBodyParts extends Component {

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
