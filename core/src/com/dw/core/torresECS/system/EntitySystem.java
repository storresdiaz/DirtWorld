package com.dw.core.torresECS.system;

import com.dw.core.torresECS.component.Component;
import com.dw.core.torresECS.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class EntitySystem {

    private static HashMap<Double, Entity> entities = new HashMap<>();

    private static double currentEntityID;


    public static void update(){
        for(Entity entity: entities.values()){
            for(Entity targetEntity: entities.values()) {
                entity.update();
                entity.setTargetEntity(targetEntity);
            }
        }

    }

    private static void addEntity(Entity entityToAdd){
        boolean okToAdd = true;
        for(Entity entity: entities.values()){
            if(entity.getEntityID() == entityToAdd.getEntityID()){
                okToAdd = false;
            }
        }

        if(okToAdd){
            entities.put(entityToAdd.getEntityID(), entityToAdd);
        }

    }

    private static void removeEntity(double entityID){
        try{
            entities.remove(entityID);
        }catch (Exception e){

        }
    }

    public static void registerEntity(Entity entity){
        currentEntityID += 0.01;
        entity.setEntityID(currentEntityID);
        addEntity(entity);

    }

    public static void destroyEntity(Entity entity){
        removeEntity(entity.getEntityID());
    }



}
