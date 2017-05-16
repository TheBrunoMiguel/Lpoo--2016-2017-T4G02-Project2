package com.lpoot4g02.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoot4g02.game.RpgGame;
import com.lpoot4g02.game.sprites.Spaceship;
import com.lpoot4g02.game.sprites.Wall;

/**
 * Created by Bruno on 15-05-2017.
 */

public class PlayState extends State
{
    private Spaceship spaceship;
    private Texture bg;
    private Wall wall;


    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        spaceship = new Spaceship(50, 170);
        cam.setToOrtho(false, RpgGame.WIDTH/2, RpgGame.HEIGHT/2);
        bg = new Texture("Spaceship Background.png");
        wall = new Wall(100);
    }


    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())             //We can later change this to Touched (?) to change it to a spaceship-like game
        {
            spaceship.rise();
        }
    }


    @Override
    public void update(float dt)
    {
        handleInput();
        spaceship.update(dt);
    }


    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, (cam.position.x) - (cam.viewportWidth/2), 0);
        sb.draw(spaceship.getTexture(), spaceship.getPosition().x, spaceship.getPosition().y);
        sb.draw(wall.getTopWall(), wall.getPosTopWall().x, wall.getPosTopWall().y);
        sb.draw(wall.getBottomWall(), wall.getPosBotWall().x, wall.getPosBotWall().y);
        sb.end();
    }


    @Override
    public void dispose()
    {

    }

}
