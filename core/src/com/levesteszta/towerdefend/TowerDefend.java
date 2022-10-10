package com.levesteszta.towerdefend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TowerDefend extends ApplicationAdapter {
	float WINDOW_WIDTH = 720f;	//Gdx.graphics.getWidth();
	float WINDOW_HEIGHT = 720f;	//Gdx.graphics.getHeight();

	SpriteBatch batch;
	Texture img, img2;
	Sprite[][] map_grid;
	int[][] map;
	Map tmp = new Map();
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("proba.jpg");
		img2 = new Texture("proba2.png");
		map_grid = new Sprite[(int)WINDOW_HEIGHT][(int)WINDOW_WIDTH];
		tmp.generate((int)WINDOW_WIDTH, (int)WINDOW_HEIGHT);
		map = tmp.getMap();
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

		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(map[i][j] == 0)
					map_grid[i][j] = new Sprite(img);
				if(map[i][j] == 2)
					map_grid[i][j] = new Sprite(img2);
				map_grid[i][j].setPosition(i*32, j*32);
			}
		}
		batch.begin();
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map_grid[i][j].draw(batch);
			}
		}
		batch.end();
	}
}
