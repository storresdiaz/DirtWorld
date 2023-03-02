package com.dw.core.tntEngine.ECS.controller;

import com.dw.core.tntEngine.ECS.entity.Entity;
import com.dw.core.tntEngine.ECS.component.Component;

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

    /**
     * Add the target entity to the controller's internal list of target entity.
     * As an example, you could have a collision detection controller that adds the target entity to
     * the target entities list if it is colliding, and remove it if it is not colliding.
     * Other controllers could then see if this controller has any target entity currently colliding.
     * @param entityToAdd
     */
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

    /**
     * Removes a target entity from targetEntities.
     * @param entityID the Entity ID to remove
     */
    public void removeTargetEntity(double entityID){
        try{
            targetEntities.remove(entityID);
        }catch (Exception e){

        }
    }

    /**
     * Removes the target entity from the target entities list.
     * @param entity the entity to remove.
     */
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

    /**
     * Returns a target entity for multi-entity interactions.
     * @return This controller's parent entity's target entity.
     */
    public Entity getTargetEntity(){
        return parentEntity.getTargetEntity();
    }

    public void setParentEntity(Entity parentEntity) {
        this.parentEntity = parentEntity;
    }

    /**
     * Finds a component in the parent entity.
     * @param componentType The Component's class to find in the parent entity.
     * @return eturns a component or null.
     */
    public Component findComponent(Class<? extends Component> componentType){
            for(Component component: parentEntity.getComponents()){
                if(componentType.isInstance(component)){
                    return component;
                }
            }
            return null;
    }

    /**
     * Finds a controller in the parent entity.
     * @param controllerType The Controller's class to find.
     * @return returns a controller or null.
     */
    public Controller findController(Class<? extends Controller> controllerType){
        for(Controller controller: parentEntity.getControllers()){
            if(controllerType.isInstance(controller)){
                return controller;
            }
        }
        return null;
    }


}
