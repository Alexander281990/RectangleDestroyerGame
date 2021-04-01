package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class StartScreen extends BaseScreen {

    protected static Preferences pref;
    static int live = 5;
    protected static int recordsLevel_1;
    protected static int recordsLevel_2;
    protected static int recordsLevel_3;
    protected static int recordsLevel_4;
    protected static int recordsLevel_5;

    @Override
    public void initialize() {

        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне
        live = pref.getInteger("liveMemory");
        recordsLevel_1 = pref.getInteger("records_1");
        recordsLevel_2 = pref.getInteger("records_2");
        recordsLevel_3 = pref.getInteger("records_3");
        recordsLevel_4 = pref.getInteger("records_4");
        recordsLevel_5 = pref.getInteger("records_5");
        // инициализация кнопок New game и continue
        TextButton startButton = new TextButton( "New game", BaseGame.textButtonStyle );
        //startButton.setPosition(150,150);
        uiStage.addActor(startButton);
        startButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        recordsLevel_1 = 0;
                        recordsLevel_2 = 0;
                        recordsLevel_3 = 0;
                        recordsLevel_4 = 0;
                        recordsLevel_5 = 0;
                        live = 5;
                        pref.putInteger("records_1", recordsLevel_1);
                        pref.putInteger("records_2", recordsLevel_2);
                        pref.putInteger("records_3", recordsLevel_3);
                        pref.putInteger("records_4", recordsLevel_4);
                        pref.putInteger("records_5", recordsLevel_5);
                        pref.putInteger("liveMemory", live);
                        pref.flush();
                        RectangleGame.setActiveScreen(new MenuScreen());
                        return false;
                    }
                }
        );

        TextButton continueButton = new TextButton( "Continue", BaseGame.textButtonStyle );
        //continueButton.setPosition(1000,150);
        uiStage.addActor(continueButton);
        continueButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        //Gdx.app.exit(); // выходит из игры
                        RectangleGame.setActiveScreen(new MenuScreen());
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );
        // инициализация кнопок New game и continue(конец)

        //uiTable.row();
        uiTable.add(startButton);
        uiTable.add().size(250, startButton.getHeight());
        uiTable.add(continueButton);

    }

    @Override
    public void update(float dt) {

    }
}