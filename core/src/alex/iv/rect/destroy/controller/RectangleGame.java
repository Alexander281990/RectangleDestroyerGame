package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class RectangleGame extends BaseGame {

    public IActivityRequestHandler requestHandler;

    public RectangleGame(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void create() {
        super.create();
        setActiveScreen(new StartScreen(requestHandler));
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        clearScreen();
        super.render();
    }


    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
