package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class Brick extends BaseActor {

    //private float brickWidth = LevelScreenMain.getWindowPlayWidth() / 11;
    private float brickWidth = Gdx.graphics.getWidth()/11f;
    //private float brickHeight = LevelScreenMain.getWindowPlayHeight() / 60;
    private float brickHeight = Gdx.graphics.getHeight()/60f;
    //public static float brickWidthFromHindrance = LevelScreenMain.getWindowPlayWidth() / 11;
    public static float brickWidthFromHindrance = Gdx.graphics.getWidth()/11f;
    private boolean brickMoving = true;
    private boolean brickFlash = true;
    private boolean brickFlashTwoSec = true;
    private float timeBrick;

    public Brick(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("brick-gray.png");
        setSize(brickWidth, brickHeight);
        setBoundaryRectangle();
        hit = 0;
        setTimeBrick(5);
        mBrick = false;
    }

    // метод, который заставляет мигать кирпичики с частотой в 5 секунд
    private void flashingBrick(float dt) {
        timeBrick -= dt;
        if ((int)timeBrick == 0) {
            switch (MathUtils.random(5)) {
                case 1:
                    this.setColor(Color.RED);
                    break;
                case 2:
                    this.setColor(Color.ORANGE);
                    this.numberColor = 2;
                    break;
                case 3:
                    this.setColor(Color.YELLOW);
                    this.numberColor = 3;
                    break;
                case 4:
                    this.setColor(Color.GREEN);
                    this.numberColor = 4;
                case 5:
                    this.setColor(Color.BLUE);
                    this.numberColor = 5;
                    break;
                default:
            }
            timeBrick = 5;
        }
    }

    // метод, который заставляет мигать кирпичики с частотой в 5 секунд
    private void flashingBrick(float dt, float time) {
        timeBrick -= dt;
        if ((int)timeBrick == 0) {
            switch (MathUtils.random(5)) {
                case 1:
                    this.setColor(Color.RED);
                    break;
                case 2:
                    this.setColor(Color.ORANGE);
                    this.numberColor = 2;
                    break;
                case 3:
                    this.setColor(Color.YELLOW);
                    this.numberColor = 3;
                    break;
                case 4:
                    this.setColor(Color.GREEN);
                    this.numberColor = 4;
                case 5:
                    this.setColor(Color.BLUE);
                    this.numberColor = 5;
                    break;
                default:
            }
            timeBrick = time;
        }
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

    public void setTimeBrick(float t) {
        timeBrick = t;
    }

    public float getTimeBrick() {
        return timeBrick;
    }

    public void setBrickFlash(boolean f) {
        brickFlash = f;
    }

    public void setBrickFlash(boolean f, boolean t) {
        brickFlash = f;
        brickFlashTwoSec = t;
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
        if (!brickMoving) {
            leftRightMoving(0, 2, 100, 400, 0, 180);
        }
        if (!brickFlash && !brickFlashTwoSec) {
            flashingBrick(dt, 3);
        }
        if (!brickFlash) {
            flashingBrick(dt);
        }
    }

}
