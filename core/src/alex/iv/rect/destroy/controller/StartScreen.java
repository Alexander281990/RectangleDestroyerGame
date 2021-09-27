package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import alex.iv.rect.destroy.actors.BallsIcon;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;

import static alex.iv.rect.destroy.controller.BaseActor.getScreenSizeInches;


public class StartScreen extends BaseScreen {

    private Sound clickButton;
    private static Preferences pref;
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

        BaseActor.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 13;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 100;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage);
                brick.setTimeBrick(3);
                if (rowNum == 4 || rowNum == 5 || rowNum == 6 ||  rowNum == 7 || rowNum == 8) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 6 ||
                        rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9 || rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 3 ||
                        rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 8 || rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 3 ||
                        rowNum == 11 && colNum == 6 || rowNum == 11 && colNum == 8 || rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 1 ||
                        rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 6 || rowNum == 12 && colNum == 8 || rowNum == 12 && colNum == 9 ||
                        rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5 ||
                        rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 9 || rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 2 ||
                        rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 9 ||
                        rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 8 ||
                        rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 6 || rowNum == 9 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 5 || rowNum == 0 && colNum == 7 ||
                        rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 12 && colNum == 7) {
                    brick.setColor(Color.RED);
                    brick.setBrickMoving(false);
                }
                if (rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 8) {
                    brick.setColor(Color.BLUE);
                }
                if (rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 ||
                        rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 9 || rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 2 ||
                        rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.setBrickFlash(false, false); // инициализация метода смены цветов кирпича
                }
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 5 ||
                        rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 9 || rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 2 ||
                        rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 9) {
                    brick.setColor(Color.YELLOW);
                    brick.setBrickFlash(false); // инициализация метода смены цветов кирпича
                }
                if (rowNum == 6){
                    Action spin_1 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
                    brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard
                }
            }
        }

        BallsIcon ballIconCrazy = new BallsIcon(0, 0, mainStage);
        ballIconCrazy.loadTexture("crazy_ball_origin_size.png");
        if (getScreenSizeInches() <= 5.7) {
            ballIconCrazy.setSize(ballIconCrazy.getWidth()/3.5f, ballIconCrazy.getHeight()/3.5f);
        } else if (getScreenSizeInches() > 5.7 && getScreenSizeInches() <= 6.1 ) {
            ballIconCrazy.setSize(ballIconCrazy.getWidth()/4, ballIconCrazy.getHeight()/4);
        } else if (getScreenSizeInches() > 6.1 && getScreenSizeInches() <= 7 ) {
            ballIconCrazy.setSize(ballIconCrazy.getWidth()/4.5f, ballIconCrazy.getHeight()/4.5f);
        } else if (getScreenSizeInches() > 7 && getScreenSizeInches() <= 8 ) { // планшет 1280/800
            ballIconCrazy.setSize(ballIconCrazy.getWidth()/5, ballIconCrazy.getHeight()/5);
        }
        ballIconCrazy.setPosition(Gdx.graphics.getWidth() - ballIconCrazy.getWidth() - 25, 25);

        BallsIcon ballIconFunny = new BallsIcon(0, 0, mainStage);
        ballIconFunny.loadTexture("fun_ball.png");
        if (getScreenSizeInches() <= 5.7) {
            ballIconFunny.setSize(ballIconFunny.getWidth()/4.55f, ballIconFunny.getHeight()/4.55f);
        } else if (getScreenSizeInches() > 5.7 && getScreenSizeInches() <= 6.1 ) {
            ballIconFunny.setSize(ballIconFunny.getWidth()/5.2f, ballIconFunny.getHeight()/5.2f);
        } else if (getScreenSizeInches() > 6.1 && getScreenSizeInches() <= 7 ) {
            ballIconFunny.setSize(ballIconFunny.getWidth()/5.85f, ballIconFunny.getHeight()/5.85f);
        } else if (getScreenSizeInches() > 7 && getScreenSizeInches() <= 8 ) { // планшет 1280/800
            ballIconFunny.setSize(ballIconFunny.getWidth()/6.5f, ballIconFunny.getHeight()/6.5f);
        }
        ballIconFunny.setPosition(ballIconFunny.getWidth()/3, ballIconFunny.getHeight());

        clickButton = Gdx.audio.newSound(Gdx.files.internal("click_button.wav"));
        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне
        attainment = pref.getInteger("attainmentMemory");
        // инициализация кнопок New game и continue
        TextButton startButton = new TextButton( "New game", BaseGame.textButtonStyleStartScreen );
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
                        attainment = 1;
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
                        pref.flush();
                        clickButton.play();
                        RectangleGame.setActiveScreen(new MenuScreen(requestHandler));
                        return false;
                    }
                }
        );

        TextButton continueButton = new TextButton( "Continue", BaseGame.textButtonStyleStartScreen );
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
                        //RectangleGame.setActiveScreen(new VictoryScreen());
                        return false;
                    }
                }
        );
        // инициализация кнопок New game и continue(конец)

        if (attainment != 0) {
            uiTable.add(startButton);
            uiTable.row();
            uiTable.add().size(startButton.getWidth(), startButton.getHeight()/3);
            uiTable.row();
            uiTable.add(continueButton);
        } else {
            uiTable.add(startButton);
        }

        //Gdx.app.log("MyTag", String.valueOf(attainment));

    }

    @Override
    public void update(float dt) {

    }
}