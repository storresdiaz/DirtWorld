package com.dw.core.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dw.core.Core;
import com.dw.core.torresECS.entity.EntityDebugBox;
import com.dw.core.torresECS.entity.EntityPlayer;
import com.dw.core.torresECS.entity.Entity;
import com.dw.core.torresECS.system.EntitySystem;
import com.dw.core.torresECS.system.RenderSystem;

public class ScreenGame implements Screen {

    public Core core;
    public ScreenGame(Core core){
        this.core = core;
    }

    @Override
    public void show() {

        EntitySystem.registerEntity(new EntityPlayer());
        EntitySystem.registerEntity(new EntityDebugBox());
        RenderSystem.initialize();

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        EntitySystem.update();
        RenderSystem.update();

    }

    @Override
    public void resize(int width, int height) {
        RenderSystem.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
