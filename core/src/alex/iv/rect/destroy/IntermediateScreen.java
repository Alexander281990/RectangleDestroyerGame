package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.actors.Background;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.MenuScreen;
import alex.iv.rect.destroy.controller.RectangleGame;

public class IntermediateScreen extends LevelScreenMain {

    private float windowPlayWidth;
    private float windowPlayHeight;
    private int numberLev;
    private Label Live; // метка, которая отображает жизни
    private Label timeIsUp; // метка, которая отображает конец времени
    private Label level; // метка, которая отображает номер уровня
    private Label records;
    private Label results;

    public IntermediateScreen(IActivityRequestHandler requestHandler, int numberLevel, int interScore){
        super(requestHandler);
        numberLev = numberLevel;
        level.setText("Level : " + numberLevel);
        switch (numberLevel) {
            case 1:
                records.setText("Record = " + recordsLevel_1);
                results.setText("Your score = " + interScore);
                break;
            case 2:
                records.setText("Record = " + recordsLevel_2);
                results.setText("Your score = " + interScore);
                break;
            case 3:
                records.setText("Record = " + recordsLevel_3);
                results.setText("Your score = " + interScore);
                break;
            case 4:
                records.setText("Record = " + recordsLevel_4);
                results.setText("Your score = " + interScore);
                break;
            case 5:
                records.setText("Record = " + recordsLevel_5);
                results.setText("Your score = " + interScore);
                break;
            case 6:
                records.setText("Record = " + recordsLevel_6);
                results.setText("Your score = " + interScore);
                break;
            case 7:
                records.setText("Record = " + recordsLevel_7);
                results.setText("Your score = " + interScore);
                break;
            case 8:
                records.setText("Record = " + recordsLevel_8);
                results.setText("Your score = " + interScore);
                break;
            case 9:
                records.setText("Record = " + recordsLevel_9);
                results.setText("Your score = " + interScore);
                break;
            case 10:
                records.setText("Record = " + recordsLevel_10);
                results.setText("Your score = " + interScore);
                break;
            case 11:
                records.setText("Record = " + recordsLevel_11);
                results.setText("Your score = " + interScore);
                break;
            case 12:
                records.setText("Record = " + recordsLevel_12);
                results.setText("Your score = " + interScore);
                break;
            case 13:
                records.setText("Record = " + recordsLevel_13);
                results.setText("Your score = " + interScore);
                break;
            case 14:
                records.setText("Record = " + recordsLevel_14);
                results.setText("Your score = " + interScore);
                break;
            case 15:
                records.setText("Record = " + recordsLevel_15);
                results.setText("Your score = " + interScore);
                break;
            case 16:
                records.setText("Record = " + recordsLevel_16);
                results.setText("Your score = " + interScore);
                break;
            case 17:
                records.setText("Record = " + recordsLevel_17);
                results.setText("Your score = " + interScore);
                break;
            case 18:
                records.setText("Record = " + recordsLevel_18);
                results.setText("Your score = " + interScore);
                break;
            case 19:
                records.setText("Record = " + recordsLevel_19);
                results.setText("Your score = " + interScore);
                break;
            case 20:
                records.setText("Record = " + recordsLevel_20);
                results.setText("Your score = " + interScore);
                break;
            case 21:
                records.setText("Record = " + recordsLevel_21);
                results.setText("Your score = " + interScore);
                break;
            case 22:
                records.setText("Record = " + recordsLevel_22);
                results.setText("Your score = " + interScore);
                break;
            case 23:
                records.setText("Record = " + recordsLevel_23);
                results.setText("Your score = " + interScore);
                break;
            case 24:
                records.setText("Record = " + recordsLevel_24);
                results.setText("Your score = " + interScore);
                break;
            case 25:
                records.setText("Record = " + recordsLevel_25);
                results.setText("Your score = " + interScore);
                break;
            case 26:
                records.setText("Record = " + recordsLevel_26);
                results.setText("Your score = " + interScore);
                break;
            case 27:
                records.setText("Record = " + recordsLevel_27);
                results.setText("Your score = " + interScore);
                break;
            case 28:
                records.setText("Record = " + recordsLevel_28);
                results.setText("Your score = " + interScore);
                break;
            case 29:
                records.setText("Record = " + recordsLevel_29);
                results.setText("Your score = " + interScore);
                break;
            case 30:
                records.setText("Record = " + recordsLevel_30);
                results.setText("Your score = " + interScore);
                break;
            default:records.setText("Record = " + 0);
        }
        //this.requestHandler=requestHandler;
        requestHandler.showBannerAd(); // при запуске IntermediateScreen запускается рекламный банер в нижней части экрана
    }

    public void initialize() {
        windowPlayWidth = Gdx.graphics.getWidth();
        windowPlayHeight = Gdx.graphics.getHeight() / 2f - 100;
        new Background(0, 0, mainStage);

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
        // инициализация метки для отображения жизней
        Live = new Label("Live:", BaseGame.labelStyle);
        uiStage.addActor(Live);
        Live.setText("Live: " + live);
        // инициализация метки для отображения жизней(конец)
        // инициализация метки для отображения конца рабочего времени
        timeIsUp = new Label("timeIsUp", BaseGame.labelStyleLevel);
        uiStage.addActor(timeIsUp);
        timeIsUp.setText("Time Is Up");
        // инициализация метки для отображения конца рабочего времени(конец)
        level = new Label("Level" , BaseGame.labelStyleLevel);
        uiStage.addActor(level);

        records = new Label("Record", BaseGame.labelStyleLevel);
        uiStage.addActor(records);

        results = new Label("Your score" , BaseGame.labelStyleLevel);
        uiStage.addActor(results);

        TextButton exitButton = new TextButton( "EXIT", BaseGame.textButtonStyle );
        uiStage.addActor(exitButton);
        exitButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                          Gdx.app.exit(); // выходит из игры
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

        TextButton restartButton = new TextButton( "RESTART", BaseGame.textButtonStyle );
        uiStage.addActor(restartButton);
        restartButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        switch (numberLev) {
                            case 1:
                                RectangleGame.setActiveScreen(new LevelScreen_1(requestHandler));
                                break;
                            case 2:
                                RectangleGame.setActiveScreen(new LevelScreen_2(requestHandler));
                                break;
                            case 3:
                                RectangleGame.setActiveScreen(new LevelScreen_3(requestHandler));
                                break;
                            case 4:
                                RectangleGame.setActiveScreen(new LevelScreen_4(requestHandler));
                                break;
                            case 5:
                                RectangleGame.setActiveScreen(new LevelScreen_5(requestHandler));
                                break;
                            case 6:
                                RectangleGame.setActiveScreen(new LevelScreen_6(requestHandler));
                                break;
                            case 7:
                                RectangleGame.setActiveScreen(new LevelScreen_7(requestHandler));
                                break;
                            case 8:
                                RectangleGame.setActiveScreen(new LevelScreen_8(requestHandler));
                                break;
                            case 9:
                                RectangleGame.setActiveScreen(new LevelScreen_9(requestHandler));
                                break;
                            case 10:
                                RectangleGame.setActiveScreen(new LevelScreen_10(requestHandler));
                                break;
                            case 11:
                                RectangleGame.setActiveScreen(new LevelScreen_11(requestHandler));
                                break;
                            case 12:
                                RectangleGame.setActiveScreen(new LevelScreen_12(requestHandler));
                                break;
                            case 13:
                                RectangleGame.setActiveScreen(new LevelScreen_13(requestHandler));
                                break;
                            case 14:
                                RectangleGame.setActiveScreen(new LevelScreen_14(requestHandler));
                                break;
                            case 15:
                                RectangleGame.setActiveScreen(new LevelScreen_15(requestHandler));
                                break;
                            case 16:
                                RectangleGame.setActiveScreen(new LevelScreen_16(requestHandler));
                                break;
                            case 17:
                                RectangleGame.setActiveScreen(new LevelScreen_17(requestHandler));
                                break;
                            case 18:
                                RectangleGame.setActiveScreen(new LevelScreen_18(requestHandler));
                                break;
                            case 19:
                                RectangleGame.setActiveScreen(new LevelScreen_19(requestHandler));
                                break;
                            case 20:
                                RectangleGame.setActiveScreen(new LevelScreen_20(requestHandler));
                                break;
                            case 21:
                                RectangleGame.setActiveScreen(new LevelScreen_21(requestHandler));
                                break;
                            case 22:
                                RectangleGame.setActiveScreen(new LevelScreen_22(requestHandler));
                                break;
                            case 23:
                                RectangleGame.setActiveScreen(new LevelScreen_23(requestHandler));
                                break;
                            case 24:
                                RectangleGame.setActiveScreen(new LevelScreen_24(requestHandler));
                                break;
                            case 25:
                                RectangleGame.setActiveScreen(new LevelScreen_25(requestHandler));
                                break;
                            case 26:
                                RectangleGame.setActiveScreen(new LevelScreen_26(requestHandler));
                                break;
                            case 27:
                                RectangleGame.setActiveScreen(new LevelScreen_27(requestHandler));
                                break;
                            case 28:
                                RectangleGame.setActiveScreen(new LevelScreen_28(requestHandler));
                                break;
                            case 29:
                                RectangleGame.setActiveScreen(new LevelScreen_29(requestHandler));
                                break;
                            case 30:
                                RectangleGame.setActiveScreen(new LevelScreen_30(requestHandler));
                                break;

                        }
                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
//                        Gdx.app.log("MyTag", "my informative message");
                        return false;
                    }
                }
        );

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

        // устанавливает фоновый цвет в Table
        Pixmap bgPixmap = new Pixmap(1,1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Color.RED);
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        // устанавливает фоновый цвет в Table(конец)

//        // устанавливает фоновую картинку в Table
//        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("background/fon_intermediate_screen.png")),
//                3, 3, 3, 3);
//        NinePatchDrawable background = new NinePatchDrawable(patch);
//        // устанавливает фоновую картинку в Table(конец)

//        //uiTable.setDebug(true); // рисует границы ячеек и виджетов для Table(удобно для отладки)
//        uiTable.setBackground(background);
        uiTable.align(Align.center|Align.top);
        uiTable.add(exitButton).expandX().left().padTop(20).padLeft(20);
        uiTable.add(Live).expandX().right().top().padTop(20).padRight(20);
        uiTable.row();
        uiTable.add(level).colspan(2);
        uiTable.row();
        uiTable.add(timeIsUp).colspan(2).padTop(timeIsUp.getHeight()*2).bottom();
        uiTable.row();
        uiTable.add(records).colspan(2).padTop(records.getHeight());
        uiTable.row();
        uiTable.add(results).colspan(2).padBottom(results.getHeight()*2).padTop(results.getHeight());
        uiTable.row();
        uiTable.add(restartButton);
        uiTable.add(menuButton);
        uiTable.row();

    }

    public void update(float dt) {

    }
}
