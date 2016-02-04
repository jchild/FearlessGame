package com.fearless.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fearless.game.input.InputManager;
import com.fearless.game.player.Player;

public class FearlessGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font;
	private Texture img;
	private Pixmap pixmap;
	private InputManager inputManager;
	private Player player;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.GOLDENROD);
		
		//A pixmap is basically a raw image in memory as represented by pixels
		//We create one 256 wide, 128 height using 8 bytes for RGBA channels
		pixmap = new Pixmap(246, 128, Pixmap.Format.RGBA8888);
		
		//Make it Red?
		pixmap.setColor(Color.RED);
		pixmap.fill();
		
		//Draw two lines forming an X
		pixmap.setColor(Color.BLACK);
		pixmap.drawLine(0, 0, pixmap.getWidth() - 1, pixmap.getHeight() - 1);
		pixmap.drawLine(0, pixmap.getHeight() - 1, pixmap.getHeight() - 1, 0);
		
		//Draw circle?
		pixmap.setColor(Color.YELLOW);
		pixmap.drawCircle(pixmap.getWidth() / 2, pixmap.getHeight() / 2, pixmap.getHeight() / 2 - 1);
		
		img = new Texture(pixmap);
//		img = new Texture("badlogic.jpg");
		player = new Player();
		inputManager = new InputManager(player);
		Gdx.input.setInputProcessor(inputManager);
	}

	@Override
	public void render () {
		player.updateMotion();
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();

		player.sprite.draw(batch);
//		batch.draw(img, 0, 0);
//		font.draw(batch,  "Hello World", 200, 200);
		
		batch.end();
	}
}
