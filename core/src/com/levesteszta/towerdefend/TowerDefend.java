package com.levesteszta.towerdefend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TowerDefend extends ApplicationAdapter {
	float WINDOW_WIDTH = 1000f;
	float WINDOW_HEIGHT = 720f;

	SpriteBatch batch;
	TileGrid room; 

	@Override
	public void create () {
		batch = new SpriteBatch();
		new Map().generate((32*10),(32*20));
	}	
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void render () {
		//render
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();	
		batch.end();
	}
}
