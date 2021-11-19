package alex.iv.rect.destroy.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

import alex.iv.rect.destroy.controller.BaseActor;

public class Background extends BaseActor {

    public Background(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("background/start_screen.png");
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        // следующие 2 строчки отвечают за движение облаков
        Clouds cloud = new Clouds(0, Gdx.graphics.getHeight(), s);
        s.addActor(cloud);
    }

}
