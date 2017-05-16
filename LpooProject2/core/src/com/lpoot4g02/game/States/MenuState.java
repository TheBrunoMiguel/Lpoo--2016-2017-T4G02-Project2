package com.lpoot4g02.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoot4g02.game.RpgGame;

/**
 * Created by Bruno on 03-05-2017.
 */

public class MenuState extends State
{

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        background = new Texture("Spaceship Background.png");
        playBtn = new Texture("Play Button.png");
    }

    @Override
    public void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)          //Sprite Batch its like a box: first you open it, put what you want in there, then you close it
    {
        sb.begin();
        sb.draw(background, 0, 0, RpgGame.WIDTH, RpgGame.HEIGHT);
        sb.draw(playBtn, (RpgGame.WIDTH/2) - (playBtn.getWidth()/2), (RpgGame.HEIGHT/2) - (playBtn.getWidth()/2));
        sb.end();
    }

    @Override
    public void dispose()
    {
        background.dispose();
        playBtn.dispose();
    }
}
