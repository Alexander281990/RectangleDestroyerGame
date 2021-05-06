package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class RectangleGame extends BaseGame {

    public static final int WORLD_WIDTH = 800, WORLD_HEIGHT = 480;
    public IActivityRequestHandler requestHandler;
    private final AssetManager assetManager = new AssetManager();
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private SpriteBatch batch;

    public RectangleGame(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void create() {
        super.create();
        batch = new SpriteBatch();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT);
        //setActiveScreen(new StartScreen(requestHandler));
        shapeRenderer = new ShapeRenderer();
        setActiveScreen(new LoadingScreen(requestHandler));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
    }

    @Override
    public void render() {
        clearScreen();
        super.render();
    }

    public Batch getBatch() {
        return batch;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
