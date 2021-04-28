package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.MenuScreen;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.StartScreen;

public class IntermediateScreen extends LevelScreenMain {

    private float windowPlayWidth;
    private float windowPlayHeight;
    public IActivityRequestHandler requestHandler;
    private int numberLev;
    private Label Live; // метка, которая отображает жизни
    private Label timeIsUp; // метка, которая отображает конец времени
    private Label level; // метка, которая отображает номер уровня
    private Label records;
    private Label results;

    public IntermediateScreen(IActivityRequestHandler requestHandler, int numberLevel, int interScore){
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
            default:records.setText("Record = " + 0);
        }
        this.requestHandler=requestHandler;
        requestHandler.showBannerAd(); // при запуске IntermediateScreen запускается рекламный банер в нижней части экрана
    }

    public void initialize() {
        windowPlayWidth = Gdx.graphics.getWidth();
        windowPlayHeight = Gdx.graphics.getHeight() / 2 - 100;

        recordsLevel_1 = pref.getInteger("records_1");
        recordsLevel_2 = pref.getInteger("records_2");
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
        // инициализация кнопок New game и continue(конец)

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
                        }
                        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
//                        Gdx.app.log("MyTag", "my informative message");
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

        // устанавливает фоновый цвет в Table
        Pixmap bgPixmap = new Pixmap(1,1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Color.RED);
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        // устанавливает фоновый цвет в Table(конец)

        // устанавливает фоновую картинку в Table
        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("space.png")),
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
