package com.fearless.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.fearless.game.player.Player;

import java.util.List;


/**
 * Created by Chris on 2/3/2016.
 */
public class InputManager implements InputProcessor {
    private Player player;
    private InputTranslator inputTranslator;

    public InputManager(Player p, InputTranslator translator){
        player = p;
        inputTranslator = translator;
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

    /**
     *  Edited by Jonathan on 02/03/2016
     *  not getting correct y coordinates
     */

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(pointer > 0){return false;}

        Vector2 position = translateCoordinates(screenX, screenY);
        player.setPosition(position);
//        Vector2 position = inputTranslator.Translate2DCoordinates(-screenX, -screenY);
//        player.setPosition(position.x,position.y,true);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(pointer > 0){return false;}
        Vector2 position = translateCoordinates(screenX, screenY);
        player.setPosition(position);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 position = translateCoordinates(screenX, screenY);
        player.setPosition(position);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector2 position = inputTranslator.Translate2DCoordinates(screenX, screenY);
        player.setPosition(position);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private Vector2 translateCoordinates(int screenX, int screenY){
        return inputTranslator.Translate2DCoordinates(screenX, screenY);

    }
}
