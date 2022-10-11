package com.levesteszta.towerdefend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
    private float x,y,width, height;
    private TileType tile;
    private Texture texture;

    public Tile(float x, float y, float width, float height, TileType tile){
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setTile(tile);
        this.setTexture(tile.TextureName);
    }

    public void draw(SpriteBatch sprite){
        sprite.draw(texture, x, y, height, width);
    };

    
    //Getter-Setter
    // X
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    // Y
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    // width
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    // height
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    // Texture
    public Texture getTexture() {
        return texture;
    }
    public void setTexture(String texture) {
        this.texture = new Texture(texture+".jpg");
    }
    // Tile
    public TileType getTile() {
        return tile;
    }
    public void setTile(TileType tile) {
        this.tile = tile;
    }
}