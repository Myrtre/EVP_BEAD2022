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
		room = new TileGrid(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
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

		batch.begin();	
		room.draw(batch);	
		// Input cheker
		if((Gdx.input.getX() > 0f && Gdx.input.getX() < 32f ) && ( Gdx.input.getY() > 0f && Gdx.input.getY() < 32f ) )
			if(Gdx.input.isTouched())
				System.out.println("Ez emgnyomható? :"+room.getTileDataes(Gdx.input.getX(),Gdx.input.getY()));

		System.out.println(Gdx.input.getX() + " : "+ Gdx.input.getY());

		batch.end();
	}
}
