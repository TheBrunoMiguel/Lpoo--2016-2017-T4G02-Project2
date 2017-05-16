package com.lpoot4g02.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Bruno on 16-05-2017.
 */

public class Wall
{
    private static final int FLUCTUATION = 50;                 //It can move up and down between 0 and 130
    private static final int WALL_GAP = 128;                   //Gap that exists between two walls has to be at least 100
    private static final int LOWEST_OPENING = 45;              //Lowest y that the wall can go

    private Texture topWall, bottomWall;
    private Vector2 posTopWall, posBotWall;
    private Random rand;


    public Wall(float x)
    {
        topWall = new Texture("TopWall.png");
        bottomWall = new Texture("BottomWall.png");

        rand = new Random();
        posTopWall = new Vector2(x, rand.nextInt(FLUCTUATION) + WALL_GAP + LOWEST_OPENING);
        posBotWall = new Vector2(x, posTopWall.y - WALL_GAP - bottomWall.getHeight());
    }


    public Texture getTopWall()
    {
        return topWall;
    }


    public Texture getBottomWall()
    {
        return bottomWall;
    }


    public Vector2 getPosTopWall()
    {
        return posTopWall;
    }


    public Vector2 getPosBotWall()
    {
        return posBotWall;
    }
}
