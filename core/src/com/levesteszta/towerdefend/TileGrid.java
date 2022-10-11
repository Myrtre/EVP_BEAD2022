package com.levesteszta.towerdefend;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileGrid{
    float start_X, start_Y, end_X,end_Y;
    float WINDOW_HEIGHT, WINDOW_WIDTH;
    Tile[][] tiles;

    Tile[][] map_grid2;
    int[][] map;
    public TileGrid(float start_X, float start_Y, float end_X, float end_Y){
        this.start_X = start_X;
        this.start_Y = start_Y;
        this.end_X = end_X;
        this.end_Y = end_Y;
    }

    public void setWindow(float width, float height){
        this.WINDOW_HEIGHT = height;
        this.WINDOW_WIDTH = width;
    }

    public void generate(){
        setWindow(1000, 720);
        map_grid2 = new Tile[(int)WINDOW_HEIGHT][(int)WINDOW_WIDTH];
		map = new Map().generate((int)WINDOW_WIDTH, (int)WINDOW_HEIGHT);

        buildUp();
    }

    private void buildUp(){
        for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(map[i][j] == 0)
					map_grid2[i][j] = new Tile(i*32, j*32, 32, 32,TileType.Fold);
				if(map[i][j] == 2)
					map_grid2[i][j] = new Tile(i*32, j*32, 32, 32,TileType.Ut);
			}
		};
    }

    public void draw(SpriteBatch batch){
        for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map_grid2[i][j].draw(batch);
			}
		};
    }

    public Tile getTileDataes(float x, float y) {
        int xx = (int)(x / 32.0);
        int yy = (int)(x / 32.0);
        return tiles[xx][yy];
    }
}