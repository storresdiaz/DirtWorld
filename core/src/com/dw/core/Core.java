package com.dw.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dw.core.screens.ScreenGame;

public class Core extends Game {

	public Screen screenGame;

	@Override
	public void create () {
		screenGame = new ScreenGame(this);
		this.setScreen(screenGame);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		super.render();

	}
	
	@Override
	public void dispose () {

	}
}