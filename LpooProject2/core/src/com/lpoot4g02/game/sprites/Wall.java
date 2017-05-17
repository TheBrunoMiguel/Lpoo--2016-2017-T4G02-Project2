package com.lpoot4g02.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Bruno on 16-05-2017.
 */

public class Wall
{
    public static final int WALL_WIDTH = 26;

    private static final int FLUCTUATION = 50;                 //It can move up and down between 0 and 50
    private static final int WALL_GAP = 128;                   //Gap that exists between two walls has to be at least 128
    private static final int LOWEST_OPENING = 45;              //Lowest y that the wall can go

    private Texture topWall, bottomWall;
    private Vector2 posTopWall, posBotWall;
    private Random rand;

    private Rectangle boundsTop, boundsBot;             //invisible rectangles -> colision boxes


    public Wall(float x)
    {
        topWall = new Texture("TopWall.png");
        bottomWall = new Texture("BottomWall.png");

        rand = new Random();
        posTopWall = new Vector2(x, rand.nextInt(FLUCTUATION) + WALL_GAP + LOWEST_OPENING);
        posBotWall = new Vector2(x, posTopWall.y - WALL_GAP - bottomWall.getHeight());

        boundsTop = new Rectangle(posTopWall.x, posTopWall.y, topWall.getWidth(), topWall.getHeight());
        boundsBot = new Rectangle(posBotWall.x, posBotWall.y, bottomWall.getWidth(), bottomWall.getHeight());
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


    public void reposition(float x)
    {
        posTopWall.set(x, rand.nextInt(FLUCTUATION) + WALL_GAP + LOWEST_OPENING);
        posBotWall.set(x, posTopWall.y - WALL_GAP - bottomWall.getHeight());

        //reposition the invisible rectangles (collision boxes)

        boundsTop.setPosition(posTopWall.x, posTopWall.y);
        boundsBot.setPosition(posBotWall.x, posBotWall.y);
    }


    public boolean collides(Rectangle player)
    {
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }


    public void dispose()
    {
        topWall.dispose();
        bottomWall.dispose();
    }
}
