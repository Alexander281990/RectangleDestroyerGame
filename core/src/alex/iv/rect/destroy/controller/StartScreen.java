package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.actors.Background;
import alex.iv.rect.destroy.actors.BallsIcon;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;

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

    private Texture newGameButtonTexture, continueButtonTexture;
    private TextureRegion newGameButtonTextureRegion, continueButtonTextureRegion;
    private TextureRegionDrawable newGameButtonTexRegionDrawable, continueButtonTexRegionDrawable;

    public IActivityRequestHandler requestHandler;

    public StartScreen(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public StartScreen() {
    }

    @Override
    public void initialize() {

        new Background(0, 0, mainStage);
        Item item_1 = new Item(0, 0, mainStage, true);
        item_1.loadTexture("items/live.png");
        Item item_2 = new Item(0, 0, mainStage, true);
        item_2.loadTexture("items/paddle-shrink.png");
        Item item_3 = new Item(0, 0, mainStage, true);
        item_3.loadTexture("items/paddle-stop.png");
        Item item_4 = new Item(0, 0, mainStage, true);
        item_4.loadTexture("items/increase-time.png");
        Item item_5 = new Item(0, 0, mainStage, true);
        item_5.loadTexture("items/ball-two.png");
        BallsIcon ballIconCrazy = new BallsIcon(0, 0, mainStage);
        ballIconCrazy.loadTexture("crazy_ball_origin_size.png");
        BallsIcon ballIconFunny = new BallsIcon(0, 0, mainStage);
        ballIconFunny.loadTexture("fun_ball.png");
        BaseActor paddleTransformation = new BaseActor(0, 0, mainStage);
        paddleTransformation.loadTexture("paddle_transformation.png");
        BaseActor quickBall = new BaseActor(0, 0, mainStage);
        quickBall.loadTexture("quick_ball.png");

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

        clickButton = Gdx.audio.newSound(Gdx.files.internal("click_button.wav"));
        pref = Gdx.app.getPreferences("Preferences");// инициализация Preferences для сохранения лучшего результата в телефоне
        attainment = pref.getInteger("attainmentMemory");
        // инициализация кнопок New game и continue
        newGameButtonTexture = new Texture(Gdx.files.internal("new_game_button.png"));
        newGameButtonTextureRegion = new TextureRegion(newGameButtonTexture);
        newGameButtonTexRegionDrawable = new TextureRegionDrawable(newGameButtonTextureRegion);
        Button startButton = new Button(newGameButtonTexRegionDrawable);
        //TextButton startButton = new TextButton( "New game", BaseGame.textButtonStyleStartScreen );
        startButton.setSize(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/15f);
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

        continueButtonTexture = new Texture(Gdx.files.internal("continue_button.png"));
        continueButtonTextureRegion = new TextureRegion(continueButtonTexture);
        continueButtonTexRegionDrawable = new TextureRegionDrawable(continueButtonTextureRegion);
        Button continueButton = new Button(continueButtonTexRegionDrawable);
        //TextButton continueButton = new TextButton( "Continue", BaseGame.textButtonStyleStartScreen );
        continueButton.setSize(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/15f);
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
            uiStage.addActor(startButton);
            startButton.setPosition(Gdx.graphics.getWidth()/2f-startButton.getWidth()/2f,
                    (Gdx.graphics.getHeight() - (Gdx.graphics.getHeight()-marginY)) - startButton.getHeight()*1.5f);
            /////
            uiStage.addActor(continueButton);
            continueButton.setPosition(Gdx.graphics.getWidth()/2f-startButton.getWidth()/2f,
                    startButton.getY() - continueButton.getHeight()*1.2f);
            /////
            uiStage.addActor(item_1);
            item_1.setSize(startButton.getHeight(), startButton.getHeight());
            item_1.setRotation(15f);
            item_1.setPosition(startButton.getX()/4f, startButton.getY()+20f);
            /////
            uiStage.addActor(item_2);
            item_2.setSize(startButton.getHeight()/1.2f, startButton.getHeight()/1.2f);
            item_2.setPosition(Gdx.graphics.getWidth()-startButton.getX()/2f - item_2.getWidth()/2f,
                    continueButton.getY()+continueButton.getHeight());
            /////
            uiStage.addActor(ballIconCrazy);
            ballIconCrazy.setSize(continueButton.getHeight()*3, continueButton.getHeight()*3);
            ballIconCrazy.setPosition(Gdx.graphics.getWidth() - ballIconCrazy.getWidth() - 25, 25);
            /////
            uiStage.addActor(ballIconFunny);
            ballIconFunny.setSize(continueButton.getHeight()*2, continueButton.getHeight()*2);
            ballIconFunny.setPosition(ballIconFunny.getWidth()/3, ballIconCrazy.getY()+ballIconCrazy.getHeight());
            /////
            uiStage.addActor(item_3);
            item_3.setSize(startButton.getHeight()/1.5f, startButton.getHeight()/1.5f);
            item_3.setPosition(continueButton.getX() - item_3.getWidth(),
                    continueButton.getY() - item_3.getHeight() - item_3.getHeight()/2);
            uiStage.addActor(item_4);
            item_4.setSize(startButton.getHeight(), startButton.getHeight());
            item_4.setRotation(-5f);
            item_4.setPosition(continueButton.getX() + (item_4.getWidth()/2), continueButton.getY() - item_4.getHeight()*2);
            /////
            uiStage.addActor(item_5);
            item_5.setSize(startButton.getHeight()/1.3f, startButton.getHeight()/1.3f);
            item_5.setPosition(Gdx.graphics.getWidth() - continueButton.getX(), item_4.getY()+item_4.getHeight()-item_5.getHeight());
            /////
            uiStage.addActor(paddleTransformation);
            paddleTransformation.setSize(startButton.getWidth(), startButton.getHeight());
            paddleTransformation.setOrigin(Align.center);
            paddleTransformation.setRotation(5);
            paddleTransformation.setPosition(Gdx.graphics.getWidth()- paddleTransformation.getWidth() - item_3.getWidth(),
                    ballIconFunny.getY() + paddleTransformation.getHeight());
            /////
            uiStage.addActor(quickBall);
            quickBall.setSize(item_1.getWidth()*1.2f, item_1.getHeight()*1.2f);
            quickBall.setOrigin(Align.center);
            quickBall.setRotation(68);
            quickBall.setPosition(paddleTransformation.getX() + paddleTransformation.getWidth()/2 - quickBall.getWidth(),
                    paddleTransformation.getY() + paddleTransformation.getHeight());
        } else {
            uiStage.addActor(startButton);
            startButton.setPosition(Gdx.graphics.getWidth()/2f-startButton.getWidth()/2f,
                    (Gdx.graphics.getHeight() - (Gdx.graphics.getHeight()-marginY)) - startButton.getHeight()*2f);
            /////
            uiStage.addActor(item_1);
            item_1.setSize(startButton.getHeight(), startButton.getHeight());
            item_1.setRotation(15f);
            item_1.setPosition(startButton.getX()/4f, startButton.getY()+20f);
            /////
            uiStage.addActor(item_2);
            item_2.setSize(startButton.getHeight()/1.2f, startButton.getHeight()/1.2f);
            item_2.setPosition(Gdx.graphics.getWidth()-startButton.getX()/2f - item_2.getWidth()/2f,
                    startButton.getY()-startButton.getHeight()/1.5f);
            /////
            uiStage.addActor(ballIconCrazy);
            ballIconCrazy.setSize(startButton.getHeight()*3, startButton.getHeight()*3);
            ballIconCrazy.setPosition(Gdx.graphics.getWidth() - ballIconCrazy.getWidth() - 25, 25);
            /////
            uiStage.addActor(ballIconFunny);
            ballIconFunny.setSize(startButton.getHeight()*2, startButton.getHeight()*2);
            ballIconFunny.setPosition(ballIconFunny.getWidth()/3, ballIconCrazy.getY()+ballIconCrazy.getHeight());
            /////
            uiStage.addActor(item_3);
            item_3.setSize(startButton.getHeight()/1.5f, startButton.getHeight()/1.5f);
            item_3.setPosition(startButton.getX() - item_3.getWidth(),
                    startButton.getY() - item_3.getHeight() - item_3.getHeight()*2);
            uiStage.addActor(item_4);
            item_4.setSize(startButton.getHeight(), startButton.getHeight());
            item_4.setRotation(-5f);
            item_4.setPosition(startButton.getX() + (item_4.getWidth()/2), item_3.getY() - item_4.getHeight());
            /////
            uiStage.addActor(item_5);
            item_5.setSize(startButton.getHeight()/1.3f, startButton.getHeight()/1.3f);
            item_5.setPosition(Gdx.graphics.getWidth() - startButton.getX(), item_4.getY()+item_4.getHeight()-item_5.getHeight());
            /////
            uiStage.addActor(paddleTransformation);
            paddleTransformation.setSize(startButton.getWidth(), startButton.getHeight());
            paddleTransformation.setOrigin(Align.center);
            paddleTransformation.setRotation(5);
            paddleTransformation.setPosition(Gdx.graphics.getWidth()- paddleTransformation.getWidth() - item_3.getWidth(),
                    ballIconFunny.getY() + paddleTransformation.getHeight());
            /////
            uiStage.addActor(quickBall);
            quickBall.setSize(item_1.getWidth()*1.2f, item_1.getHeight()*1.2f);
            quickBall.setOrigin(Align.center);
            quickBall.setRotation(68);
            quickBall.setPosition(paddleTransformation.getX() + paddleTransformation.getWidth()/2 - quickBall.getWidth(),
                    paddleTransformation.getY() + paddleTransformation.getHeight());
        }

        //Gdx.app.log("MyTag", String.valueOf(attainment));

    }

    @Override
    public void update(float dt) {

    }
}