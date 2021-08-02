package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.BaseScreen;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class Hindrance extends BaseActor {

    private float time = 2;
    private boolean hindranceIncrease = true;
    private boolean flagIncrease = true;
    private float hindranceWidth = Brick.brickWidthFromHindrance * 3;
    private float hindranceHeight = LevelScreenMain.getWindowPlayHeight() / 60;
    private boolean hindranceMoving = true;

    public Hindrance(float x, float y, Stage s, boolean b) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(hindranceWidth, hindranceHeight);
        setBoundaryRectangle();
        setColor(Color.BLACK);
        hindranceStatus = b;
    }

    private void increaseSize(float dt) {
        super.act(dt);
        time -= dt;
        if (time < 0.05 && flagIncrease) {
            setWidth(getWidth() + 10);
            setBoundaryRectangle();
            time = (float) 0.07;
            if (getWidth() > Gdx.graphics.getWidth()) {
                flagIncrease = false;
            }
        } else if (time < 0.05 && !flagIncrease) {
            setWidth(getWidth() - 10);
            setBoundaryRectangle();
            time = (float) 0.07;
            if (getWidth() < 0) {
                flagIncrease = true;
            }
        }

    }

    public void setHindranceIncrease(boolean f) {
        hindranceIncrease = f;
    }

    public void setHindranceIncrease(boolean f, float timeNew) {
        hindranceIncrease = f;
        time = timeNew;
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
        if (!hindranceIncrease) {
            increaseSize(dt);
        }
    }

}