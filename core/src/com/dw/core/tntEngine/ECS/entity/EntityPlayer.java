package com.dw.core.tntEngine.ECS.entity;

import com.dw.core.tntEngine.ECS.component.ComponentBodyParts;
import com.dw.core.tntEngine.ECS.component.ComponentCollisionBody;
import com.dw.core.tntEngine.ECS.component.ComponentSprites;
import com.dw.core.tntEngine.ECS.component.enums.SpriteType;
import com.dw.core.tntEngine.ECS.component.objects.BodyPart;
import com.dw.core.tntEngine.ECS.component.objects.Sprite;
import com.dw.core.tntEngine.ECS.controller.ControllerCollisionDetection;
import com.dw.core.tntEngine.ECS.controller.ControllerPlayerMovement;
import com.dw.core.tntEngine.ECS.system.RenderSystem;
import com.dw.core.tntEngine.ECS.controller.ControllerRenderDebug;

public class EntityPlayer extends Entity {

    public EntityPlayer(){
        super();
        RenderSystem.setCameraFollow(this);

        addComponent(new ComponentCollisionBody(this, 100, 100));
        addComponent(new ComponentBodyParts(this));
        addComponent(new ComponentSprites(this));
        addController(new ControllerPlayerMovement(this));
        addController(new ControllerCollisionDetection(this));
        addController(new ControllerRenderDebug(this));

        ComponentSprites componentSprites = (ComponentSprites) findComponent(ComponentSprites.class);
        componentSprites.addTextureAtlas("entity-human", "assets/graphics/entity-human.atlas");
        componentSprites.addSprite("head", new Sprite(SpriteType.STATIC));
        componentSprites.getSprite("head").setCurrentTexture(componentSprites.getTextureFromTextureAtlas("entity-human", "head-front"));




        ComponentBodyParts componentBodyParts = (ComponentBodyParts) findComponent(ComponentBodyParts.class);
        componentBodyParts.addBodyPart(new BodyPart("head"));
        componentBodyParts.addBodyPart(new BodyPart("body"));
        componentBodyParts.addBodyPart(new BodyPart("arm-right"));
        componentBodyParts.addBodyPart(new BodyPart("arm-left"));
        componentBodyParts.addBodyPart(new BodyPart("foot-right"));
        componentBodyParts.addBodyPart(new BodyPart("foot-left"));

    }

}
