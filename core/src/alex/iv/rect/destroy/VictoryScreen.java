package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import alex.iv.rect.destroy.actors.Background;
import alex.iv.rect.destroy.actors.BallsIcon;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.MenuScreen;
import alex.iv.rect.destroy.controller.RectangleGame;

public class VictoryScreen extends LevelScreenMain {

    private Label level; // метка, которая отображает номер уровня
    private Texture exitButtonTexture, menuButtonTexture;
    private TextureRegion exitButtonTextureRegion, menuButtonTextureRegion;
    private TextureRegionDrawable exitButtonTexRegionDrawable, menuButtonTexRegionDrawable;

    public VictoryScreen(IActivityRequestHandler requestHandler, String keyColor) {
        super(requestHandler);
        int attainmentColorLevel = 1;
        //live += 3;
        //pref.putInteger("liveMemory", live);
        pref.putInteger(keyColor, attainmentColorLevel);
        pref.flush();
        requestHandler.showBannerAd(); // при запуске IntermediateScreen запускается рекламный банер в нижней части экрана
        //level.setText("Level : " + numberLevel);
        level.setText("Level : 1");
    }

//    public VictoryScreen() {
//
//    }

    public void initialize() {

        new Background(0, 0, mainStage);
        BaseActor.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        exitButtonTexture = new Texture(Gdx.files.internal("exit_button.png"));
        exitButtonTextureRegion = new TextureRegion(exitButtonTexture);
        exitButtonTexRegionDrawable = new TextureRegionDrawable(exitButtonTextureRegion);
        Button exitButton = new Button(exitButtonTexRegionDrawable);
        exitButton.setSize(Gdx.graphics.getWidth()/5f, Gdx.graphics.getHeight()/23f);
        exitButton.setPosition(Gdx.graphics.getWidth() - exitButton.getWidth(),
                Gdx.graphics.getHeight() - exitButton.getHeight());
        uiStage.addActor(exitButton);
        exitButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        Gdx.app.exit(); // выходит из игры
                        return false;
                    }
                }
        );
        level = new Label("Level" , BaseGame.labelStyleLevel);
        uiStage.addActor(level);
//        //level.setSize(Gdx.graphics.getWidth()/3f, Gdx.graphics.getHeight()/20f);
        level.setPosition(20, Gdx.graphics.getHeight() - level.getHeight());
        BallsIcon ballIconFunny = new BallsIcon(0, 0, mainStage);
        ballIconFunny.loadTexture("fun_ball.png");
        ballIconFunny.setSize(exitButton.getWidth() * 1.5f, exitButton.getWidth() * 1.5f);
        ballIconFunny.setPosition(Gdx.graphics.getWidth() / 2f - ballIconFunny.getWidth() / 2f,
                exitButton.getY() - ballIconFunny.getHeight() * 2f);
        BallsIcon textYouWin = new BallsIcon(0, 0, mainStage);
        textYouWin.loadTexture("text_you_win.png");
        textYouWin.setSize(Gdx.graphics.getWidth() * 0.9f, Gdx.graphics.getHeight() / 9f);
        textYouWin.setPosition(Gdx.graphics.getWidth() / 2f - textYouWin.getWidth() / 2f,
                ballIconFunny.getY() - ballIconFunny.getHeight());
        menuButtonTexture = new Texture(Gdx.files.internal("menu_button.png"));
        menuButtonTextureRegion = new TextureRegion(menuButtonTexture);
        menuButtonTexRegionDrawable = new TextureRegionDrawable(menuButtonTextureRegion);
        Button menuButton = new Button(menuButtonTexRegionDrawable);
        menuButton.setSize(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/14f);
        menuButton.setPosition(Gdx.graphics.getWidth() / 2f - menuButton.getWidth() / 2f,
                textYouWin.getY() - menuButton.getHeight() * 2f);
        uiStage.addActor(menuButton);
        menuButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new MenuScreen(requestHandler));
                        return false;
                    }
                }
        );

    }

    public void update(float dt) {

    }
}
