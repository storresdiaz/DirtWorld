package com.dw.core.torresECS.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

public class ComponentSprite {

    private SpriteType spriteType;
    private HashMap<String, Animation> animations;
    private HashMap<String, TextureAtlas> atlases;

    private HashMap<String, Texture> textures;
    private Animation currentAnimation, defaultAnimation;

    private Texture defaultTexture;

    public enum SpriteType{
        STATIC, ANIMATED, CODED
    }

    public ComponentSprite(SpriteType spriteType){
        this.spriteType = spriteType;
        animations = new HashMap<>();
        atlases = new HashMap<>();
        textures = new HashMap<>();
    }

    public Texture findTexture(String textureName){
        return textures.get(textureName);
    }

    public void addTexture(String textureName, String filePath){
        try{
            textures.put(textureName, new Texture(Gdx.files.internal(filePath)));
        }catch (Exception e){

        }

    }

    public void removeTexture(String textureName){
        textures.remove(textureName);
    }

    public void addTextureAtlas(String atlasName, String filePath){
        try{
            TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(filePath));
            atlases.put(atlasName, atlas);
        }catch (Exception e){

        }
    }

    public void addAnimation(String animationName, Animation animationToAdd){
        boolean okToAdd = true;
        if(animations.containsKey(animationName)){
            okToAdd = false;
        }
        if(okToAdd){
            animations.put(animationName, animationToAdd);
        }
    }

    public void addAnimation(String animationName, String atlasName, String atlasRegion, Animation.PlayMode animationPlayMode){
        boolean okToAdd = true;
        try {
            if(animations.containsKey(animationName)){
                okToAdd = false;
            }
            if(okToAdd) {
                Array<TextureAtlas.AtlasRegion> regions = findAtlas(atlasName).findRegions(atlasRegion);
                animations.put(animationName, new Animation(0.033f, regions, animationPlayMode));
            }

        }catch(Exception e){

        }
    }

    public void removeAnimation(String animationName){
        animations.remove(animationName);
    }

    public Animation findAnimation(String animationName){
        try{
            return animations.get(animationName);
        }catch(Exception e){

        }
        return null;
    }

    public void setCurrentAnimation(String animationName){
        currentAnimation = findAnimation(animationName);
    }

    public void setDefaultAnimation(String animationName){
        defaultAnimation = findAnimation(animationName);
    }

    public Animation getDefaultAnimation(){
        return defaultAnimation;
    }

    public Animation getCurrentAnimation(){
        return currentAnimation;
    }

    public void setDefaultTexture(String filePath){
        defaultTexture = new Texture(Gdx.files.internal(filePath));
    }

    public Texture getDefaultTexture(){
        return defaultTexture;
    }

    public TextureAtlas findAtlas(String atlasName){
        try{
            return atlases.get(atlasName);
        }catch (Exception e){
            return null;
        }
    }

    public SpriteType getSpriteType() {
        return spriteType;
    }

    public void setSpriteType(SpriteType spriteType) {
        this.spriteType = spriteType;
    }

}
