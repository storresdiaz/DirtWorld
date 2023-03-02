package com.dw.core.tntEngine.ECS.component;

import com.dw.core.tntEngine.ECS.entity.Entity;

public class Component {

    private Entity parentEntity;

    public Component(Entity parentEntity){
        this.parentEntity = parentEntity;
    }

    public void update(){}

    public Entity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(Entity parentEntity) {
        this.parentEntity = parentEntity;
    }
}
