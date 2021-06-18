package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;

public class Lock extends BaseActor {

    public Lock(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("lock.png");
    }

}
