package com.lpoot4g02.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Bruno on 03-05-2017.
 */

public abstract class State
{
    protected OrthographicCamera cam;
    protected Vector3 mouse;                   //Basically a 3d referencial, dunno if it'll be needed
    protected GameStateManager gsm;            //A game can have several states, like paused and stuff (I think)

    protected State(GameStateManager gsm)
    {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);          //dt (delta) is the time until the next frame is updated
    public abstract void render(SpriteBatch sb);    //sb is a container that has everything that's gonna be rendered in the next frame
}
