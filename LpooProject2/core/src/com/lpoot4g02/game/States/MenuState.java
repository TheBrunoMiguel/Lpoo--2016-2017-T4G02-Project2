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

        cam.setToOrtho(false, RpgGame.WIDTH/2, RpgGame.HEIGHT/2);

        background = new Texture("Spaceship Background.png");
        playBtn = new Texture("Play Button.png");
    }

    @Override
    public void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm));
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
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth()/2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose()
    {
        background.dispose();
        playBtn.dispose();

        System.out.println("Menu State Disposed");
    }
}
