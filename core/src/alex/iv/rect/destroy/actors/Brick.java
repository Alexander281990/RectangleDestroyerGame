package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;

public class Brick extends BaseActor {

    private float windowPlayWidth = Gdx.graphics.getWidth();
    private float windowPlayHeight = Gdx.graphics.getHeight() / 2 - 100;
    private float brickWidth = windowPlayWidth/11;
    private float brickHeight = ((windowPlayHeight/5)*2)/11;

    public Brick(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(brickWidth, brickHeight);
        setBoundaryRectangle();
        hit = 0;
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
