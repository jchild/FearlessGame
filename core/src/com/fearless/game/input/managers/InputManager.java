package com.fearless.game.input.managers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.fearless.game.input.InputTranslator;
import com.fearless.game.player.Player;

public abstract class InputManager implements InputProcessor {
    private Player player;
    private InputTranslator inputTranslator;

    public void Attach(){
        player = new Player();
        inputTranslator = new InputTranslator(new OrthographicCamera());
    }

    public void Attach(Player p, InputTranslator translator){
        player = p;
        inputTranslator = translator;
    }

    protected void translateAndSetPosition(float screenX, float screenY){
        Vector2 position = translateCoordinates(screenX, screenY);
        player.setPosition(position);
    }

    protected void setMoveLeft(boolean moveLeft){
        player.setMoveLeft(moveLeft);
    }

    protected void setMoveRight(boolean moveRight){
        player.setMoveRight(moveRight);
    }

    private Vector2 translateCoordinates(float screenX, float screenY){
        return inputTranslator.Translate2DCoordinates(screenX, screenY);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
