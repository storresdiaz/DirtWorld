package com.dw.core.tntEngine.ECS.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.dw.core.tntEngine.ECS.entity.Entity;
import com.dw.core.tntEngine.ECS.component.objects.CodedAnimation;
import com.dw.core.tntEngine.ECS.component.objects.Sprite;

import java.util.HashMap;

public class ComponentSprites extends Component {

    public HashMap<String, Sprite> sprites;

    private HashMap<String, TextureAtlas> atlases;

    private HashMap<String, Texture> textures;

    private HashMap<String, Animation> animations;

    private HashMap<String, CodedAnimation> codedAnimations;

    public ComponentSprites(Entity parentEntity) {
        super(parentEntity);
        sprites = new HashMap<>();
        animations = new HashMap<>();
        codedAnimations = new HashMap<>();
        atlases = new HashMap<>();
        textures = new HashMap<>();
    }

    @Override
    public void update() {
        super.update();
        for(CodedAnimation codedAnimation: codedAnimations.values()){
            codedAnimation.update();
        }
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

    public TextureAtlas getTextureAtlas(String atlasName){
        if(atlases.containsKey(atlasName)){
            return atlases.get(atlasName);
        }
        return null;
    }

    /**
     * Get a texture from a texture atlas according to the supplied region in the atlas.
     * @param atlasName The name of the atlas in this component
     * @param regionName The name of the region that holds the texture
     * @return Returns a texture or null.
     */
    public Texture getTextureFromTextureAtlas(String atlasName, String regionName){
        try{
            if(atlases.containsKey(atlasName)){
                TextureAtlas atlas = atlases.get(atlasName);
                return atlas.findRegion(regionName).getTexture();
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
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
        if (textures.containsKey(textureName)) {
            textures.remove(textureName);
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
