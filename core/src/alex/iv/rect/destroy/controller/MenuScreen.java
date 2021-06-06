package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

import alex.iv.rect.destroy.LevelScreen_1;
import alex.iv.rect.destroy.LevelScreen_10;
import alex.iv.rect.destroy.LevelScreen_11;
import alex.iv.rect.destroy.LevelScreen_2;
import alex.iv.rect.destroy.LevelScreen_3;
import alex.iv.rect.destroy.LevelScreen_4;
import alex.iv.rect.destroy.LevelScreen_5;
import alex.iv.rect.destroy.LevelScreen_6;
import alex.iv.rect.destroy.LevelScreen_7;
import alex.iv.rect.destroy.LevelScreen_8;
import alex.iv.rect.destroy.LevelScreen_9;

public class MenuScreen extends StartScreen {

    public IActivityRequestHandler requestHandler;
    public LevelScreenMain levelScreenMain;
    public static Preferences pref;

    public MenuScreen() {

    }

    public MenuScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void initialize() {

        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне
//        recordsLevel_1 = pref.getInteger("records_1");
//        recordsLevel_2 = pref.getInteger("records_2");

        levelScreenMain = new LevelScreenMain(requestHandler);
// инициализация кнопок Level
        TextButton level_1_Button = new TextButton("01", BaseGame.textButtonStyleLevel);
        level_1_Button.setColor(Color.GREEN);
        uiStage.addActor(level_1_Button);
        TextButton level_2_Button = new TextButton("02", BaseGame.textButtonStyleLevel);
        level_2_Button.setColor(Color.GREEN);
        uiStage.addActor(level_2_Button);
        TextButton level_3_Button = new TextButton("03", BaseGame.textButtonStyleLevel);
        level_3_Button.setColor(Color.RED);
        uiStage.addActor(level_3_Button);
        TextButton level_4_Button = new TextButton("04", BaseGame.textButtonStyleLevel);
        level_4_Button.setColor(Color.RED);
        uiStage.addActor(level_4_Button);
        TextButton level_5_Button = new TextButton("05", BaseGame.textButtonStyleLevel);
        level_5_Button.setColor(Color.RED);
        uiStage.addActor(level_5_Button);

        TextButton level_6_Button = new TextButton("06", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_6_Button);
        TextButton level_7_Button = new TextButton("07", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_7_Button);
        TextButton level_8_Button = new TextButton("08", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_8_Button);
        TextButton level_9_Button = new TextButton("09", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_9_Button);
        TextButton level_10_Button = new TextButton("10", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_10_Button);

        TextButton level_11_Button = new TextButton("11", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_11_Button);
        TextButton level_12_Button = new TextButton("12", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_12_Button);
        TextButton level_13_Button = new TextButton("13", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_13_Button);
        TextButton level_14_Button = new TextButton("14", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_14_Button);
        TextButton level_15_Button = new TextButton("15", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_15_Button);

        TextButton level_16_Button = new TextButton("16", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_16_Button);
        TextButton level_17_Button = new TextButton("17", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_17_Button);
        TextButton level_18_Button = new TextButton("18", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_18_Button);
        TextButton level_19_Button = new TextButton("19", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_19_Button);
        TextButton level_20_Button = new TextButton("20", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_20_Button);

        TextButton level_21_Button = new TextButton("21", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_21_Button);
        TextButton level_22_Button = new TextButton("22", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_22_Button);
        TextButton level_23_Button = new TextButton("23", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_23_Button);
        TextButton level_24_Button = new TextButton("24", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_24_Button);
        TextButton level_25_Button = new TextButton("25", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_25_Button);

        TextButton level_26_Button = new TextButton("26", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_26_Button);
        TextButton level_27_Button = new TextButton("27", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_27_Button);
        TextButton level_28_Button = new TextButton("28", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_28_Button);
        TextButton level_29_Button = new TextButton("29", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_29_Button);
        TextButton level_30_Button = new TextButton("30", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_30_Button);

        level_1_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
                        RectangleGame.setActiveScreen(new LevelScreen_1(requestHandler));
                        return false;
                    }
                }
        );

        level_2_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
                        RectangleGame.setActiveScreen(new LevelScreen_2(requestHandler));
                        return false;
                    }
                }
        );

        level_3_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_3(requestHandler));
                        return false;
                    }
                }
        );

        level_4_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_4(requestHandler));
                        return false;
                    }
                }
        );

        level_5_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_5(requestHandler));
                        return false;
                    }
                }
        );

        level_6_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_6(requestHandler));
                        //Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        level_7_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_7(requestHandler));
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        level_8_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_8(requestHandler));
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        level_9_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_9(requestHandler));
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        level_10_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_10(requestHandler));
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        level_11_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        RectangleGame.setActiveScreen(new LevelScreen_11(requestHandler));
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        // устанавливает фоновую картинку в Table
        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("background/fon_level_4.png")),
                3, 3, 3, 3);
        NinePatchDrawable background = new NinePatchDrawable(patch);
        // устанавливает фоновую картинку в Table(конец)

        uiTable.setBackground(background);
        uiTable.add(level_1_Button).pad(15,15,15,15);
        uiTable.add(level_2_Button).pad(15,15,15,15);
        uiTable.add(level_3_Button).pad(15,15,15,15);
        uiTable.add(level_4_Button).pad(15,15,15,15);
        uiTable.add(level_5_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_6_Button).pad(15,15,15,15);
        uiTable.add(level_7_Button).pad(15,15,15,15);
        uiTable.add(level_8_Button).pad(15,15,15,15);
        uiTable.add(level_9_Button).pad(15,15,15,15);
        uiTable.add(level_10_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_11_Button).pad(15,15,15,15);
        uiTable.add(level_12_Button).pad(15,15,15,15);
        uiTable.add(level_13_Button).pad(15,15,15,15);
        uiTable.add(level_14_Button).pad(15,15,15,15);
        uiTable.add(level_15_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_16_Button).pad(15,15,15,15);
        uiTable.add(level_17_Button).pad(15,15,15,15);
        uiTable.add(level_18_Button).pad(15,15,15,15);
        uiTable.add(level_19_Button).pad(15,15,15,15);
        uiTable.add(level_20_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_21_Button).pad(15,15,15,15);
        uiTable.add(level_22_Button).pad(15,15,15,15);
        uiTable.add(level_23_Button).pad(15,15,15,15);
        uiTable.add(level_24_Button).pad(15,15,15,15);
        uiTable.add(level_25_Button).pad(15,15,15,15);
        uiTable.row();
        uiTable.add(level_26_Button).pad(15,15,15,15);
        uiTable.add(level_27_Button).pad(15,15,15,15);
        uiTable.add(level_28_Button).pad(15,15,15,15);
        uiTable.add(level_29_Button).pad(15,15,15,15);
        uiTable.add(level_30_Button).pad(15,15,15,15);
    }

    @Override
    public void update(float var1) {

    }
}
