package com.lpoot4g02.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lpoot4g02.game.RpgGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = RpgGame.WIDTH;
		config.height = RpgGame.HEIGHT;
		config.title = RpgGame.TITLE;

		new LwjglApplication(new RpgGame(), config);
	}
}
