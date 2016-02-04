package com.fearless.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.fearless.game.player.Player;

import java.util.List;

/**
 * Created by Chris on 2/3/2016.
 */
public class InputManager implements InputProcessor {
    private Player player;

    public InputManager(Player p){
        player = p;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.LEFT:
                player.setMoveLeft(true);
                break;
            case Input.Keys.RIGHT:
                player.setMoveRight(true);
                break;
            case Input.Keys.UP:
                player.setMoveUp(true);
                break;
            case Input.Keys.DOWN:
                player.setMoveDown(true);
                break;
        };
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {        
        switch(keycode) {
            case Input.Keys.LEFT:
                player.setMoveLeft(false);
                break;
            case Input.Keys.RIGHT:
                player.setMoveRight(false);
                break;
            case Input.Keys.UP:
                player.setMoveUp(false);
                break;
            case Input.Keys.DOWN:
                player.setMoveDown(false);
                break;
        };
        return true;
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
    //Need to translate to world coordinates
    //player.setPosition(screenX, -screenY);
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
