package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import alex.iv.rect.destroy.LevelScreen_1;
import alex.iv.rect.destroy.LevelScreen_2;
import alex.iv.rect.destroy.LevelScreen_3;

public class LoadingScreen extends BaseScreen {

    @Override
    public void initialize() {

        // инициализация кнопок New game и continue
        TextButton startButtonq = new TextButton( "Menu", BaseGame.textButtonStyle );
        //startButton.setPosition(150,150);
        uiStage.addActor(startButtonq);
        startButtonq.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
//                        LevelScreenMain.recordsLevel_1 = 0;
//                        LevelScreen_2.recordsLevel_2 = 0;
//                        LevelScreen_3.recordsLevel_3 = 0;
//                        LevelScreenMain.live = 5;
//                        pref.putInteger("records_1", LevelScreenMain.recordsLevel_1);
//                        pref.putInteger("records_2", LevelScreen_2.recordsLevel_2);
//                        pref.putInteger("records_3", LevelScreen_3.recordsLevel_3);
//                        pref.putInteger("liveMemory", LevelScreenMain.live);
//                        pref.flush();
                        RectangleGame.setActiveScreen(new MenuScreen());
                        return false;
                    }
                }
        );
        uiTable.add(startButtonq);
    }

    @Override
    public void update(float dt) {

    }
}
