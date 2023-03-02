package com.dw.core.torresECS.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.dw.core.torresECS.component.objects.Sprite;
import com.dw.core.torresECS.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ComponentSprites extends Component {

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
