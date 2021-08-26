package alex.iv.rect.destroy;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.MenuScreen;
import alex.iv.rect.destroy.controller.RectangleGame;

public class VictoryScreen extends LevelScreenMain {

    private float windowPlayWidth;
    private float windowPlayHeight;

    public VictoryScreen(IActivityRequestHandler requestHandler, String keyColor) {
        super(requestHandler);
        int attainmentColorLevel = 1;
        //live += 3;
        pref.putInteger(keyColor, attainmentColorLevel);
        //pref.putInteger("liveMemory", live);
        pref.flush();
        requestHandler.showBannerAd(); // при запуске IntermediateScreen запускается рекламный банер в нижней части экрана
    }

//    public VictoryScreen() {
//
//    }

    public void initialize() {
//        windowPlayWidth = Gdx.graphics.getWidth();
//        windowPlayHeight = Gdx.graphics.getHeight() / 2f - 100;

        final TextButton nextButton = new TextButton( "NEXT", BaseGame.textButtonStyle );
        uiStage.addActor(nextButton);
        nextButton.addListener(
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
