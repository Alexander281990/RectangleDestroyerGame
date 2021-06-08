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
            default:records.setText("Record = " + 0);
        }
        //this.requestHandler=requestHandler;
        requestHandler.showBannerAd(); // при запуске IntermediateScreen запускается рекламный банер в нижней части экрана
    }

    public void initialize() {
        windowPlayWidth = Gdx.graphics.getWidth();
        windowPlayHeight = Gdx.graphics.getHeight() / 2f - 100;

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

        // устанавливает фоновую картинку в Table
        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("background/fon_intermediate_screen.png")),
                3, 3, 3, 3);
        NinePatchDrawable background = new NinePatchDrawable(patch);
        // устанавливает фоновую картинку в Table(конец)

        //uiTable.setDebug(true); // рисует границы ячеек и виджетов для Table(удобно для отладки)
        uiTable.setBackground(background);
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
