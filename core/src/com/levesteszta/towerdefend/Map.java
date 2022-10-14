package com.levesteszta.towerdefend;

import java.lang.Thread.State;
import java.util.*;

public class Map {
    int[][] map2D = null;
    boolean wasSetup = false;
    int widthRange = -1;
    int heightRange = -1;
    Random rand = new Random();

    void setup(int get_YRange, int get_XRange){
        try{
            widthRange = (int)Math.floor(get_XRange/32.0);      //Hány 32x32 es kockát tudunk az X (szélesség) számegyenesre rakni 
            heightRange = (int)Math.floor(get_YRange/32.0);     //Hány 32x32 es kockát tudunk az Y (magasság) száemgyenesre rakni 
            
            map2D = new int[heightRange][widthRange];
            for(int i = 0; i < map2D.length;i++)
                for(int y = 0; y < map2D[i].length;y++)
                    map2D[i][y] = 0;
            wasSetup = true;
        }catch(Exception e){wasSetup=false; return;}
    }
    public int[][] generate(int get_YRange, int get_XRange){
        setup(get_YRange, get_XRange);
        if(!wasSetup)
            return null;
        int startIndex  = (int)(rand.nextInt(((heightRange-1) - 0) + 1) + 0);   //Hanyas sorindexből indul -> rand.nextInt((max - min) + 1) + min;
        int endIndex    = (int)(rand.nextInt(((heightRange-1) - 0) + 1) + 0);   //Hanyas sorindexre végződik
        System.out.println("Start: "+map2D.length+" : "+startIndex+" , End: "+map2D[0].length+" : "+endIndex);
        
        int w = heightRange;                        //szélesség hátra                       --(Hányszor mehetek jobbra)
        int h = endIndex - startIndex;              //magasság (+ lefele, - felfele) hátra  --(Hányszor mehetek fel/le)
        int minPath = (int)(w + Math.abs(h))-1;     //Mennyi lesz a minimális út -> adott út adott számú jobbra és fel/le daraból áll, ennek elosztása mindegy ilyenkor

        Stack<String> utvonal = new Stack<String>();
        map2D[startIndex][0] = 1;
        map2D[endIndex][map2D[0].length-1] = 1;

        while(minPath > 0){
            int tmp = (rand.nextInt((1 - 0) + 1) + 0);
            if(tmp == 0){
                if(w > 0){
                    tmp = (rand.nextInt((w - 0) + 1) + 0);
                    utvonal.add(tmp+"R");
                    w-=tmp;
                    minPath-= tmp;
                }
            }
            if(tmp == 1){
                if(h != 0){
                    if(h > 0){
                        tmp = (rand.nextInt((h - 0) + 1) + 0);
                        utvonal.add(tmp+"L");
                        h-= tmp;
                    }
                    else{
                        tmp = (rand.nextInt(( Math.abs(h) - 0) + 1) + 0) * -1;
                        utvonal.add(tmp+"U");
                        h+= tmp;
                    }
                    minPath -= (Math.abs(tmp));
                }
            }
        };

        

        while(utvonal.size() != 0){
            String tmp = utvonal.pop();
            System.out.println(tmp);
        }
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
