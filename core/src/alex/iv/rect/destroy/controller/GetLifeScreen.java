package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

import alex.iv.rect.destroy.LevelScreen_1;
import alex.iv.rect.destroy.LevelScreen_2;

public class GetLifeScreen extends LevelScreenMain {

    public IActivityRequestHandler requestHandler;
    private Label finishedLives;

    public GetLifeScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler=requestHandler;
    }

    public void initialize() {

        finishedLives = new Label("Live:", BaseGame.labelStyleLevel);
        uiStage.addActor(finishedLives);
        finishedLives.setText("Your lives are over");

        TextButton getLive = new TextButton( "Get Live", BaseGame.textButtonStyle );
        uiStage.addActor(getLive);
        getLive.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        requestHandler.showVideoAd();
                        return false;
                    }
                }
        );
        // инициализация кнопок New game и continue(конец)

        TextButton menuButton = new TextButton( "MENU", BaseGame.textButtonStyle );
        //exitButton.setPosition(10, Gdx.graphics.getHeight() - exitButton.getHeight() - 10);
        uiStage.addActor(menuButton);
        menuButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
//                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
                        RectangleGame.setActiveScreen(new MenuScreen(requestHandler));
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );
        // инициализация кнопок New game и continue(конец)

        // устанавливает фоновую картинку в Table
        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("background/fon_level_3.png")),
                3, 3, 3, 3);
        NinePatchDrawable background = new NinePatchDrawable(patch);
        // устанавливает фоновую картинку в Table(конец)

        uiTable.setBackground(background);
        uiTable.add(finishedLives).padTop(20);
        uiTable.row();
        uiTable.add(getLive).padTop(20);
        uiTable.row();
        uiTable.add(menuButton).padTop(20);
    }

    public void update(float dt) {

    }

}
