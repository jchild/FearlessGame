package com.fearless.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;

import sun.rmi.runtime.Log;

/**
 * Created by Chris on 2/3/2016.
 */
public class Player {
    public Sprite sprite;
    private Texture img;
    private Vector2 location;
    private int velocity = 50;

    boolean moveRight;
    boolean moveLeft;
    boolean moveUp;
    boolean moveDown;

    public Player(){
        location = new Vector2();
        img = new Texture("badlogic.jpg");
        sprite = new Sprite(img, 50, 50);
    }

    public void updateMotion(){
        if(moveLeft){
            handleLeftMovement();
        }
        if(moveRight){
            handleRightMovement();
        }
        if(moveUp){
        	handleUpMovement();
        }
        if(moveDown){
        	handleDownMovement();
        }

        updateSprite();
    }

    public void setMoveLeft(boolean t){
        if(moveRight && t) moveLeft = false;
        moveLeft = t;
    }

    public void setMoveRight(boolean t){
        if(moveLeft && t) moveRight = false;
        moveRight = t;
    }
    
    public void setPosition(int x, int y)
    {
    	location.x = x;
    	location.y = y;
    	
    	updateSprite();
    }
    
    public void setMoveUp(boolean t){
        if(moveDown && t) moveUp = false;
        moveUp = t;
    }
    
    public void setMoveDown(boolean t){
        if(moveUp && t) moveDown = false;
        moveDown = t;
    }

    private void handleLeftMovement(){    	
        location.add(5 * -velocity * Gdx.graphics.getDeltaTime(), 0);
    }

    private void handleRightMovement(){
        location.add(5 * velocity * Gdx.graphics.getDeltaTime(), 0);
    }
    
    private void handleUpMovement(){
        location.add(0, 5 * velocity * Gdx.graphics.getDeltaTime());
    }
    
    private void handleDownMovement(){
        location.add(0, 5 * -velocity * Gdx.graphics.getDeltaTime());
    }

    private void updateSprite(){
        sprite.setPosition(location.x, location.y);
    }
}
