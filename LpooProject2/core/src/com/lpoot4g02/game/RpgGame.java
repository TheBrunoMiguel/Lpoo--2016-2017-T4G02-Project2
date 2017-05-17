package com.lpoot4g02.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lpoot4g02.game.States.GameStateManager;
import com.lpoot4g02.game.States.MenuState;

public class RpgGame extends ApplicationAdapter {

    public static final int  WIDTH = 800;
    public static final int HEIGHT = 480;

    public static final String TITLE = "An Rpg Game";

	private GameStateManager gsm;
	private SpriteBatch batch;       //There should be only one in the game, because it is a heavy file. You should pass it around

	private Music music;
	
	@Override
	public void create ()
	{
		gsm = new GameStateManager();
		batch = new SpriteBatch();

		music = Gdx.audio.newMusic(Gdx.files.internal("bg music.mp3"));
		music.setLooping(true);
		music.setVolume(0.04f);
		music.play();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose ()
	{
		super.dispose();

		music.dispose();
	}
}
