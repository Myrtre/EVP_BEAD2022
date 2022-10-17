package com.levesteszta.towerdefend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.levesteszta.towerdefend.helper.TileType;

public class TowerDefend extends ApplicationAdapter {
	float WINDOW_WIDTH = 1000f;
	float WINDOW_HEIGHT = 720f;

	SpriteBatch batch;
	ShapeRenderer render;
	TileGrid room; 

	@Override
	public void create () {
		batch = new SpriteBatch();
		render = new ShapeRenderer();
		room = new TileGrid(32*2, 32*6, WINDOW_WIDTH-(32*2), WINDOW_HEIGHT-(32*1));
		room.generate();
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
		render.begin(ShapeType.Line);
		for(int i = 0; i < WINDOW_WIDTH/32;i++){
			for(int j = 0; j < WINDOW_HEIGHT/32; j++){
				render.line(i*32, 0,i*32, j*32);
				render.line(0, j*32,i*32, j*32);
			}
		}
		render.end();
		batch.begin();
			//new Sprite(new Texture("proba.jpg"),32,32).draw(batch);
			room.draw(batch);
		batch.end();
	}
}
