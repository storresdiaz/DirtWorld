package com.dw.core.torresECS.component.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.dw.core.torresECS.component.ComponentSprites;
import com.dw.core.torresECS.component.enums.SpriteType;

import java.util.HashMap;

public class Sprite {

    private SpriteType spriteType;
    private HashMap<String, Animation> animations;
    private HashMap<String, TextureAtlas> atlases;
    private HashMap<String, Texture> textures;
    private HashMap<String, CodedAnimation> codedAnimations;
    private Animation currentAnimation, defaultAnimation;

    private Texture currentTexture, defaultTexture;



    public Sprite(SpriteType spriteType) {
        this.spriteType = spriteType;
        animations = new HashMap<>();
        codedAnimations = new HashMap<>();
        atlases = new HashMap<>();
        textures = new HashMap<>();
    }

    public void update(){
        for(CodedAnimation codedAnimation: codedAnimations.values()){
            codedAnimation.update();
        }
    }

    public void addCodedAnimation(String animationName, CodedAnimation animation){
        if(!codedAnimations.containsKey(animationName)){
            codedAnimations.put(animationName, animation);
        }
    }

    public void removeCodedAnimation(String animationName){
        if(codedAnimations.containsKey(animationName)){
            removeAnimation(animationName);
        }
    }

    /**
     * Gets a texture from this sprite.
     * @param textureName the name of the texture in this sprite.
     * @return returns a Texture or null.
     */
    public Texture getTexture(String textureName) {
        if(textures.containsKey(textureName)){
            return textures.get(textureName);
        }
        return null;
    }

    /**
     * Adds a new texture to this sprite
     * @param textureName the name that will be used in this Sprite.
     * @param filePath the filepath to the texture asset.
     */
    public void addTexture(String textureName, String filePath) {

        try {
            textures.put(textureName, new Texture(Gdx.files.internal(filePath)));
        } catch (Exception e) {

        }

    }

    public void removeTexture(String textureName) {
        if(textures.containsKey(textureName)) {
            textures.remove(textureName);
        }
    }

    /**
     * Adds a new TextureAtlas to this sprite.
     * @param atlasName The name to use for the TextureAtlas in this sprite.
     * @param filePath The filepath to find the TextureAtlas.
     */
    public void addTextureAtlas(String atlasName, String filePath) {
        try {
            TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(filePath));
            atlases.put(atlasName, atlas);
        } catch (Exception e) {

        }
    }

    public void addAnimation(String animationName, Animation animationToAdd) {
        if(!animations.containsKey(animationName)){
            animations.put(animationName, animationToAdd);
        }
    }

    /**
     * Creates and adds a new animation to this sprite.
     * @param animationName The name of the animation that will be created.
     * @param atlasName The atlas in this sprite to pull regions from.
     * @param atlasRegion The region of the supplied atlas name to pull texture data from.
     * @param animationPlayMode The animations default playMode.
     */
    public void addAnimation(String animationName, String atlasName, String atlasRegion, Animation.PlayMode animationPlayMode) {
        boolean okToAdd = true;
        try {
            if (animations.containsKey(animationName)) {
                okToAdd = false;
            }
            if (okToAdd) {
                Array<TextureAtlas.AtlasRegion> regions = getAtlas(atlasName).findRegions(atlasRegion);
                animations.put(animationName, new Animation(0.033f, regions, animationPlayMode));
            }

        } catch (Exception e) {

        }
    }

    public void removeAnimation(String animationName) {
        if(animations.containsKey(animationName)) {
            animations.remove(animationName);
        }
    }

    /**
     * Returns an animation from this Sprite.
     * @param animationName The name of the animation in this sprite.
     * @return Returns an animation or null.
     */
    public Animation getAnimation(String animationName) {
        if(animations.containsKey(animationName)){
            return animations.get(animationName);
        }
        return null;
    }

    public void setCurrentAnimation(String animationName) {
        currentAnimation = getAnimation(animationName);
    }

    public void setDefaultAnimation(String animationName) {
        defaultAnimation = getAnimation(animationName);
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

    /**
     * Returns a texture atlas if it exists.
     * @param atlasName The name of the atlas in this sprite
     * @return Returns a TextureAtlas or null
     */
    public TextureAtlas getAtlas(String atlasName) {
        if(atlases.containsKey(atlasName)){
            return atlases.get(atlasName);
        }
        return null;
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
