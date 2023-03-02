package com.dw.core.torresECS.component.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.LinkedHashMap;

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
            setCurrentPosX(getElementByIndex(steps, currentFrame).x);
            setCurrentPosY(getElementByIndex(steps, currentFrame).y);
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

    private Vector2 getElementByIndex(LinkedHashMap<String, Vector2> map, int index){
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

    public float getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(float currentPosX) {
        this.currentPosX = currentPosX;
    }

    public float getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(float currentPosY) {
        this.currentPosY = currentPosY;
    }
}
