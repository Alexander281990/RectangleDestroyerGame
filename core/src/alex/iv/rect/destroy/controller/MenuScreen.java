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
import alex.iv.rect.destroy.LevelScreen_12;
import alex.iv.rect.destroy.LevelScreen_13;
import alex.iv.rect.destroy.LevelScreen_14;
import alex.iv.rect.destroy.LevelScreen_15;
import alex.iv.rect.destroy.LevelScreen_16;
import alex.iv.rect.destroy.LevelScreen_17;
import alex.iv.rect.destroy.LevelScreen_18;
import alex.iv.rect.destroy.LevelScreen_2;
import alex.iv.rect.destroy.LevelScreen_3;
import alex.iv.rect.destroy.LevelScreen_4;
import alex.iv.rect.destroy.LevelScreen_5;
import alex.iv.rect.destroy.LevelScreen_6;
import alex.iv.rect.destroy.LevelScreen_7;
import alex.iv.rect.destroy.LevelScreen_8;
import alex.iv.rect.destroy.LevelScreen_9;
import alex.iv.rect.destroy.actors.Lock;

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

        Lock lock1 = new Lock(0, 0, mainStage);
        Lock lock2 = new Lock(0, 0, mainStage);
        Lock lock3 = new Lock(0, 0, mainStage);
        Lock lock4 = new Lock(0, 0, mainStage);
        Lock lock5 = new Lock(0, 0, mainStage);
        Lock lock6 = new Lock(0, 0, mainStage);
        Lock lock7 = new Lock(0, 0, mainStage);
        Lock lock8 = new Lock(0, 0, mainStage);
        Lock lock9 = new Lock(0, 0, mainStage);
        Lock lock10 = new Lock(0, 0, mainStage);
        Lock lock11 = new Lock(0, 0, mainStage);
        Lock lock12 = new Lock(0, 0, mainStage);
        Lock lock13 = new Lock(0, 0, mainStage);
        Lock lock14 = new Lock(0, 0, mainStage);
        Lock lock15 = new Lock(0, 0, mainStage);
        Lock lock16 = new Lock(0, 0, mainStage);
        Lock lock17 = new Lock(0, 0, mainStage);
        Lock lock18 = new Lock(0, 0, mainStage);

        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне

        levelScreenMain = new LevelScreenMain(requestHandler);
// инициализация кнопок Level
        TextButton level_1_Button = new TextButton("01", BaseGame.textButtonStyleLevel);
        //level_1_Button.setColor(Color.RED);
        uiStage.addActor(level_1_Button);
        TextButton level_2_Button = new TextButton("02", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_2_Button);
        TextButton level_3_Button = new TextButton("03", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_3_Button);
        TextButton level_4_Button = new TextButton("04", BaseGame.textButtonStyleLevel);
        uiStage.addActor(level_4_Button);
        TextButton level_5_Button = new TextButton("05", BaseGame.textButtonStyleLevel);
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
                        if (attainment >= 0) {
                            RectangleGame.setActiveScreen(new LevelScreen_1(requestHandler));
                        }
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
                        if (attainment >= 1) {
                            RectangleGame.setActiveScreen(new LevelScreen_2(requestHandler));
                        }
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
                        if (attainment >= 2) {
                            RectangleGame.setActiveScreen(new LevelScreen_3(requestHandler));
                        }
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
                        if (attainment >= 3) {
                            RectangleGame.setActiveScreen(new LevelScreen_4(requestHandler));
                        }
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
                        if (attainment >= 4) {
                            RectangleGame.setActiveScreen(new LevelScreen_5(requestHandler));
                        }
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
                        if (attainment >= 5) {
                            RectangleGame.setActiveScreen(new LevelScreen_6(requestHandler));
                        }
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
                        if (attainment >= 6) {
                            RectangleGame.setActiveScreen(new LevelScreen_7(requestHandler));
                        }
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
                        if (attainment >= 7) {
                            RectangleGame.setActiveScreen(new LevelScreen_8(requestHandler));
                        }
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
                        if (attainment >= 8) {
                            RectangleGame.setActiveScreen(new LevelScreen_9(requestHandler));
                        }
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
                        if (attainment >= 9) {
                            RectangleGame.setActiveScreen(new LevelScreen_10(requestHandler));
                        }
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
                        if (attainment >= 10) {
                            RectangleGame.setActiveScreen(new LevelScreen_11(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_12_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 11) {
                            RectangleGame.setActiveScreen(new LevelScreen_12(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_13_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 12) {
                            RectangleGame.setActiveScreen(new LevelScreen_13(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_14_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 13) {
                            RectangleGame.setActiveScreen(new LevelScreen_14(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_15_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 14) {
                            RectangleGame.setActiveScreen(new LevelScreen_15(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_16_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 15) {
                            RectangleGame.setActiveScreen(new LevelScreen_16(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_17_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 16) {
                            RectangleGame.setActiveScreen(new LevelScreen_17(requestHandler));
                        }
                        return false;
                    }
                }
        );

        level_18_Button.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (attainment >= 17) {
                            RectangleGame.setActiveScreen(new LevelScreen_18(requestHandler));
                        }
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

        level_1_Button.addActor(lock1);
        lock1.setPosition(level_1_Button.getWidth() / 2 - lock1.getWidth() / 2, level_1_Button.getHeight() / 2 - lock1.getHeight() / 2);
        level_3_Button.addActor(lock3);
        lock3.setPosition(level_3_Button.getWidth() / 2 - lock3.getWidth() / 2, level_3_Button.getHeight() / 2 - lock3.getHeight() / 2);
        level_2_Button.addActor(lock2);
        lock2.setPosition(level_2_Button.getWidth() / 2 - lock2.getWidth() / 2, level_2_Button.getHeight() / 2 - lock2.getHeight() / 2);
        level_4_Button.addActor(lock4);
        lock4.setPosition(level_4_Button.getWidth() / 2 - lock4.getWidth() / 2, level_4_Button.getHeight() / 2 - lock4.getHeight() / 2);
        level_5_Button.addActor(lock5);
        lock5.setPosition(level_5_Button.getWidth() / 2 - lock5.getWidth() / 2, level_5_Button.getHeight() / 2 - lock5.getHeight() / 2);
        level_6_Button.addActor(lock6);
        lock6.setPosition(level_6_Button.getWidth() / 2 - lock6.getWidth() / 2, level_6_Button.getHeight() / 2 - lock6.getHeight() / 2);
        level_7_Button.addActor(lock7);
        lock7.setPosition(level_7_Button.getWidth() / 2 - lock7.getWidth() / 2, level_7_Button.getHeight() / 2 - lock7.getHeight() / 2);
        level_8_Button.addActor(lock8);
        lock8.setPosition(level_8_Button.getWidth() / 2 - lock8.getWidth() / 2, level_8_Button.getHeight() / 2 - lock8.getHeight() / 2);
        level_9_Button.addActor(lock9);
        lock9.setPosition(level_9_Button.getWidth() / 2 - lock9.getWidth() / 2, level_9_Button.getHeight() / 2 - lock9.getHeight() / 2);
        level_10_Button.addActor(lock10);
        lock10.setPosition(level_10_Button.getWidth() / 2 - lock10.getWidth() / 2, level_10_Button.getHeight() / 2 - lock10.getHeight() / 2);
        level_11_Button.addActor(lock11);
        lock11.setPosition(level_11_Button.getWidth() / 2 - lock11.getWidth() / 2, level_11_Button.getHeight() / 2 - lock11.getHeight() / 2);
        level_12_Button.addActor(lock12);
        lock12.setPosition(level_12_Button.getWidth() / 2 - lock12.getWidth() / 2, level_12_Button.getHeight() / 2 - lock12.getHeight() / 2);
        level_13_Button.addActor(lock13);
        lock13.setPosition(level_13_Button.getWidth() / 2 - lock13.getWidth() / 2, level_13_Button.getHeight() / 2 - lock13.getHeight() / 2);
        level_14_Button.addActor(lock14);
        lock14.setPosition(level_14_Button.getWidth() / 2 - lock14.getWidth() / 2, level_14_Button.getHeight() / 2 - lock14.getHeight() / 2);
        level_15_Button.addActor(lock15);
        lock15.setPosition(level_15_Button.getWidth() / 2 - lock15.getWidth() / 2, level_15_Button.getHeight() / 2 - lock15.getHeight() / 2);
        level_16_Button.addActor(lock16);
        lock16.setPosition(level_16_Button.getWidth() / 2 - lock16.getWidth() / 2, level_16_Button.getHeight() / 2 - lock16.getHeight() / 2);
        level_17_Button.addActor(lock17);
        lock17.setPosition(level_17_Button.getWidth() / 2 - lock17.getWidth() / 2, level_17_Button.getHeight() / 2 - lock17.getHeight() / 2);
        level_18_Button.addActor(lock18);
        lock18.setPosition(level_18_Button.getWidth() / 2 - lock18.getWidth() / 2, level_18_Button.getHeight() / 2 - lock18.getHeight() / 2);


        Gdx.app.log("MyTag", String.valueOf(attainment));

        switch (attainment) {
            case 0:
                lock1.remove();
                break;
            case 1:
                lock1.remove();
                lock2.remove();
                break;
            case 2:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                break;
            case 3:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                break;
            case 4:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                break;
            case 5:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                break;
            case 6:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                break;
            case 7:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                break;
            case 8:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                break;
            case 9:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                break;
            case 10:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                break;
            case 11:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                break;
            case 12:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                break;
            case 13:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                break;
            case 14:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                break;
            case 15:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                break;
            case 16:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                break;
            case 17:
                lock1.remove();
                lock2.remove();
                lock3.remove();
                lock4.remove();
                lock5.remove();
                lock6.remove();
                lock7.remove();
                lock8.remove();
                lock9.remove();
                lock10.remove();
                lock11.remove();
                lock12.remove();
                lock13.remove();
                lock14.remove();
                lock15.remove();
                lock16.remove();
                lock17.remove();
                lock18.remove();
                break;
            default:
        }

        if (attainmentColorLevel_1 == 0) {
            level_1_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_1 == 1) {
                level_1_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_2 == 0) {
            level_2_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_2 == 1) {
                level_2_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_3 == 0) {
            level_3_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_3 == 1) {
                level_3_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_4 == 0) {
            level_4_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_4 == 1) {
                level_4_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_5 == 0) {
            level_5_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_5 == 1) {
                level_5_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_6 == 0) {
            level_6_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_6 == 1) {
                level_6_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_7 == 0) {
            level_7_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_7 == 1) {
                level_7_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_8 == 0) {
            level_8_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_8 == 1) {
                level_8_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_9 == 0) {
            level_9_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_9 == 1) {
                level_9_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_10 == 0) {
            level_10_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_10 == 1) {
                level_10_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_11 == 0) {
            level_11_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_11 == 1) {
                level_11_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_12 == 0) {
            level_12_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_12 == 1) {
                level_12_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_13 == 0) {
            level_13_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_13 == 1) {
                level_13_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_14 == 0) {
            level_14_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_14 == 1) {
                level_14_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_15 == 0) {
            level_15_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_15 == 1) {
                level_15_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_16 == 0) {
            level_16_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_16 == 1) {
                level_16_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_17 == 0) {
            level_17_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_17 == 1) {
                level_17_Button.setColor(Color.GREEN);
            }
        }

        if (attainmentColorLevel_18 == 0) {
            level_18_Button.setColor(Color.RED);
        } else {
            if (attainmentColorLevel_18 == 1) {
                level_18_Button.setColor(Color.GREEN);
            }
        }

    }

    @Override
    public void update(float var1) {

    }
}
