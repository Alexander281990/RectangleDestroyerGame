package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class Hindrance extends BaseActor {

    private float hindranceWidth = LevelScreenMain.getWindowPlayWidth() / 4;
    private float hindranceHeight = LevelScreenMain.getWindowPlayHeight() / 60;
    private boolean hindranceMoving = true;

    public Hindrance(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(hindranceWidth, hindranceHeight);
        setBoundaryRectangle();
        setColor(Color.BLACK);
    }

    public float getHindranceHeight() {
        return hindranceHeight;
    }

    public float getHindranceWidth() {
        return hindranceWidth;
    }

    public boolean isHindranceMoving() {
        return hindranceMoving;
    }

    public void setHindranceMoving(boolean b) {
        hindranceMoving = b;
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
        if (!hindranceMoving) {
            leftRightMoving(0, 2, 100, 400, 0, 180);
        }
    }

}