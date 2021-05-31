package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;

public class Ball extends BaseActor {

    private boolean paused;
    private float ballHeight = Gdx.graphics.getHeight() / 60f;
    private float ballWidth = Gdx.graphics.getHeight() / 60f;

    public Ball(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("ball.png");
        setSize(ballWidth, ballHeight);
        setBoundaryRectangle();
        setSpeed(700);
        setMaxSpeed(1500);
        setMotionAngle(90);
        setBoundaryPolygon(12);
        setPaused(true);

    }

    public Ball(float x, float y, boolean paused, Stage s) {
        super(x,y,s);
        loadTexture("ball.png");
        setSize(ballWidth, ballHeight);
        setBoundaryRectangle();
        setSpeed(700);
        setMaxSpeed(1500);
        setMotionAngle(90);
        setBoundaryPolygon(12);
        setPaused(paused);

    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean b) {
        paused = b;
    }

    public void bounceOff(BaseActor other) {
        Vector2 v = this.preventOverlap(other);
        if ( Math.abs(v.x) >= Math.abs(v.y) ){ // horizontal bounce
            this.velocityVec.x *= -1;
        } else { // vertical bounce
            this.velocityVec.y *= -1;
        }
    }


    public void act(float dt) {
        super.act(dt);
        if ( !isPaused() ) {
           setAcceleration(10); accelerateAtAngle(270); applyPhysics(dt);
        }
    }

}
