package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LoadingScreen extends BaseScreen {

    public IActivityRequestHandler requestHandler;

    private static final float PROGRESS_BAR_WIDTH = RectangleGame.WORLD_WIDTH / 2f;
    private static final float PROGRESS_BAR_HEIGHT = 50f;

    private final RectangleGame game = (RectangleGame) Gdx.app.getApplicationListener();
    private final AssetManager assetManager = game.getAssetManager();
    private final ShapeRenderer shapeRenderer = game.getShapeRenderer();

    public LoadingScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void show() {
        super.show();
        assetManager.load("background/fon_level.png", Texture.class);
    }

    @Override
    public void update(float var1) {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        renderProgressBar();

        if (assetManager.update()) {
            // Comment this out if you just want to see the progress bar. As this can be quite quick on desktop.
            game.setScreen(new StartScreen(requestHandler));
        }
    }

    private void renderProgressBar() {
        float progress = assetManager.getProgress();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(
                (RectangleGame.WORLD_WIDTH - PROGRESS_BAR_WIDTH) / 2f,
                (RectangleGame.WORLD_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f,
                PROGRESS_BAR_WIDTH * progress,
                PROGRESS_BAR_HEIGHT
        );
        shapeRenderer.end();
    }

}