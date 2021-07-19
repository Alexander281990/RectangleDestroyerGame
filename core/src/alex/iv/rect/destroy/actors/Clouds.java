package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;

public class Clouds extends BaseActor {

    public Clouds(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("clouds/cloud_1.png");
        //setSize(100, 100);
        setSpeed(100);
        setPosition(0, Gdx.graphics.getHeight());
        setMaxSpeed(400);
        setDeceleration(0); // замедление
        //setMotionAngle(- 90); // заставляет двигаться обьект сверху в низ
    }

    //////////////////////////////////

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);

     //    если вражеский звездолет достиг нижней части, то он удаляется
        if (getY() + Gdx.graphics.getHeight() < 0) {
            //remove();
            setPosition(0, Gdx.graphics.getHeight());
        }
    }
}