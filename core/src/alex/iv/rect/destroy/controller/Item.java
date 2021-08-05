package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Item extends BaseActor {

    public enum Live {LIVE}
    public enum Type { PADDLE_EXPAND, PADDLE_SHRINK, BALL_SPEED_UP, BALL_SPEED_DOWN, BALL_TWO, PADDLE_STOP}
    private Type type;

    public Item(float x, float y, Stage s) {
        super(x,y,s);
        setRandomType();
        setSpeed(100);
        setMotionAngle(270);
        setSize(50,50);
        setOrigin(25,25);
        setBoundaryRectangle();
        setScale(0,0);
        addAction( Actions.scaleTo(1,1, 0.25f) );
    }

    Item(float x, float y, Stage s, String l) {
        super(x,y,s);
        setSpeed(100);
        setLive();
        setMotionAngle(270);
        setSize(50,50);
        setOrigin(25,25);
        setBoundaryRectangle();
        setScale(0,0);
        addAction( Actions.scaleTo(1,1, 0.25f) );
    }

    public void setType(Type t) {
        type = t;

        if (t == Type.PADDLE_EXPAND)
            loadTexture("items/paddle-expand.png");
        else if (t == Type.PADDLE_SHRINK)
            loadTexture("items/paddle-shrink.png");
        else if (t == Type.BALL_SPEED_UP)
            loadTexture("items/ball-speed-up.png");
        else if (t == Type.BALL_SPEED_DOWN)
            loadTexture("items/ball-speed-down.png");
        else if (t == Type.BALL_TWO)
            loadTexture("items/ball-two.png");
        else if (t == Type.PADDLE_STOP)
            loadTexture("items/paddle-stop.png");
        else
            loadTexture("items/item-blank.png");

    }

    private void setLive() {
        loadTexture("items/live.png");
    }

    public Live getLive() {
        return Live.LIVE;
    }

    private void setRandomType() {
        int randomIndex = MathUtils.random(0, Type.values().length - 1);
        Type randomType = Type.values()[randomIndex];
        setType(randomType);
    }

    public Type getType() {
        return type;
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        if (getY() < -50)
            remove();
    }

}
