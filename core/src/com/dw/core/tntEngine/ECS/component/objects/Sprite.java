package com.dw.core.tntEngine.ECS.component.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.dw.core.tntEngine.ECS.component.ComponentSprites;
import com.dw.core.tntEngine.ECS.component.enums.SpriteType;

public class Sprite {

    private SpriteType spriteType;
    private Animation currentAnimation, defaultAnimation;
    private Texture currentTexture, defaultTexture;

    private ComponentSprites parent;


    public Sprite(SpriteType spriteType) {
        this.spriteType = spriteType;

    }

    public void update(){

    }

    public Texture getTexture(String textureName){
        return parent.getTexture(textureName);
    }

    public Animation getDefaultAnimation() {
        return defaultAnimation;
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    public void setDefaultTexture(String filePath) {
        defaultTexture = new Texture(Gdx.files.internal(filePath));
    }

    public Texture getDefaultTexture() {
        return defaultTexture;
    }

    public SpriteType getSpriteType() {
        return spriteType;
    }

    public void setSpriteType(SpriteType spriteType) {
        this.spriteType = spriteType;
    }

    public void setCurrentAnimation(Animation currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public void setDefaultAnimation(Animation defaultAnimation) {
        this.defaultAnimation = defaultAnimation;
    }

    public Texture getCurrentTexture() {
        return currentTexture;
    }

    public void setCurrentTexture(Texture currentTexture) {
        this.currentTexture = currentTexture;
    }

    public void setDefaultTexture(Texture defaultTexture) {
        this.defaultTexture = defaultTexture;
    }

}
