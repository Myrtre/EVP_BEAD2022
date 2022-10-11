package com.levesteszta.towerdefend;

public enum TileType {
    
    Fold("proba", false), Ut("proba2",true);
    
    String TextureName;
    boolean isClickable;

    TileType(String TextureName, boolean isClickable ){
        this.TextureName = TextureName;
        this.isClickable = isClickable;
    }
}
