package com.lpoot4g02.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    private Animation spaceshipAnimation;
    private Texture texture;

    private Rectangle bounds;

    private Sound rocket;


    public Spaceship(int x, int y)
    {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        //spaceship = new Texture("Spaceship.png");
        texture = new Texture("Spaceship Animation.png");
        spaceshipAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);       //In this case its an animation with 3 frames and 0.5f time per frame

        bounds = new Rectangle(x, y, texture.getWidth()/3, texture.getHeight());

        rocket = Gdx.audio.newSound(Gdx.files.internal("rocket.wav"));
    }


    public void update(float dt)
    {
        spaceshipAnimation.update(dt);
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


    public TextureRegion getTexture()
    {
        return spaceshipAnimation.getFrame();
    }


    public void rise()
    {
        velocity.y = 250;
        rocket.play(0.2f);
    }


    public Rectangle getBounds() { return bounds; }


    public void dispose()
    {
        texture.dispose();
        rocket.dispose();
    }
}
