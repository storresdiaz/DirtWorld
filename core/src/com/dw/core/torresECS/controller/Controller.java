package com.dw.core.torresECS.controller;

import com.dw.core.torresECS.component.Component;
import com.dw.core.torresECS.entity.Entity;

import java.util.HashMap;

public class Controller {

    private Entity parentEntity;

    private HashMap<Double, Entity> targetEntities;

    public Controller(Entity parentEntity){
        setParentEntity(parentEntity);
        targetEntities = new HashMap<>();
    }

    public void update(){

    }

    public void addTargetEntity(Entity entityToAdd){
        boolean okToAdd = true;

        for(Entity entity: targetEntities.values()){
            if(entity.getEntityID() == entityToAdd.getEntityID()){
                okToAdd = false;
            }
        }

        if(okToAdd){
            targetEntities.put(entityToAdd.getEntityID(), entityToAdd);
        }

    }

    public void removeTargetEntity(double entityID){
        try{
            targetEntities.remove(entityID);
        }catch (Exception e){

        }
    }

    public void removeTargetEntity(Entity entity){
        try{
            targetEntities.remove(entity.getEntityID());
        }catch (Exception e){

        }
    }

    public Entity getParentEntity() {
        return parentEntity;
    }

    public HashMap<Double, Entity> getTargetEntities(){
        return targetEntities;
    }

    public Entity getTargetEntity(){
        return parentEntity.getTargetEntity();
    }

    public void setParentEntity(Entity parentEntity) {
        this.parentEntity = parentEntity;
    }


    public Component findComponent(Class<? extends Component> componentType){
            for(Component component: parentEntity.getComponents()){
                if(componentType.isInstance(component)){
                    return component;
                }
            }
            return null;
    }

    public Controller findController(Class<? extends Controller> controllerType){
        for(Controller controller: parentEntity.getControllers()){
            if(controllerType.isInstance(controller)){
                return controller;
            }
        }
        return null;
    }


}
