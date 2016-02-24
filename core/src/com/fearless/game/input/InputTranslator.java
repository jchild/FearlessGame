package com.fearless.game.input;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Chris on 2/4/2016.
 */
public class InputTranslator {
    private Camera camera;

    public InputTranslator(Camera cam){
        camera = cam;
    }

    public Vector2 Translate2DCoordinates(float x, float y){
        Vector3 translatedCoords = new Vector3();
        camera.unproject(translatedCoords.set(x,y,0));
        
        return new Vector2(translatedCoords.x, translatedCoords.y);
    }
}
