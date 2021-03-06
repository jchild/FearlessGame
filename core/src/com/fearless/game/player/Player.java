package com.fearless.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Chris on 2/3/2016.
 * Edited by Jonathan on 02/03/2016
 */
public class Player {
    public Sprite sprite;
    private Texture img;
    private Vector2 location;
    private int velocity = 50;
    private int xV , yV;
    private float currentTime = 0;

    boolean moveRight;
    boolean moveLeft;
    boolean moveUp;
    boolean moveDown;
    boolean touchMove;

    public Player(){
        location = new Vector2();
        img = new Texture("badlogic.jpg");
        sprite = new Sprite(img, 300, 300);
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
        if(touchMove){
            handleTouch();
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

    //handles logic for the touch movement
    //todo logic to stop when player reaches touch location
    //NOT SURE IF THIS CODE WORKS ANY MORE. SHOULD PROBABLY
    //DISCUSS ITS INTENTION
    public void setPosition(float x, float y, boolean t)
    {
        if(touchMove && t) touchMove = false;
    	if(x > location.x){ xV = velocity;}
        else {xV = -velocity;}
        if(y>location.y){yV = -velocity;}
        else {yV = velocity;}
        touchMove = t;
    }

    public void setPosition(Vector2 position){
        location.set(position.x, location.y);
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

    //touch movement logic
    public void handleTouch(){
//        location.add(5 * xV * Gdx.graphics.getDeltaTime(), 5 * yV * Gdx.graphics.getDeltaTime());
    }


    private void updateSprite(){
        System.out.println("Location: X:" + location.x + ", Y:" + location.y);

        if(sprite.getX() == location.x)
            return;

        sprite.setPosition(location.x, location.y);
    }
}
