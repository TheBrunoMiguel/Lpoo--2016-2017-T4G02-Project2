package com.lpoot4g02.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoot4g02.game.RpgGame;

/**
 * Created by Bruno on 15-05-2017.
 */

public class PlayState extends State
{

    private Texture spaceShip;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        spaceShip = new Texture("Spaceship.png");
        cam.setToOrtho(false, RpgGame.WIDTH/2, RpgGame.HEIGHT/2);
    }

    @Override
    protected void handleInput()
    {

    }

    @Override
    public void update(float dt)
    {

    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(spaceShip, 50, 50);
        sb.end();
    }

    @Override
    public void dispose()
    {

    }

}
