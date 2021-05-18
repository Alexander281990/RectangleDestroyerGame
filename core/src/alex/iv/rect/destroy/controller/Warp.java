package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Warp extends BaseActor {
    public Warp(float x, float y, Stage s) {
        super(x,y,s);
        loadAnimationFromSheet("warp.png", 4, 8, 0.05f, true);
        setBoundaryPolygon(12);
        //addAction( Actions.delay(10) );
        //addAction( Actions.after( Actions.fadeOut(0.5f) ) );
        //addAction( Actions.after( Actions.removeActor() ) );
    }

    public Warp(float x, float y, String name,  Stage s) {
        super(x,y,s);
        //loadTexture(name);
        loadAnimationFromSheet(name, 3, 6, 0.07f, true);
        //addAction(Actions.rotateBy(180, 2));
        setBoundaryPolygon(12);
        //addAction( Actions.delay(10) );
        //addAction( Actions.after( Actions.fadeOut(0.5f) ) );
        //addAction( Actions.after( Actions.removeActor() ) );
    }
}
