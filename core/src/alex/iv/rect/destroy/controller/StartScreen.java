package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class StartScreen extends BaseScreen {

    private static Preferences pref;
    public static int live = 2;
    public static int attainment = 1;
    protected static int recordsLevel_1;
    protected static int recordsLevel_2;
    protected static int recordsLevel_3;
    protected static int recordsLevel_4;
    protected static int recordsLevel_5;
    protected static int recordsLevel_6;
    protected static int recordsLevel_7;
    protected static int recordsLevel_8;
    protected static int recordsLevel_9;
    protected static int recordsLevel_10;
    protected static int recordsLevel_11;
    protected static int recordsLevel_12;
    protected static int recordsLevel_13;
    protected static int recordsLevel_14;

    public IActivityRequestHandler requestHandler;

    public StartScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public StartScreen() {
    }

    @Override
    public void initialize() {

        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне
        live = pref.getInteger("liveMemory");
        attainment = pref.getInteger("attainmentMemory");
        recordsLevel_1 = pref.getInteger("records_1");
        recordsLevel_2 = pref.getInteger("records_2");
        recordsLevel_3 = pref.getInteger("records_3");
        recordsLevel_4 = pref.getInteger("records_4");
        recordsLevel_5 = pref.getInteger("records_5");
        recordsLevel_6 = pref.getInteger("records_6");
        recordsLevel_7 = pref.getInteger("records_7");
        recordsLevel_8 = pref.getInteger("records_8");
        recordsLevel_9 = pref.getInteger("records_9");
        recordsLevel_10 = pref.getInteger("records_10");
        recordsLevel_11 = pref.getInteger("records_11");
        recordsLevel_12 = pref.getInteger("records_12");
        recordsLevel_13 = pref.getInteger("records_13");
        recordsLevel_14 = pref.getInteger("records_14");
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
                        recordsLevel_6 = 0;
                        recordsLevel_7 = 0;
                        recordsLevel_8 = 0;
                        recordsLevel_9 = 0;
                        recordsLevel_10 = 0;
                        recordsLevel_11 = 0;
                        recordsLevel_12 = 0;
                        recordsLevel_13 = 0;
                        recordsLevel_14 = 0;
                        live = 2;
                        attainment = 1;
                        pref.putInteger("attainmentMemory", attainment);
                        pref.putInteger("records_1", recordsLevel_1);
                        pref.putInteger("records_2", recordsLevel_2);
                        pref.putInteger("records_3", recordsLevel_3);
                        pref.putInteger("records_4", recordsLevel_4);
                        pref.putInteger("records_5", recordsLevel_5);
                        pref.putInteger("records_6", recordsLevel_6);
                        pref.putInteger("records_7", recordsLevel_7);
                        pref.putInteger("records_8", recordsLevel_8);
                        pref.putInteger("records_9", recordsLevel_9);
                        pref.putInteger("records_10", recordsLevel_10);
                        pref.putInteger("records_11", recordsLevel_11);
                        pref.putInteger("records_12", recordsLevel_12);
                        pref.putInteger("records_13", recordsLevel_13);
                        pref.putInteger("records_14", recordsLevel_14);
                        pref.putInteger("liveMemory", live);
                        pref.flush();
                        RectangleGame.setActiveScreen(new MenuScreen(requestHandler));
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
                        RectangleGame.setActiveScreen(new MenuScreen(requestHandler));
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

        Gdx.app.log("MyTag", String.valueOf(attainment));

    }

    @Override
    public void update(float dt) {

    }
}