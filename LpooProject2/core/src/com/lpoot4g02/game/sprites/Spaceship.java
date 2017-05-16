package com.lpoot4g02.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Bruno on 16-05-2017.
 */

public class Spaceship
{
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 200;

    private Vector3 position;           //Vector3 holds a x, y and z axis, even though we only need x and y here.
    private Vector3 velocity;
    private Texture spaceship;

    private Rectangle bounds;


    public Spaceship(int x, int y)
    {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        spaceship = new Texture("Spaceship.png");

        bounds = new Rectangle(x, y, spaceship.getWidth(), spaceship.getHeight());
    }


    public void update(float dt)
    {
        if(position.y > 0)
        {
            velocity.add(0, GRAVITY, 0);            //We add gravity to the y factor.
        }

        velocity.scl(dt);                       //Multiplies everything by a delta time
        position.add(MOVEMENT * dt, velocity.y, 0);

        if(position.y < 0)
        {
            position.y = 0;
        }

        velocity.scl(1/dt);                     //Reverse what we did previously.


        //Everytime our spaceship moves we need to update it's bounds:

        bounds.setPosition(position.x, position.y);
    }


    public Vector3 getPosition()
    {
        return position;
    }


    public Texture getTexture()
    {
        return spaceship;
    }


    public void rise()
    {
        velocity.y = 250;
    }


    public Rectangle getBounds() { return bounds; }
}
