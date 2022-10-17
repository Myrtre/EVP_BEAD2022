package com.levesteszta.towerdefend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.levesteszta.towerdefend.helper.TileType;

public class Tile {
    private float x,y,size;
    private TileType tile;
    private Texture texture;

    public Tile(float x, float y, float size, TileType tile){
        this.setX(x);
        this.setY(y);
        this.setSize(size);
        this.setTile(tile);
        this.setTexture(tile.TextureName);
    }

    public void draw(SpriteBatch sprite){
        sprite.draw(this.texture, x, y, size, size);
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
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
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