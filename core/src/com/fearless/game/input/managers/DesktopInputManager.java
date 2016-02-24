package com.fearless.game.input.managers;

import com.badlogic.gdx.Input;


/**
 * Created by Chris on 2/3/2016.
 */
public class DesktopInputManager extends com.fearless.game.input.managers.InputManager {
    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.LEFT:
                setMoveLeft(true);
                break;
            case Input.Keys.RIGHT:
                setMoveRight(true);
                break;
        };
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {        
        switch(keycode) {
            case Input.Keys.LEFT:
                setMoveLeft(false);
                break;
            case Input.Keys.RIGHT:
                setMoveRight(false);
                break;
        };
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        translateAndSetPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
