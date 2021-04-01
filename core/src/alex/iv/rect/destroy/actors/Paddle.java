package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;

public class Paddle extends BaseActor {

    public boolean paused;

    public Paddle(float x, float y, Stage s) {
        super(x,y,s);
        loadTexture("paddle.png");
    }

}
