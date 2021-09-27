package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class BrickHard extends BaseActor {

    private float timer_sec;
    private float sec;
    private boolean rotateBrick = true;

    private float brickWidth = Gdx.graphics.getWidth() /11f;
    private float brickHeight = Gdx.graphics.getHeight() / 60f;
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

    public void setRotateBrick(boolean rotateBrick, float t) {
        this.rotateBrick = rotateBrick;
        sec = t;
        timer_sec = sec;
    }

    // метод, который заставляет поворачиваться кирпич на 90 градусов
    private void rotateSec() {
        Action spin = Actions.rotateBy( 90, 1 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
        addAction(spin); // добавляет бесконечное вращение обькту brickHard
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        boundToWorld();
        timer_sec -= dt;
        if (!brickHardMoving) {
            leftRightMoving(0, 2, 100, 400, 0, 180);
        }
        if (!rotateBrick && timer_sec < 1) {
            rotateSec();
            timer_sec = sec;
        }

    }

}