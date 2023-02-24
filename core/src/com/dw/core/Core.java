package com.dw.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dw.core.screens.ScreenGame;
import com.dw.core.screens.ScreenMainMenu;

public class Core extends Game {

	public Screen screenGame;
	public Screen screenMainMenu;

	@Override
	public void create () {
		screenGame = new ScreenGame(this);
		screenMainMenu = new ScreenMainMenu(this);
		this.setScreen(screenGame);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		super.render();

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}

	}
	
	@Override
	public void dispose () {

	}

}
