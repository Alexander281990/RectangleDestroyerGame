package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import alex.iv.rect.destroy.LevelScreen_1;
import alex.iv.rect.destroy.LevelScreen_2;

public class GetLifeScreen extends LevelScreenMain {

    public IActivityRequestHandler requestHandler;

    public GetLifeScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler=requestHandler;
    }

    public void initialize() {


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

        uiTable.add(getLive);
        uiTable.row();
        uiTable.add(menuButton);
    }

    public void update(float dt) {

    }

}
