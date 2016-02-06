package com.fearless.game.input.managers;

public class TouchInputManager extends com.fearless.game.input.managers.InputManager {

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(pointer > 0){return false;}
        translateAndSetPosition(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer > 0){return false;}
        translateAndSetPosition(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(pointer > 0){return false;}
        translateAndSetPosition(screenX, screenY);
        return false;
    }
}
