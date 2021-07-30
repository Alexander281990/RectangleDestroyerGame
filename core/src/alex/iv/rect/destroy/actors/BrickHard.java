package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class BrickHard extends BaseActor {

    private float brickWidth = LevelScreenMain.getWindowPlayWidth() /11;
    private float brickHeight = LevelScreenMain.getWindowPlayHeight() / 60;
    private boolean brickHardMoving = true;

    public BrickHard(float x, float y, Stage s, boolean b) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(brickWidth, brickHeight);
        setOrigin(Align.center); // фиксирует центр обьекта(нужно для вращения вокруг оси)
        setBoundaryRectangle();
        setColor(Color.GRAY);
        brickHardStatus = b;
    }

    public float getBrickHeight() {
        return brickHeight;
    }

    public float getBrickWidth() {
        return brickWidth;
    }

    public void setBrickHardMoving(boolean b) {
        brickHardMoving = b;
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
        if (!brickHardMoving) {
            leftRightMoving(0, 2, 100, 400, 0, 180);
        }
    }

}