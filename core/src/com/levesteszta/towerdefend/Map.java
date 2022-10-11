package com.levesteszta.towerdefend;

import java.util.*;

public class Map {
    int[][] map2D = null;
    boolean wasSetup = false;
    int widthRange = -1;
    int heightRange = -1;
    Random rand = new Random();
    void setup(int getWidth, int getHeight){
        try{
            widthRange = (int)Math.floor(getWidth/32.0);
            heightRange = (int)Math.floor(getHeight/32.0);
            map2D = new int[widthRange][heightRange];
            for(int i = 0; i < widthRange;i++)
                for(int y = 0; y < heightRange;y++)
                    map2D[i][y] = 0;
            wasSetup = true;
            
            // Teszt
            //this.writeOut();
        }catch(Exception e){ wasSetup=false; return;}
    }
    public int[][] generate(int getWidth, int getHeight){
        this.setup(getWidth, getHeight);
        if(!wasSetup)
            return null;
        int startIndex = (int)(rand.nextInt((heightRange - 0) + 1) + 0);
        int endIndex =  (int)(rand.nextInt(( heightRange - 0) + 1) + 0);
        System.out.println("Start: 0 : "+startIndex+" , End: 9 : "+endIndex);
        int w = heightRange;                        //szélesség menyniség               --(Hányszor mehetek jobbra)
        int h = endIndex - startIndex;              //magasság (+ lefele, - felfele)    --(Hányszor mehetek fel/le)
        int minPath = (int)(w + Math.abs(h))-1;     //Mennyi lesz a maxút
        int currentW = 0;
        int currentH = startIndex;
        int merre = -1;
        map2D[currentH][currentW] = 2;
        while(minPath != 0){
            if( h != 0 && w != 0)
                merre = (int)(rand.nextInt((1 - 0) + 1) + 0);
            else if( Math.abs(h) > 0 && w == 0)
                merre = 0;
            else if( w > 0 && h == 0)
                merre = 1;
            
            if(merre == 0){     //  Fell-Le
                if(currentH != endIndex){
                    currentH += h  > 0 ? 1 : -1;
                    h += h > 0 ? -1 : 1;
                    minPath--;
                }
            }else{              //  Jobbra
                if(currentW != widthRange-1){
                    currentW += 1;
                    w--;
                    minPath--;
                }
            }
            map2D[currentH][currentW] = 2;
        }
        map2D[currentH][currentW] = 2;
        writeOut();
        return map2D;
    }

    int[][] getMap(){
        return map2D;
    }

    void writeOut(){
        for(int[] x : map2D){
            for(int y : x)
                System.out.print(y+" ");
            System.out.print("\r\n");
        }
    }
}
