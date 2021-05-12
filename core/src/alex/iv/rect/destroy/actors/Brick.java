package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class Brick extends BaseActor {

    private float brickWidth = LevelScreenMain.getWindowPlayWidth() /11;
    private float brickHeight = ((LevelScreenMain.getWindowPlayHeight()/5)*2)/11;

    public Brick(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(brickWidth, brickHeight);
        setBoundaryRectangle();
        hit = 0;
    }

    public float getBrickHeight() {
        return brickHeight;
    }

    public float getBrickWidth() {
        return brickWidth;
    }

    public boolean isBrickMoving() {
        return brickMoving;
    }

    public void setBrickMoving(boolean b) {
        brickMoving = b;
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
        if (!brickMoving) {
            leftRightMoving(0, 2, 100, 400, 0, 180);
        }
    }

}
