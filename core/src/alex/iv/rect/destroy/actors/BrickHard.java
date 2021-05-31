package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class BrickHard extends BaseActor {

    private float brickWidth = LevelScreenMain.getWindowPlayWidth() /11;
    //private float brickHeight = ((LevelScreenMain.getWindowPlayHeight()/5)*2)/11;
    private float brickHeight = LevelScreenMain.getWindowPlayHeight() / 60;

    public BrickHard(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(brickWidth, brickHeight);
        setBoundaryRectangle();
        setColor(Color.GRAY);
    }

    public float getBrickHeight() {
        return brickHeight;
    }

    public float getBrickWidth() {
        return brickWidth;
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
    }

}