package com.fearless.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fearless.game.input.managers.InputManager;
import com.fearless.game.input.InputTranslator;
import com.fearless.game.player.Player;

public class FearlessGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private InputManager inputManager;
	private Player player;
	private OrthographicCamera camera;

	public FearlessGame(InputManager manager){
		inputManager = manager;
	}

	public void create () {
		batch = new SpriteBatch();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1000, 1000 * (h /w));
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.update();

		player = new Player();
		inputManager.Attach(player, new InputTranslator(camera));
		Gdx.input.setInputProcessor(inputManager);
	}

	@Override
	public void render () {
		camera.update();
		player.updateMotion();
		batch.setProjectionMatrix(camera.combined);
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		player.sprite.draw(batch);
		batch.end();
	}
}
