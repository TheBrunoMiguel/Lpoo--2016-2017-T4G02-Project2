package com.lpoot4g02.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lpoot4g02.game.RpgGame;
import com.lpoot4g02.game.sprites.Spaceship;
import com.lpoot4g02.game.sprites.Wall;

/**
 * Created by Bruno on 15-05-2017.
 */

public class PlayState extends State
{
    private static final int WALL_SPACING = 125;          //The space between the start of one Wall and the start of the next Wall, on the x axis.
    private static final int WALL_COUNT  = 4;             //How many walls the game has at any given time

    private Spaceship spaceship;
    private Texture bg;

    private Array<Wall> walls;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        spaceship = new Spaceship(50, 170);
        cam.setToOrtho(false, RpgGame.WIDTH/2, RpgGame.HEIGHT/2);
        bg = new Texture("Spaceship Background.png");

        walls = new Array<Wall>();

        for(int i = 1; i <= WALL_COUNT; i++)
        {
            walls.add(new Wall(i * (WALL_SPACING + Wall.WALL_WIDTH)));
        }
    }


    @Override
    protected void handleInput()
    {
        if(Gdx.input.isTouched())             //We can later change this to Touched (?) to change it to a spaceship-like game
        {
            spaceship.rise();
        }
    }


    @Override
    public void update(float dt)
    {
        handleInput();
        spaceship.update(dt);

        cam.position.x = spaceship.getPosition().x + 80;            //80 so we can see a little bit more in front of the spaceship

        for(Wall wall : walls)
        {
            //If the wall is off the left side off the screen
            if((cam.position.x - (cam.viewportWidth/2)) > (wall.getPosTopWall().x + wall.getTopWall().getWidth()))
            {
                wall.reposition(wall.getPosTopWall().x + ((Wall.WALL_WIDTH + WALL_SPACING) * WALL_COUNT));
            }

            //Since we have very little walls in the game, we can check if any of them touches the spaceship:
            if(wall.collides(spaceship.getBounds()))
            {
                gsm.set(new PlayState(gsm));
            }

        }

        cam.update();
    }


    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, (cam.position.x) - (cam.viewportWidth/2), 0);
        sb.draw(spaceship.getTexture(), spaceship.getPosition().x, spaceship.getPosition().y);

        for(Wall wall : walls)
        {
            sb.draw(wall.getTopWall(), wall.getPosTopWall().x, wall.getPosTopWall().y);
            sb.draw(wall.getBottomWall(), wall.getPosBotWall().x, wall.getPosBotWall().y);
        }

        sb.end();
    }


    @Override
    public void dispose()
    {

    }

}
