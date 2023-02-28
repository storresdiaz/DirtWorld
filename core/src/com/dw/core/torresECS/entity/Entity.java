package com.dw.core.torresECS.entity;

import com.dw.core.torresECS.component.Component;
import com.dw.core.torresECS.component.ComponentProperties;
import com.dw.core.torresECS.controller.Controller;
import com.dw.core.torresECS.system.EntitySystem;

import java.util.ArrayList;

public class Entity {

    private ArrayList<Component> components;
    private ArrayList<Controller> controllers;

    private double entityID;

    private Entity targetEntity;

    public Entity(){
        components = new ArrayList<>();
        controllers = new ArrayList<>();
        addComponent(new ComponentProperties(this));
    }

    public void update() {

        for(Component component: components){
            component.update();
        }

        for(Controller controller: controllers){
            controller.update();
        }


    }

    /**
     * @return Returns a target entity which can be used for multi-entity interactions for example as collision detection.
     */
    public Entity getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(Entity targetEntity) {
        this.targetEntity = targetEntity;
    }

    public void addController(Controller controllerToAppend){
        boolean okToAppend = true;

        for(Controller controller: controllers){
            if(controller.getClass().isInstance(controllerToAppend)){
                okToAppend = false;
                break;
            }
        }
        if(okToAppend){
            controllers.add(controllerToAppend);
        }

    }

    public void removeController(Class<? extends Controller> controllerType){
        for(Controller controller: controllers){
            if(controllerType.isInstance(controller)){
                components.remove(controller);
                break;
            }
        }
    }

    public void addComponent(Component componentToAppend){
        boolean okToAppend = true;

        for(Component component: components){
            if(component.getClass().isInstance(componentToAppend)){
                okToAppend = false;
                break;
            }
        }

        if(okToAppend) {
            components.add(componentToAppend);
        }

    }

    public void removeComponent(Class<? extends Component> componentType){

        for(Component component: components){
            if(componentType.isInstance(component)){
                components.remove(component);
                break;
            }
        }

    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Controller> getControllers() {
        return controllers;
    }

    public void setControllers(ArrayList<Controller> controllers) {
        this.controllers = controllers;
    }

    public double getEntityID() {
        return entityID;
    }

    public void setEntityID(double entityID) {
        this.entityID = entityID;
    }

    /**
     * Finds and returns a component from this entity.
     * @param componentType The class of the component you want to find.
     * @return returns a component if found or null.
     */
    public Component findComponent(Class<? extends Component> componentType){
        for(Component component: components){
            if(componentType.isInstance(component)){
                return component;
            }
        }
        return null;
    }

    public void destroyEntity(){
        EntitySystem.destroyEntity(this);
    }

}
