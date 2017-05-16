package com.lpoot4g02.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Bruno on 16-05-2017.
 */

public class Spaceship
{
    private static final int GRAVITY = -15;

    private Vector3 position;           //Vector3 holds a x, y and z axis, even though we only need x and y here.
    private Vector3 velocity;
    private Texture spaceship;

    public Spaceship(int x, int y)
    {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        spaceship = new Texture("Spaceship.png");
    }

    public void update(float dt)
    {
        if(position.y > 0)
        {
            velocity.add(0, GRAVITY, 0);            //We add gravity to the y factor.
        }

        velocity.scl(dt);                       //Multiplies everything by a delta time
        position.add(0, velocity.y, 0);

        if(position.y < 0)
        {
            position.y = 0;
        }

        velocity.scl(1/dt);                     //Reverse what we did previously.
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
}
