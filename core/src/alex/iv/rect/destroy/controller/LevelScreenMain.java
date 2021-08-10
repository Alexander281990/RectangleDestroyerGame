package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.actors.Ball;
import alex.iv.rect.destroy.actors.Paddle;
import alex.iv.rect.destroy.actors.Wall;

public class LevelScreenMain extends MenuScreen {

    protected IActivityRequestHandler requestHandler; // переменная для ссылки на метод из AndroidLauncher(showOrLoadInterstitial()) - для вызова метода, который показывает рекламу
    protected static float windowPlayWidth;
    protected static float windowPlayHeight;
    protected Wall wallHeight;
    protected Wall wallWight;
    protected BaseActor background;
    protected int score; // переменная набранных очков
    private boolean startGame; // переменная для старта игры(становиться true в методе "touchDown")
    protected int mQuantityBricks; //
    private float finishQuantityBricks; //
    protected float starTimer; // переменная для подсчета проигранного времени
    protected boolean paddleStop; // переменная, которая разрешает веслу двигаться(если игрок словил Item.Type.PADDLE_STOP, то переменная блокирует весло на 7 секунд)
    private boolean ballStop; // переменная, которая разрешает ball двигаться(если игрок словил Item.Type.PADDLE_STOP, то переменная блокирует ball на 7 секунд)
    private Label Time; // метка, которая отображает проигранное время
    private Label Live; // метка, которая отображает жизни
    private Label recordsLabel;
    protected Label recordsLabelWindow;
    protected Label quantityBricks; // метка, которая отображает количество кирпичиков
    private Label TimePaddleStop; // метка, которая отображает время остановки весла
    private float timerPaddleStop; // переменная, которая отсчитывает 7 секунд при блокировке весла(Item.Type.PADDLE_STOP)
    protected Label scoreLabel; //
    protected Paddle paddle;
    private Label messageLabel; //
    protected Ball ball;
    private TextButton start;

    protected float bounceAngle;
    protected float hindranceAngle;
    protected float brickHardAngle;
    private Sound bounceSound;
    private Sound brickBumpSound;
    private Sound wallBumpSound;
//    private Sound itemAppearSound;
    private Sound itemCollectSound;

    // конструктор, который создает саму ссылку на метод showOrLoadInterstitial из AndroidLauncher
    public LevelScreenMain(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public LevelScreenMain() {
    }

    @Override
    public void initialize() {
        windowPlayWidth = Gdx.graphics.getWidth();
        //windowPlayHeight = Gdx.graphics.getHeight() / 2f - 100;
        windowPlayHeight = Gdx.graphics.getHeight();
        //BaseActor background = new BaseActor(0, windowPlayHeight, mainStage);
        background = new BaseActor(0, 0, mainStage);
        //background.loadTexture("background/fon_level.png");
        //background.setSize(windowPlayWidth, windowPlayHeight + 200);
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        BaseActor.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        wallHeight = new Wall( 0,0, 20,Gdx.graphics.getHeight(), mainStage); // left wall
        wallHeight = new Wall(Gdx.graphics.getWidth() - 20,0, 20,Gdx.graphics.getHeight(), mainStage); // right wall
        wallWight = new Wall(0,Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth(),50, mainStage); // top wall
        timerPaddleStop = 8;
        startGame = false;
        paddleStop = true;
        ballStop = true;
        score = 0;
        ///////////////////////////////////////
        quantityBricks = new Label("Bricks: ", BaseGame.labelStyle);
        quantityBricks.setPosition(Gdx.graphics.getWidth() - quantityBricks.getWidth() - wallHeight.getWidth(), Gdx.graphics.getHeight() - quantityBricks.getHeight() - wallWight.getHeight());
        uiStage.addActor(quantityBricks);
        ////////////////////////////////////////
        recordsLabel = new Label("Records: ", BaseGame.labelStyle);
        recordsLabel.setPosition((Gdx.graphics.getWidth()/2f) - recordsLabel.getWidth()/2, Gdx.graphics.getHeight()/2f);
        recordsLabel.setColor( Color.CYAN );
        ///////////////////////////////////////
        // инициализация метки для отображения жизней
        Live = new Label("Live:", BaseGame.labelStyle);
        Live.setPosition(windowPlayWidth - Live.getWidth() - 70, Gdx.graphics.getHeight() - Live.getHeight() - 6);
        uiStage.addActor(Live);
//        Live.setText("Live: " + liveMemory);
        // инициализация метки для отображения жизней(конец)
        scoreLabel = new Label("Score: " + score, BaseGame.labelStyle); // отображение очков
        recordsLabelWindow = new Label("Records: ", BaseGame.labelStyleLevel);
        recordsLabelWindow.setFontScale(1.5f, 1.5f);
        uiStage.addActor(recordsLabelWindow);
        //recordsLabelWindow.setText("Records: " + recordsLevel_1);
        messageLabel = new Label("click to start", BaseGame.labelStyle );
        messageLabel.setFontScale(3, 3);
        messageLabel.setColor( Color.CYAN );
        //////////////////////////
        // отображение 7 секунд при блокировке весла(Item.Type.PADDLE_STOP)
        TimePaddleStop = new Label("", BaseGame.labelStylePaddleStop);
        TimePaddleStop.setColor( Color.CYAN );
        TimePaddleStop.setPosition(Gdx.graphics.getWidth()/2f- TimePaddleStop.getWidth()/2, Gdx.graphics.getHeight() - 500);
        //uiStage.addActor(TimePaddleStop); // эта строчка используется непосредственно когда игрок ловит Item.Type.PADDLE_STOP
        TimePaddleStop.setText((int)timerPaddleStop);
        ////////////////////////////
        //uiTable.pad(5);
        uiTable.align(Align.center|Align.top);
        uiTable.add(scoreLabel).expandX().left().padTop(5).padLeft(20);
        uiTable.add(quantityBricks).expandX().center().padTop(5);
        uiTable.add(Live).expandX().right().top().padTop(5).padRight(20);
        uiTable.row();
        uiTable.add(recordsLabelWindow).colspan(3).padTop(Gdx.graphics.getHeight()/10f);
        uiTable.row();
        uiTable.add(messageLabel).colspan(3).padTop(Gdx.graphics.getHeight()/8f);
        uiTable.row();

        paddle = new Paddle(windowPlayWidth / 2 - 64 , windowPlayHeight / 2.5f, mainStage);

        bounceSound	= Gdx.audio.newSound(Gdx.files.internal("boing.wav"));
        brickBumpSound = Gdx.audio.newSound(Gdx.files.internal("bump.wav"));
        wallBumpSound = Gdx.audio.newSound(Gdx.files.internal("bump-low.wav"));
        itemCollectSound = Gdx.audio.newSound(Gdx.files.internal("pop.wav"));
//        itemAppearSound	= Gdx.audio.newSound(Gdx.files.internal("swoosh.wav"));
//        Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Rollin-at-5.mp3"));
//        backgroundMusic.setLooping(true);
//        backgroundMusic.setVolume(0.50f);
//        backgroundMusic.play();

        ball = new Ball(0,0, mainStage);

        start = new TextButton( "Start", BaseGame.textButtonStyle );
        start.setPosition(windowPlayWidth/2 - start.getWidth()/2,windowPlayHeight / 3.5f);

        final TextButton menuButton = new TextButton( "MENU", BaseGame.textButtonStyle );
        menuButton.setPosition(windowPlayWidth/2 - menuButton.getWidth()/2, start.getY() - start.getHeight() - 50);
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

        // инициализация кнопки, которая отпускает шарик от весла
//        start = new TextButton( "Start", BaseGame.textButtonStyle );
//        start.setPosition(windowPlayWidth/2 - start.getWidth()/2,(Gdx.graphics.getHeight() - windowPlayHeight) / 2);
        uiStage.addActor(start);
        start.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        if (live > 0) {
                            startLevel();
                            start.remove();
                            menuButton.remove();
                        } else {
                            RectangleGame.setActiveScreen(new GetLifeScreen(requestHandler));
                        }
                        return false;
                    }
                }
        );

    }

    public static float getWindowPlayWidth() {
        return windowPlayWidth;
    }

    public static float getWindowPlayHeight() {
        return windowPlayHeight;
    }


    // метод, который показывает проигранное время
    protected void showTime(float time) {
        starTimer = time;
        Time = new Label("", BaseGame.labelStyleLevel);
        Time.setColor( Color.WHITE );
        Time.setPosition(wallHeight.getWidth(), Gdx.graphics.getHeight() - wallWight.getHeight() - 30);
        uiStage.addActor(Time);
        Time.setText((int)starTimer);
    }
    // метод, который показывает проигранное время(конец)

    // метод, который показывает количество кирпичиков
    protected void quantityBricks(int quantityB, int changeColor) {
        mQuantityBricks = quantityB;
        finishQuantityBricks = changeColor;

    }
    // метод, который показывает количество кирпичиков(конец)

    // метод, который устанавливает достижение игры
    protected void createAttainment(int att) {
        if (attainment < att) {
            attainment = att;
            pref.putInteger("attainmentMemory", attainment);
            pref.flush();
            if (att == 30) {
                attainment = 0;
                pref.putInteger("attainmentMemory", attainment);
                pref.flush();
            }
        }
    }
    // метод, который устанавливает достижение игры(конец)

//    // метод, который показывает на экране рекорд уровня
//    protected void showRecordsLabelWindow(int recordsLevels) {
//        //recordsLabelWindow = new Label("Records: ", BaseGame.labelStyleLevel);
//        //recordsLabelWindow.setPosition(Gdx.graphics.getWidth()/2f - recordsLabelWindow.getWidth()/2, Gdx.graphics.getHeight()/1.25f);
//        //recordsLabelWindow.setColor( Color.CYAN );
//        uiStage.addActor(recordsLabelWindow);
//        recordsLabelWindow.setText("Records: " + recordsLevels);
//    }
//    // метод, который показывает на экране рекорд уровня(конец)

    // метод, который запускается, когда закончилось игровое время
    // в параметр метода нужно вставить аргумент из StartScreen(например recordsLevel_1 или recordsLevel_2 (зависит от Level в
    // котором запускается метод) и стринговый аргумент ключа для сохранения рекорда)
    protected void timeIsUp(int record, String key) {
            for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")){
                brick.remove();
            }
            for (BaseActor ball : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")){
                ball.remove();
            }
            Time.remove();
            paddle.remove();
            ball.remove();
            messageLabel.remove();
            if (score > record) {
                record = score;
            }
            pref.putInteger(key, record);
            pref.flush();
            startGame = false;
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
//            recordsLabel.setText("Records: " + record);
//            uiStage.addActor(recordsLabel);
    }
    // метод, который запускается, когда закончилось игровое время(конец)

    // метод, который запускается, когда все кирпичи разрушены
    protected void allTheBricksAreBroken(String key, String keyColor) {
        for (BaseActor ball : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            ball.remove();
        }
        for (BaseActor item : BaseActor.getList(mainStage, "alex.iv.rect.destroy.controller.Item")) {
            item.remove();
        }
        int attainmentColorLevel = 1;
        pref.putInteger(keyColor, attainmentColorLevel);
        messageLabel.setText("You win!");
        messageLabel.setColor(Color.LIME);
        messageLabel.setVisible(true);
        ball.remove();
        Time.remove();
        paddle.remove();
        int record = score;
        //live ++;
        pref.putInteger(key, record);
        //pref.putInteger("liveMemory", live);
        pref.flush();
        recordsLabel.setText("Records: " + record);
        uiStage.addActor(recordsLabel);
    }
    // метод, который запускается, когда все кирпичи разрушены(конец)

//    // когда игрок отпускает палец от экрана, мяч начинает лететь
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        if ( this.ball.isPaused() && ballStop) {
//            this.ball.setPaused(false);
//            messageLabel.setVisible(false);
//            startGame = true;
//        }
//        return false;
//    }
//    // когда игрок отпускает палец от экрана, мяч начинает лететь(конец)

    // метод, который заставляет шарик двигаться
    protected void startLevel() {
        if ( ball.isPaused() && ballStop) {
            ball.setPaused(false);
            messageLabel.setVisible(false);
            startGame = true;
        }
    }
    // метод, который заставляет шарик двигаться(конец)

    // когда на поле появляется несколько мячей
    protected void ballsOverlaps() {
        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            for (BaseActor wall : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Wall")) {
                if (bal.overlaps(wall)) {
                    bal.bounceOff(wall); // отскакивание под углом
                    wallBumpSound.play();
                }
            }
            if (bal.overlaps(paddle)) {
                bounceSound.play();
                float positionPaddle_Y = paddle.getY() + paddle.getHeight() / 2; // находим центр paddle по оси Y
                float positionBall_Y = bal.getY() + bal.getHeight() / 2; // находим центр ball по оси Y
                float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
                float paddlePercentHit = (ballCenterX - paddle.getX()) / paddle.getWidth();
                // если во время столкновения ось Y обьекта bal больше оси Y обьекта paddle, то мячь отскакивает и движется вверх. В противном случае - вниз
                if (positionBall_Y > positionPaddle_Y) {
                    bounceAngle = MathUtils.lerp(150, 30, paddlePercentHit);
                } else {
                    bounceAngle = MathUtils.lerp(-150, -30, paddlePercentHit);
                }
                bal.setMotionAngle(bounceAngle);

            }

            for (BaseActor brickHard : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.BrickHard")) {
                if (bal.overlaps(brickHard)) {
                    brickBumpSound.play();
                    // если brickHardStatus = true, то мяч отскакивает от кирпича как от стен. А если brickHardStatus = false, то
                    // мяч отскакивает от кирпича как от весла(paddle)
                    if (brickHard.brickHardStatus) {
                        bal.bounceOff(brickHard);
                    } else {
                        float positionBrickHard_Y = brickHard.getY() + brickHard.getHeight() / 2;
                        float positionBall_Y = bal.getY() + bal.getHeight() / 2;
                        float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
                        float brickHardPercentHit = (ballCenterX - brickHard.getX()) / brickHard.getWidth();
                            if (positionBall_Y > positionBrickHard_Y) {
                                brickHardAngle = MathUtils.lerp(150, 30, brickHardPercentHit);
                            } else {
                                brickHardAngle = MathUtils.lerp(-150, -30, brickHardPercentHit);
                            }
                        bal.setMotionAngle(brickHardAngle);
                    }
                }
            }

            for (BaseActor hindrance : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Hindrance")) {
                if (bal.overlaps(hindrance)) {
                    // Если hindrance.brickHardStatus = true, то мяч от помехи будет отскакивать с обоих сторон
                    // Если hindrance.brickHardStatus = false, то мяч от помехи будет отскакивать только с верхней стороны. Если мяч
                        // коснется нижней стороны помехи, то она пропустит мяч на верхнюю свою сторону
                    if (hindrance.brickHardStatus) {
                        float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
                        float hindrancePercentHit = (ballCenterX - hindrance.getX()) / hindrance.getWidth();
                        hindranceAngle = MathUtils.lerp(150, 30, hindrancePercentHit);
                        bal.setMotionAngle(hindranceAngle);
                    } else {
                        float positionHindrance_Y = hindrance.getY() + hindrance.getHeight() / 2;
                        float positionBall_Y = bal.getY() + bal.getHeight() / 2;
                        float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
                        float hindrancePercentHit = (ballCenterX - hindrance.getX()) / hindrance.getWidth();
                        if (positionBall_Y > positionHindrance_Y) {
                            hindranceAngle = MathUtils.lerp(150, 30, hindrancePercentHit);
                        } else {
                            hindranceAngle = MathUtils.lerp(-150, -30, hindrancePercentHit);
                        }
                        bal.setMotionAngle(hindranceAngle);
                    }
                }
            }

            for (BaseActor br : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
                if (bal.overlaps(br)) {
                    bal.bounceOff(br);
                    brickBumpSound.play();
                    if (Color.rgb888(br.getColor()) == Color.rgb888(Color.RED)) {
                        br.remove();
                        mQuantityBricks -- ;
                        switch (br.hit) {    // считает сколько раз попали по кирпичю, и добавляет очки за его дальнейшее уничтожение
                            case 0:
                                score += 50;
                                break;
                            case 1:
                                score += 100;
                                break;
                            case 2:
                                score += 150;
                                break;
                            case 3:
                                score += 200;
                                break;
                            case 4:
                                score += 250;
                                break;
                            default:
                                score += 500;
                                break;
                        }
                    } else {
                        br.hit++;
                        br.numberColor -- ;
                        score += 10;
                        switch (br.numberColor) {    // узнает по какому кирпичу было попадание, и меняет цветт в соответствии
                            case 1:
                                br.setColor(Color.RED);
                                break;
                            case 2:
                                br.setColor(Color.ORANGE);
                                break;
                            case 3:
                                br.setColor(Color.YELLOW);
                                break;
                            case 4:
                                br.setColor(Color.GREEN);
                                break;
                            default:
                        }
                    }
                    scoreLabel.setText("Score " + score);
                    // если белый шар косается кирпича, то (иногда) появляется Item
                    if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE)) {
                        int randomNumber = MathUtils.random(0, 100);
                        int spawnProbability = 30; // частота появления Item
                        int spawnProbabilityLive = 33; // частота появления Item для жизней
                        if (randomNumber < spawnProbability) {
                            Item i = new Item(0, 0, mainStage);
                            i.centerAtActor(br);
                        }
                        if (randomNumber > spawnProbability && randomNumber < spawnProbabilityLive) {
                            Item i = new Item(0, 0, mainStage, "LIVE");
                            i.centerAtActor(br);
                        }
                        //Gdx.app.log("MyTag", String.valueOf(randomNumber));
                    }
                }
            }
            // если ball вылетает за верхнюю или нижнюю границу экрана
            if (bal.getY() < -50 && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0 ||
                    bal.getY() > Gdx.graphics.getHeight() && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0) {
                bal.remove();
                if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE)) {
                    ball = new Ball(0,0,mainStage);
                    ball.setColor(Color.WHITE);
                    live --;
                    if (live < 1) {
                        //requestHandler.showVideoAd();
                        RectangleGame.setActiveScreen(new GetLifeScreen(requestHandler));
                    }
                    pref.putInteger("liveMemory", live);
                    pref.flush();
                    // если небыло перекрытия paddle and PADDLE_STOP, то содаем кнопку start
                    // если перекрытие было, то кнопка создасться как закончится время timerPaddleStop
                    if (paddleStop) {
                        // инициализация кнопки, которая отпускает шарик от весла
                        final TextButton start = new TextButton("Start", BaseGame.textButtonStyle);
                        start.setPosition(windowPlayWidth/2 - start.getWidth()/2,windowPlayHeight / 3.5f);
                        uiStage.addActor(start);
                        start.addListener(
                                new EventListener() {
                                    @Override
                                    public boolean handle(Event e) {
                                        if (!(e instanceof InputEvent) ||
                                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                                            return false;
                                        startLevel();
                                        start.remove();
                                        return false;
                                    }
                                }
                        );
                    }
                }
            }
        }
    }
    // когда на поле появляется несколько мячей(конец)

    private void itemOverlaps() {
        // если весло пересекается с кем-то из обьектов Item
        for (BaseActor item : BaseActor.getList(mainStage, "alex.iv.rect.destroy.controller.Item")) {
            if (paddle.overlaps(item)) {
                Item realItem = (Item) item;
                if (realItem.getType() == Item.Type.PADDLE_EXPAND)
                    paddle.setWidth(paddle.getWidth() * 1.25f);
                else if (realItem.getType() == Item.Type.PADDLE_SHRINK)
                    paddle.setWidth(paddle.getWidth() * 0.80f);
                else if (realItem.getType() == Item.Type.BALL_SPEED_UP) {
                    //ball.setSize(ball.getWidth() * 1.20f, ball.getHeight() * 1.20f);
                    //ball.setBoundaryRectangle();
                    ball.setSpeed(ball.getSpeed() * 1.20f);
//                    ball.setSize(ball.getWidth() * 1.20f, ball.getHeight() * 1.20f);
//                    ball.setBoundaryRectangle();
                    //ball.setSpeed(ball.getSpeed() * 1.10f);
                    //requestHandler.showBannerAd(); // показывает рекламный баннер
                    //requestHandler.showVideoAd(); // показывает видео рекламу с вознагрождением
                    //requestHandler.showOrLoadInterstitial(); // показывает межстраничный баннер
                    //requestHandler.hideBannerAd(); // удаляет рекламный баннер
                }
//                if (ball.getSpeed() > ball.getMaxSpeed())
//                    ball.setSpeed(ball.getMaxSpeed());
                else if (realItem.getType() == Item.Type.BALL_SPEED_DOWN) {
                    ball.setSpeed(ball.getSpeed() * 1.20f);
                    //ball.setSize(ball.getWidth() / 2, ball.getHeight() / 2);
                    //ball.setBoundaryRectangle();
                    //ball.setSpeed(ball.getSpeed() * 0.90f);
//                    ball.setSize(ball.getWidth() / 2, ball.getHeight() / 2);
//                    ball.setBoundaryRectangle();
                }
                else if (realItem.getType() == Item.Type.BALL_TWO) {
                    new Ball(paddle.getX() + paddle.getWidth() / 2 - ball.getWidth() / 2,
                            paddle.getY() + paddle.getHeight() / 1.25f + ball.getHeight() / 1.25f, false, mainStage);
                }
                else if (realItem.getType() == Item.Type.PADDLE_STOP) {
                    paddleStop = false;
                    ballStop = false;
                    uiStage.addActor(TimePaddleStop);
                }
                else if (realItem.getLive() == Item.Live.LIVE) {
                    live ++;
                    pref.putInteger("liveMemory", live);
                    pref.flush();
                }
                paddle.setBoundaryRectangle();
                item.remove();
                itemCollectSound.play();
            }
        }
        // если весло пересекается с кем-то из обьектов Item(конец)
    }

    @Override
    public void update(float dt) {

        // Отсчет игрового времени
        if (startGame) {
            starTimer -= dt;
            Time.setText((int)starTimer); // вывод времени на экран
            recordsLabelWindow.remove();
        }
        // если игрок поймал Item.Type.PADDLE_STOP, то блокируем весло на 7 секунд
        if (!paddleStop) {
            timerPaddleStop -= dt;
            TimePaddleStop.setText((int)timerPaddleStop);// выводим время на экран
        }
        // если 7 секунд прошло, то весло снова может двигаться
        if (timerPaddleStop < 0) {
            // если штрафное время закончилось, но зеленый шар находится на игровом поле и в движении, то продолжаем играть
            // и никакая кнопка не появляется. В противном случае появляется кнопка для старта игры(после ее нажатия про-
            // должаем играть дальше)
            if (ball.getY() > 0 && !ball.isPaused() || ball.getY() < Gdx.graphics.getHeight() && !ball.isPaused()) {
                paddleStop = true;
                ballStop = true;
                TimePaddleStop.remove();
                timerPaddleStop = 8;
            } else {
                paddleStop = true;
                ballStop = true;
                TimePaddleStop.remove();
                timerPaddleStop = 8;
                // инициализация кнопки, которая отпускает шарик от весла
                final TextButton start = new TextButton("Start", BaseGame.textButtonStyle);
                start.setPosition(windowPlayWidth/2 - start.getWidth()/2,windowPlayHeight / 3.5f);
                uiStage.addActor(start);
                start.addListener(
                    new EventListener() {
                        @Override
                        public boolean handle(Event e) {
                            if (!(e instanceof InputEvent) ||
                                    !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                                return false;
                            startLevel();
                            start.remove();
                            return false;
                        }
                    }
                );
            }
        }

        // метод, который держит ракетку горизонтально выровнянную с пальцем на экране
        if (paddleStop) {
            float touchDownX = Gdx.input.getX();
            paddle.setX(touchDownX - paddle.getWidth() / 2);
            paddle.boundToWorld();
        }
        // метод, который держит ракетку горизонтально выровнянную с пальцем на экране(конец)

        // метод, который фиксирует мяч над центром весла, если он не движется
        if ( ball.isPaused() ) {
            ball.setX( paddle.getX() + paddle.getWidth()/2 - ball.getWidth()/2 );
            ball.setY( paddle.getY() + paddle.getHeight()/2 + ball.getHeight()/2 );
        }
        // метод, который фиксирует мяч над центром весла, если он не движется(конец)

        Live.setText("Live: " + live);
        /////////////////////////////////
        if (mQuantityBricks <= finishQuantityBricks) {
            quantityBricks.setColor(Color.GREEN);
        } else {
            quantityBricks.setColor(Color.WHITE);
        }
        quantityBricks.setText("Bricks: " + mQuantityBricks);
        ///////////////////////////////////////////
        ballsOverlaps();
        itemOverlaps();

    }

}
