package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class StartScreen extends BaseScreen {

    private Sound clickButton;
    private static Preferences pref;
    public static int live = 2;
    static int attainment = 0;
    static int attainmentColorLevel_1 = 0;
    static int attainmentColorLevel_2 = 0;
    static int attainmentColorLevel_3 = 0;
    static int attainmentColorLevel_4 = 0;
    static int attainmentColorLevel_5 = 0;
    static int attainmentColorLevel_6 = 0;
    static int attainmentColorLevel_7 = 0;
    static int attainmentColorLevel_8 = 0;
    static int attainmentColorLevel_9 = 0;
    static int attainmentColorLevel_10 = 0;
    static int attainmentColorLevel_11 = 0;
    static int attainmentColorLevel_12 = 0;
    static int attainmentColorLevel_13 = 0;
    static int attainmentColorLevel_14 = 0;
    static int attainmentColorLevel_15 = 0;
    static int attainmentColorLevel_16 = 0;
    static int attainmentColorLevel_17 = 0;
    static int attainmentColorLevel_18 = 0;
    static int attainmentColorLevel_19 = 0;
    static int attainmentColorLevel_20 = 0;
    static int attainmentColorLevel_21 = 0;
    static int attainmentColorLevel_22 = 0;
    static int attainmentColorLevel_23 = 0;
    static int attainmentColorLevel_24 = 0;
    static int attainmentColorLevel_25 = 0;
    static int attainmentColorLevel_26 = 0;
    static int attainmentColorLevel_27 = 0;
    static int attainmentColorLevel_28 = 0;
    static int attainmentColorLevel_29 = 0;
    static int attainmentColorLevel_30 = 0;
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
    protected static int recordsLevel_15;
    protected static int recordsLevel_16;
    protected static int recordsLevel_17;
    protected static int recordsLevel_18;
    protected static int recordsLevel_19;
    protected static int recordsLevel_20;
    protected static int recordsLevel_21;
    protected static int recordsLevel_22;
    protected static int recordsLevel_23;
    protected static int recordsLevel_24;
    protected static int recordsLevel_25;
    protected static int recordsLevel_26;
    protected static int recordsLevel_27;
    protected static int recordsLevel_28;
    protected static int recordsLevel_29;
    protected static int recordsLevel_30;

    public IActivityRequestHandler requestHandler;

    public StartScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public StartScreen() {
    }

    @Override
    public void initialize() {

        clickButton = Gdx.audio.newSound(Gdx.files.internal("click_button.wav"));
        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне
        live = pref.getInteger("liveMemory");
        attainment = pref.getInteger("attainmentMemory");
        attainmentColorLevel_1 = pref.getInteger("attainmentColorLevelMemory_1");
        attainmentColorLevel_2 = pref.getInteger("attainmentColorLevelMemory_2");
        attainmentColorLevel_3 = pref.getInteger("attainmentColorLevelMemory_3");
        attainmentColorLevel_4 = pref.getInteger("attainmentColorLevelMemory_4");
        attainmentColorLevel_5 = pref.getInteger("attainmentColorLevelMemory_5");
        attainmentColorLevel_6 = pref.getInteger("attainmentColorLevelMemory_6");
        attainmentColorLevel_7 = pref.getInteger("attainmentColorLevelMemory_7");
        attainmentColorLevel_8 = pref.getInteger("attainmentColorLevelMemory_8");
        attainmentColorLevel_9 = pref.getInteger("attainmentColorLevelMemory_9");
        attainmentColorLevel_10 = pref.getInteger("attainmentColorLevelMemory_10");
        attainmentColorLevel_11 = pref.getInteger("attainmentColorLevelMemory_11");
        attainmentColorLevel_12 = pref.getInteger("attainmentColorLevelMemory_12");
        attainmentColorLevel_13 = pref.getInteger("attainmentColorLevelMemory_13");
        attainmentColorLevel_14 = pref.getInteger("attainmentColorLevelMemory_14");
        attainmentColorLevel_15 = pref.getInteger("attainmentColorLevelMemory_15");
        attainmentColorLevel_16 = pref.getInteger("attainmentColorLevelMemory_16");
        attainmentColorLevel_17 = pref.getInteger("attainmentColorLevelMemory_17");
        attainmentColorLevel_18 = pref.getInteger("attainmentColorLevelMemory_18");
        attainmentColorLevel_19 = pref.getInteger("attainmentColorLevelMemory_19");
        attainmentColorLevel_20 = pref.getInteger("attainmentColorLevelMemory_20");
        attainmentColorLevel_21 = pref.getInteger("attainmentColorLevelMemory_21");
        attainmentColorLevel_22 = pref.getInteger("attainmentColorLevelMemory_22");
        attainmentColorLevel_23 = pref.getInteger("attainmentColorLevelMemory_23");
        attainmentColorLevel_24 = pref.getInteger("attainmentColorLevelMemory_24");
        attainmentColorLevel_25 = pref.getInteger("attainmentColorLevelMemory_25");
        attainmentColorLevel_26 = pref.getInteger("attainmentColorLevelMemory_26");
        attainmentColorLevel_27 = pref.getInteger("attainmentColorLevelMemory_27");
        attainmentColorLevel_28 = pref.getInteger("attainmentColorLevelMemory_28");
        attainmentColorLevel_29 = pref.getInteger("attainmentColorLevelMemory_29");
        attainmentColorLevel_30 = pref.getInteger("attainmentColorLevelMemory_30");
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
        recordsLevel_15 = pref.getInteger("records_15");
        recordsLevel_16 = pref.getInteger("records_16");
        recordsLevel_17 = pref.getInteger("records_17");
        recordsLevel_18 = pref.getInteger("records_18");
        recordsLevel_19 = pref.getInteger("records_19");
        recordsLevel_20 = pref.getInteger("records_20");
        recordsLevel_21 = pref.getInteger("records_21");
        recordsLevel_22 = pref.getInteger("records_22");
        recordsLevel_23 = pref.getInteger("records_23");
        recordsLevel_24 = pref.getInteger("records_24");
        recordsLevel_25 = pref.getInteger("records_25");
        recordsLevel_26 = pref.getInteger("records_26");
        recordsLevel_27 = pref.getInteger("records_27");
        recordsLevel_28 = pref.getInteger("records_28");
        recordsLevel_29 = pref.getInteger("records_29");
        recordsLevel_30 = pref.getInteger("records_30");
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
                        recordsLevel_15 = 0;
                        recordsLevel_16 = 0;
                        recordsLevel_17 = 0;
                        recordsLevel_18 = 0;
                        recordsLevel_19 = 0;
                        recordsLevel_20 = 0;
                        recordsLevel_21 = 0;
                        recordsLevel_22 = 0;
                        recordsLevel_23 = 0;
                        recordsLevel_24 = 0;
                        recordsLevel_25 = 0;
                        recordsLevel_26 = 0;
                        recordsLevel_27 = 0;
                        recordsLevel_28 = 0;
                        recordsLevel_29 = 0;
                        recordsLevel_30 = 0;
                        live = 5;
                        attainment = 0;
                        attainmentColorLevel_1 = 0;
                        attainmentColorLevel_2 = 0;
                        attainmentColorLevel_3 = 0;
                        attainmentColorLevel_4 = 0;
                        attainmentColorLevel_5 = 0;
                        attainmentColorLevel_6 = 0;
                        attainmentColorLevel_7 = 0;
                        attainmentColorLevel_8 = 0;
                        attainmentColorLevel_9 = 0;
                        attainmentColorLevel_10 = 0;
                        attainmentColorLevel_11 = 0;
                        attainmentColorLevel_12 = 0;
                        attainmentColorLevel_13 = 0;
                        attainmentColorLevel_14 = 0;
                        attainmentColorLevel_15 = 0;
                        attainmentColorLevel_16 = 0;
                        attainmentColorLevel_17 = 0;
                        attainmentColorLevel_18 = 0;
                        attainmentColorLevel_19 = 0;
                        attainmentColorLevel_20 = 0;
                        attainmentColorLevel_21 = 0;
                        attainmentColorLevel_22 = 0;
                        attainmentColorLevel_23 = 0;
                        attainmentColorLevel_24 = 0;
                        attainmentColorLevel_25 = 0;
                        attainmentColorLevel_26 = 0;
                        attainmentColorLevel_27 = 0;
                        attainmentColorLevel_28 = 0;
                        attainmentColorLevel_29 = 0;
                        attainmentColorLevel_30 = 0;
                        pref.putInteger("attainmentColorLevelMemory_1", attainmentColorLevel_1);
                        pref.putInteger("attainmentColorLevelMemory_2", attainmentColorLevel_2);
                        pref.putInteger("attainmentColorLevelMemory_3", attainmentColorLevel_3);
                        pref.putInteger("attainmentColorLevelMemory_4", attainmentColorLevel_4);
                        pref.putInteger("attainmentColorLevelMemory_5", attainmentColorLevel_5);
                        pref.putInteger("attainmentColorLevelMemory_6", attainmentColorLevel_6);
                        pref.putInteger("attainmentColorLevelMemory_7", attainmentColorLevel_7);
                        pref.putInteger("attainmentColorLevelMemory_8", attainmentColorLevel_8);
                        pref.putInteger("attainmentColorLevelMemory_9", attainmentColorLevel_9);
                        pref.putInteger("attainmentColorLevelMemory_10", attainmentColorLevel_10);
                        pref.putInteger("attainmentColorLevelMemory_11", attainmentColorLevel_11);
                        pref.putInteger("attainmentColorLevelMemory_12", attainmentColorLevel_12);
                        pref.putInteger("attainmentColorLevelMemory_13", attainmentColorLevel_13);
                        pref.putInteger("attainmentColorLevelMemory_14", attainmentColorLevel_14);
                        pref.putInteger("attainmentColorLevelMemory_15", attainmentColorLevel_15);
                        pref.putInteger("attainmentColorLevelMemory_16", attainmentColorLevel_16);
                        pref.putInteger("attainmentColorLevelMemory_17", attainmentColorLevel_17);
                        pref.putInteger("attainmentColorLevelMemory_18", attainmentColorLevel_18);
                        pref.putInteger("attainmentColorLevelMemory_19", attainmentColorLevel_19);
                        pref.putInteger("attainmentColorLevelMemory_20", attainmentColorLevel_20);
                        pref.putInteger("attainmentColorLevelMemory_21", attainmentColorLevel_21);
                        pref.putInteger("attainmentColorLevelMemory_22", attainmentColorLevel_22);
                        pref.putInteger("attainmentColorLevelMemory_23", attainmentColorLevel_23);
                        pref.putInteger("attainmentColorLevelMemory_24", attainmentColorLevel_24);
                        pref.putInteger("attainmentColorLevelMemory_25", attainmentColorLevel_25);
                        pref.putInteger("attainmentColorLevelMemory_26", attainmentColorLevel_26);
                        pref.putInteger("attainmentColorLevelMemory_27", attainmentColorLevel_27);
                        pref.putInteger("attainmentColorLevelMemory_28", attainmentColorLevel_28);
                        pref.putInteger("attainmentColorLevelMemory_29", attainmentColorLevel_29);
                        pref.putInteger("attainmentColorLevelMemory_30", attainmentColorLevel_30);
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
                        pref.putInteger("records_15", recordsLevel_15);
                        pref.putInteger("records_16", recordsLevel_16);
                        pref.putInteger("records_17", recordsLevel_17);
                        pref.putInteger("records_18", recordsLevel_18);
                        pref.putInteger("records_19", recordsLevel_19);
                        pref.putInteger("records_20", recordsLevel_20);
                        pref.putInteger("records_21", recordsLevel_21);
                        pref.putInteger("records_22", recordsLevel_22);
                        pref.putInteger("records_23", recordsLevel_23);
                        pref.putInteger("records_24", recordsLevel_24);
                        pref.putInteger("records_25", recordsLevel_25);
                        pref.putInteger("records_26", recordsLevel_26);
                        pref.putInteger("records_27", recordsLevel_27);
                        pref.putInteger("records_28", recordsLevel_28);
                        pref.putInteger("records_29", recordsLevel_29);
                        pref.putInteger("records_30", recordsLevel_30);
                        pref.putInteger("liveMemory", live);
                        pref.flush();
                        clickButton.play();
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
                        clickButton.play();
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