package com.dw.core.torresECS.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.dw.core.torresECS.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ComponentSprites extends Component {

    public enum SpriteType {
        STATIC, ANIMATED, CODED
    }

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

    public class CodedAnimation{

        private float currentPosX, currentPosY;
        private int animationSpeed = 1000, totalFrames = 0, currentFrame = 0;
        private long startTime;
        private boolean isNextFrameReady = true, isLooping = true;
        private LinkedHashMap<String, Vector2> steps;

        public CodedAnimation(){
            steps = new LinkedHashMap<>();
        }

        public void update(){

            if(isNextFrameReady){
                startTime = TimeUtils.millis();
                isNextFrameReady = false;
                if(isLooping && currentFrame > totalFrames){
                    currentFrame = 0;
                }
            }

            if(TimeUtils.timeSinceMillis(startTime) >= animationSpeed && currentFrame <= totalFrames){
                isNextFrameReady = true;
            }

        }

        public void addStep(String stepName, Vector2 position){
            if(!steps.containsKey(stepName)){
                steps.put(stepName, position);
            }
            totalFrames = steps.size();
        }

        public void removeStep(String stepName){
            if(steps.containsKey(stepName)){
                steps.remove(stepName);
            }
            totalFrames = steps.size();
        }

        private Object getElementByIndex(LinkedHashMap map, int index){
            return map.get((map.keySet().toArray())[index]);
        }

        private void setAnimationSpeed(int speedInMilliseconds){
            this.animationSpeed = speedInMilliseconds;
        }

        public boolean isLooping() {
            return isLooping;
        }

        public void setLooping(boolean looping) {
            isLooping = looping;
        }

    }

    public HashMap<String, Sprite> sprites;

    public ComponentSprites(Entity parentEntity) {
        super(parentEntity);
        sprites = new HashMap<>();
    }

    @Override
    public void update() {
        super.update();
        for(Sprite sprite: sprites.values()){
            sprite.update();
        }
    }

    /**
     *@param name The name of the sprite in this component
     * @return returns a sprite or null
     */
    public Sprite getSprite(String name){
        if(sprites.containsKey(name)){
            return sprites.get(name);
        }
        return null;
    }

    /**
     * Adds a sprite to this component if the name does not already exist.
     * @param name The name of the sprite for this component.
     * @param sprite A new sprite to be added.
     */
    public void addSprite(String name, Sprite sprite){
        if(!sprites.containsKey(name)){
            sprites.put(name, sprite);
        }
    }

    /**
     * Removes a sprite from this component
     * @param name The name of the sprite to be removed.
     */
    public void removeSprite(String name){
        if(sprites.containsKey(name)){
            sprites.remove(name);
        }
    }





}
