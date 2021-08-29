package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import java.util.Locale;
import alex.iv.rect.destroy.actors.Ball;
import alex.iv.rect.destroy.actors.Paddle;
import alex.iv.rect.destroy.actors.Wall;

public class LevelScreenMain extends MenuScreen {

    protected IActivityRequestHandler requestHandler; // переменная для ссылки на метод из AndroidLauncher(showOrLoadInterstitial()) - для вызова метода, который показывает рекламу
    protected static float windowPlayWidth;
    protected static float windowPlayHeight;
    private Wall wallHeight;
    protected Wall wallWight;
    protected BaseActor background;
    protected int score; // переменная набранных очков
    protected boolean startGame; // переменная для старта игры(становиться true в методе "touchDown")
    protected int mQuantityBricks; //
    private float finishQuantityBricks; //
    protected float starTimer; // переменная для подсчета проигранного времени
    protected boolean paddleStop; // переменная, которая разрешает веслу двигаться(если игрок словил Item.Type.PADDLE_STOP, то переменная блокирует весло на 7 секунд)
    private boolean ballStop; // переменная, которая разрешает ball двигаться(если игрок словил Item.Type.PADDLE_STOP, то переменная блокирует ball на 7 секунд)
    private Label Time; // метка, которая отображает проигранное время
    private Label Live; // метка, которая отображает жизни
    private Label recordsLabelWindow;
    private Label numberLevel;
    private Label rulesGame;
    public static int live;
    protected Label quantityBricks; // метка, которая отображает количество кирпичиков
    private Label TimePaddleStop; // метка, которая отображает время остановки весла
    private float timerPaddleStop; // переменная, которая отсчитывает 7 секунд при блокировке весла(Item.Type.PADDLE_STOP)
    protected Label scoreLabel; //
    protected Paddle paddle;
    protected Ball ball;
    private TextButton start;
    public static TextButton getLive;
    public static boolean liveFlag = true;
    private static int increasePaddleWight;

    protected float bounceAngle;
    protected float hindranceAngle;
    protected float brickHardAngle;
    private Sound bounceSound;
    private Sound brickBumpSound;
    private Sound wallBumpSound;
    private Sound itemCollectSound;
//    private Sound itemAppearSound;

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
        timerPaddleStop = 6;
        startGame = false;
        paddleStop = true;
        ballStop = true;
        score = 0;
        increasePaddleWight = 0;
        live = 5;
        ///////////////////////////////////////
        quantityBricks = new Label("Bricks: ", BaseGame.labelStyle);
        ///////////////////////////////////////
        numberLevel = new Label("Level: ", BaseGame.labelStyleLevel);
        numberLevel.setFontScale(1.5f, 1.5f);
        numberLevel.setColor( Color.WHITE );
        ///////////////////////////////////////
        rulesGame = new Label("Level: ", BaseGame.labelStyleRU);
        rulesGame.setColor( Color.WHITE );
        ///////////////////////////////////////
        // инициализация метки для отображения жизней
        Live = new Label("Live:", BaseGame.labelStyle);
        ///////////////////////////////////////
        scoreLabel = new Label("Score: " + score, BaseGame.labelStyle); // отображение очков
        recordsLabelWindow = new Label("Records: ", BaseGame.labelStyleLevel);
        recordsLabelWindow.setFontScale(1.5f, 1.5f);
        //////////////////////////
        // отображение 6 секунд при блокировке весла(Item.Type.PADDLE_STOP)
        TimePaddleStop = new Label("", BaseGame.labelStylePaddleStop);
        TimePaddleStop.setColor( Color.CYAN );
        TimePaddleStop.setPosition(Gdx.graphics.getWidth()/2f- TimePaddleStop.getWidth()/2, Gdx.graphics.getHeight() - 500);
        //uiStage.addActor(TimePaddleStop); // эта строчка используется непосредственно когда игрок ловит Item.Type.PADDLE_STOP
        TimePaddleStop.setText((int)timerPaddleStop);
        /////////////////////////
        uiTable.align(Align.center|Align.top);
        uiTable.add(scoreLabel).expandX().left().padTop(5).padLeft(20);
        uiTable.add(quantityBricks).expandX().center().padTop(5);
        uiTable.add(Live).expandX().right().top().padTop(5).padRight(20);

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

        // инициализация кнопки, которая отпускает шарик от весла
        start = new TextButton( "Start", BaseGame.textButtonStyle );
        start.setPosition(windowPlayWidth/2 - start.getWidth()/2,windowPlayHeight / 3.5f);
//        uiStage.addActor(start); // эта строчка используется в функционале кнопки "NEXT"
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
                        } else {
                            //RectangleGame.setActiveScreen(new GetLifeScreen(requestHandler));
                            requestHandler.showVideoAd();
                        }
                        return false;
                    }
                }
        );

        getLive = new TextButton( "getLive", BaseGame.textButtonStyle );
        getLive.setPosition(windowPlayWidth/2 - getLive.getWidth()/2,windowPlayHeight / 3.5f);
//        uiStage.addActor(getLive);
        getLive.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        requestHandler.showVideoAd();
                        return false;
                    }
                }
        );



    }

    // Метод, который создает модальное окно перед началом уровня
    protected void showModalScreen(int numbLevel, int recordLevel, String filePathText_RU, String filePathText_EN) {
        recordsLabelWindow.setText("Records: " + recordLevel);
        numberLevel.setText("Level: " + numbLevel);
        // следующие девять строчек выводят текст из assets/rules_level_screen
        // в зависимости от того, какой язык используется по кмолчанию на устройстве
        if (Locale.getDefault().getLanguage().equals("ru")) { // если используется русский язык по умолчанию на устройстве
            FileHandle file = Gdx.files.internal(filePathText_RU);
            String text = file.readString();
            rulesGame.setText(text);
        } else {
            FileHandle file = Gdx.files.internal(filePathText_EN);
            String text = file.readString();
            rulesGame.setText(text);
        }
        /////////
        final TextButton nextButton = new TextButton( "NEXT", BaseGame.textButtonStyle );
        nextButton.addListener(
                new EventListener() {
                    @Override
                    public boolean handle(Event e) {
                        if (!(e instanceof InputEvent) ||
                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                            return false;
                        uiStage.addActor(start); // при нажатии на кнопку показываем кнопку "tart"
                        uiModalWindowTable.remove(); // И при нажатии на кнопку удаляем модальное окно
                        return false;
                    }
                }
        );
        //////////
        final TextButton menuButton = new TextButton( "MENU", BaseGame.textButtonStyle );
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
        //////////////
        // устанавливает фоновый цвет в Table
        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Color.BLACK);
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        // устанавливает фоновый цвет в Table(конец)

        myTable.align(Align.center);
        //myTable.setDebug(true);
        uiModalWindowTable.align(Align.center|Align.top);
        myTable.add(uiModalWindowTable).width(Gdx.graphics.getWidth()-200).height(Gdx.graphics.getHeight()-400);
        uiModalWindowTable.setBackground(textureRegionDrawableBg);
        uiModalWindowTable.getColor().a = 0.5f;
        //uiModalWindowTable.setDebug(true);
        uiModalWindowTable.add(numberLevel).expandX().colspan(2);
        numberLevel.getColor().a = 10;
        uiModalWindowTable.row();
        uiModalWindowTable.add(recordsLabelWindow).expandX().colspan(2);
        recordsLabelWindow.getColor().a = 10;
        uiModalWindowTable.row();
        uiModalWindowTable.add(rulesGame).expandY().left().top().width(Gdx.graphics.getWidth()-200).colspan(2);
        rulesGame.setWrap(true);
        rulesGame.getColor().a = 10;
        uiModalWindowTable.row();
        uiModalWindowTable.add(menuButton).center().expandX().uniform();
        menuButton.getColor().a = 10;
        menuButton.getLabel().setFontScale(3, 2);
        uiModalWindowTable.add(nextButton).center().expandX().uniform();
        nextButton.getColor().a = 10;
        nextButton.getLabel().setFontScale(3, 2);
    }
    // Метод, который создает модальное окно перед началом уровня(конец)

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
            if (score > record) {
                record = score;
            }
            pref.putInteger(key, record);
            pref.flush();
            startGame = false;
    }
    // метод, который запускается, когда закончилось игровое время(конец)

    // метод, который запускается, когда все кирпичи разрушены
    protected void allTheBricksAreBroken(String key) {
        for (BaseActor ball : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            ball.remove();
        }
        for (BaseActor item : BaseActor.getList(mainStage, "alex.iv.rect.destroy.controller.Item")) {
            item.remove();
        }
        ball.remove();
        Time.remove();
        paddle.remove();
        int record = score;
        pref.putInteger(key, record);
        pref.flush();
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
                        int spawnProbabilityLive = 63; // частота появления Item для жизней
                        if (randomNumber < spawnProbability) {
                            Item i = new Item(0, 0, mainStage);
                            i.centerAtActor(br);
                        }
                        if (randomNumber == spawnProbabilityLive) {
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
                        for (BaseActor item : BaseActor.getList(mainStage, "alex.iv.rect.destroy.controller.Item")) {
                            item.remove();
                        }
                        for (BaseActor additionalBalls : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
                            additionalBalls.remove();
                        }
                        startGame = false; // остонавливает игровое время
                        uiStage.addActor(getLive);
                    }
                    // если небыло перекрытия paddle and PADDLE_STOP, то содаем кнопку start
                    // если перекрытие было, то кнопка создасться как закончится время timerPaddleStop
                    if (paddleStop && live > 0) {
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
                if (realItem.getType() == Item.Type.PADDLE_EXPAND) {
                    increasePaddleWight++;
                    if (increasePaddleWight < 10) {
                        paddle.setWidth(paddle.getWidth() * 1.20f);
                        paddle.setBoundaryRectangle();
                    } else {
                        increasePaddleWight = 10;
                        paddle.setBoundaryRectangle();
                    }
                } else if (realItem.getType() == Item.Type.PADDLE_SHRINK) {
                    increasePaddleWight--;
                    paddle.setWidth(paddle.getWidth() * 0.80f);
                    paddle.setBoundaryRectangle();
                } else if (realItem.getType() == Item.Type.BALL_SPEED_UP) {
                    starTimer += 10;
                    //requestHandler.showBannerAd(); // показывает рекламный баннер
                    //requestHandler.showVideoAd(); // показывает видео рекламу с вознагрождением
                    //requestHandler.showOrLoadInterstitial(); // показывает межстраничный баннер
                    //requestHandler.hideBannerAd(); // удаляет рекламный баннер
                }
                else if (realItem.getType() == Item.Type.BALL_SPEED_DOWN) {
                    starTimer -= 10;
                }
//                else if (realItem.getType() == Item.Type.PADDLE_ADS) {
//                    requestHandler.showOrLoadInterstitial(); // показывает межстраничный баннер
//                }
                else if (realItem.getType() == Item.Type.BALL_TWO) {
                    new Ball(paddle.getX() + paddle.getWidth() / 2 - ball.getWidth() / 2,
                            paddle.getY() + paddle.getHeight() / 1.25f + ball.getHeight() / 1.25f, false, mainStage);
                } else if (realItem.getType() == Item.Type.PADDLE_STOP) {
                    paddleStop = false;
                    ballStop = false;
                    uiStage.addActor(TimePaddleStop);
                } else if (realItem.getLive() == Item.Live.LIVE) {
                    live ++;
                }
                item.remove();
                itemCollectSound.play();
            }
            //Gdx.app.log("MyTag", String.valueOf(increasePaddleWight));
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
        // если игрок поймал Item.Type.PADDLE_STOP, то блокируем весло на 6 секунд
        if (!paddleStop) {
            timerPaddleStop -= dt;
            TimePaddleStop.setText((int)timerPaddleStop);// выводим время на экран
        }
        // если 6 секунд прошло, то весло снова может двигаться
        if (timerPaddleStop < 0) {
            // если штрафное время закончилось, но белый шар находится на игровом поле и в движении, то продолжаем играть
            // и никакая кнопка не появляется. В противном случае появляется кнопка для старта игры(после ее нажатия про-
            // должаем играть дальше)
            if (ball.getY() > 0 && !ball.isPaused() || ball.getY() < Gdx.graphics.getHeight() && !ball.isPaused()) {
                paddleStop = true;
                ballStop = true;
                TimePaddleStop.remove();
                timerPaddleStop = 6;
            } else {
                paddleStop = true;
                ballStop = true;
                TimePaddleStop.remove();
                timerPaddleStop = 6;
                if (live > 0) {
                    // инициализация кнопки, которая отпускает шарик от весла
                    final TextButton start = new TextButton("Start", BaseGame.textButtonStyle);
                    start.setPosition(windowPlayWidth / 2 - start.getWidth() / 2, windowPlayHeight / 3.5f);
                    uiStage.addActor(start);
                    start.addListener(
                        new EventListener() {
                            @Override
                            public boolean handle(Event e) {
                                if (!(e instanceof InputEvent) ||
                                        !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                                    return false;
                                start.remove();
                                startLevel();
                                return false;
                            }
                        }
                    );
                }
            }
        }

        // если мы получили жизни после просмотра рекламы
        if (!liveFlag) {
            liveFlag = true;
            ball = new Ball(0,0,mainStage);
            ball.setColor(Color.WHITE);
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
                            start.remove();
                            startLevel();
                            return false;
                        }
                    }
            );
        }
        // если мы получили жизни после просмотра рекламы(конец)

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
