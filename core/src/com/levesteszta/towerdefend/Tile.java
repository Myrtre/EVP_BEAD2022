package com.levesteszta.towerdefend;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
    float x,y,width, height;
    Texture texture;
    public Tile(float x, float y, float width, float height, Texture texture){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
    }

    public void Draw(SpriteBatch sprite){
        sprite.draw(texture, x, y, height, width);
    }
}