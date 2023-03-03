package com.dw.core.tntEngine.initialization;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;

public class Assets {

    public static AssetManager assetManager = new AssetManager();
    private static boolean isFinishedLoading = false;
    private static float progress = 0;

    private HashMap<String, String> atlases;
    public void initialize(){
        initializeAtlases();
    }

    private void initializeAtlases(){
        atlases = new HashMap<>();
        atlases.put("entity-human", "assets/graphics/entities/entity-human.atlas");

        for(String filePath : atlases.values()){
            assetManager.load(filePath, TextureAtlas.class);
        }

    }

    public void load(){
        if(assetManager.update()){
            setIsFinishedLoading(true);
        }
        setProgress(assetManager.getProgress());
    }

    public static AssetManager getAssetManager() {
        return assetManager;
    }

    public static boolean isIsFinishedLoading() {
        return isFinishedLoading;
    }

    private static void setIsFinishedLoading(boolean isFinishedLoading) {
        Assets.isFinishedLoading = isFinishedLoading;
    }

    public static float getProgress() {
        return progress;
    }

    public static void setProgress(float progress) {
        Assets.progress = progress;
    }
}
