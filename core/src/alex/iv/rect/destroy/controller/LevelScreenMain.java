package alex.iv.rect.destroy.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import alex.iv.rect.destroy.actors.Ball;
import alex.iv.rect.destroy.actors.Paddle;
import alex.iv.rect.destroy.actors.Wall;

public class LevelScreenMain extends MenuScreen {

    private IActivityRequestHandler requestHandler; // переменная для ссылки на метод из AndroidLauncher(showOrLoadInterstitial()) - для вызова метода, который показывает рекламу
    private float windowPlayWidth;
    private float windowPlayHeight;
    protected Wall wallHeight;
    protected Wall wallWight;
    protected int score; // переменная набранных очков
    private boolean startGame; // переменная для старта игры(становиться true в методе "touchDown")
    protected float starTimer; // переменная для подсчета проигранного времени
    private boolean paddleStop; // переменная, которая разрешает веслу двигаться(если игрок словил Item.Type.PADDLE_STOP, то переменная блокирует весло на 7 секунд)
    private boolean ballStop; // переменная, которая разрешает ball двигаться(если игрок словил Item.Type.PADDLE_STOP, то переменная блокирует ball на 7 секунд)
    private Label Time; // метка, которая отображает проигранное время
    private Label Live; // метка, которая отображает жизни
    private Label recordsLabel;
    private Label recordsLabelWindow;
    private Label TimePaddleStop; // метка, которая отображает время остановки весла
    private float timerPaddleStop; // переменная, которая отсчитывает 7 секунд при блокировке весла(Item.Type.PADDLE_STOP)
    private Label scoreLabel; //
    private Paddle paddle;
    private Label messageLabel; //
    private Ball ball;
//    private Sound bounceSound;
//    private Sound brickBumpSound;
//    private Sound wallBumpSound;
//    private Sound itemAppearSound;
//    private Sound itemCollectSound;

    // конструктор, который создает саму ссылку на метод showOrLoadInterstitial из AndroidLauncher
    public LevelScreenMain(IActivityRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public LevelScreenMain() {
    }

    @Override
    public void initialize() {
        windowPlayWidth = Gdx.graphics.getWidth();
        windowPlayHeight = Gdx.graphics.getHeight() / 2 - 100;
        BaseActor background = new BaseActor(0, windowPlayHeight, mainStage);
        background.loadTexture("space.png");
        background.setSize(windowPlayWidth, windowPlayHeight + 200);
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
        recordsLabel = new Label("Records: ", BaseGame.labelStyle);
        recordsLabel.setPosition((Gdx.graphics.getWidth()/2) - recordsLabel.getWidth()/2, Gdx.graphics.getHeight()/2);
        recordsLabel.setColor( Color.CYAN );
        ///////////////////////////////////////
        // инициализация метки для отображения жизней
        Live = new Label("Live:", BaseGame.labelStyle);
        Live.setPosition(windowPlayWidth - Live.getWidth() - 70, Gdx.graphics.getHeight() - Live.getHeight() - 6);
        uiStage.addActor(Live);
//        Live.setText("Live: " + liveMemory);
        // инициализация метки для отображения жизней(конец)
        scoreLabel = new Label("Score: " + score, BaseGame.labelStyle); // отображение очков
        messageLabel = new Label("click to start", BaseGame.labelStyle );
        messageLabel.setColor( Color.CYAN );
        //////////////////////////
        // отображение 7 секунд при блокировке весла(Item.Type.PADDLE_STOP)
        TimePaddleStop = new Label("", BaseGame.labelStylePaddleStop);
        TimePaddleStop.setColor( Color.CYAN );
        TimePaddleStop.setPosition(Gdx.graphics.getWidth()/2- TimePaddleStop.getWidth()/2, Gdx.graphics.getHeight() - 500);
        //uiStage.addActor(TimePaddleStop); // эта строчка используется непосредственно когда игрок ловит Item.Type.PADDLE_STOP
        TimePaddleStop.setText((int)timerPaddleStop);
        ////////////////////////////
        uiTable.pad(5);
        uiTable.add(scoreLabel);
        uiTable.add().expandX();
        uiTable.row();
        uiTable.add(messageLabel).colspan(3).expandY();

        paddle = new Paddle(windowPlayWidth / 2 - 64 , windowPlayHeight, mainStage);

//        bounceSound	= Gdx.audio.newSound(Gdx.files.internal("boing.wav"));
//        brickBumpSound = Gdx.audio.newSound(Gdx.files.internal("bump.wav"));
//        wallBumpSound = Gdx.audio.newSound(Gdx.files.internal("bump-low.wav"));
//        itemAppearSound	= Gdx.audio.newSound(Gdx.files.internal("swoosh.wav"));
//        itemCollectSound = Gdx.audio.newSound(Gdx.files.internal("pop.wav"));
//        Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Rollin-at-5.mp3"));
//        backgroundMusic.setLooping(true);
//        backgroundMusic.setVolume(0.50f);
//        backgroundMusic.play();

        ball = new Ball(0,0, mainStage);
        ball.setColor(Color.GREEN);

        // инициализация кнопки, которая отпускает шарик от весла
        final TextButton start = new TextButton( "Start", BaseGame.textButtonStyle );
        start.setPosition(windowPlayWidth/2 - start.getWidth()/2,(Gdx.graphics.getHeight() - windowPlayHeight) / 2);
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

    // метод, который показывает на экране рекорд уровня
    protected void showRecordsLabelWindow(int recordsLevels) {
        recordsLabelWindow = new Label("Records: ", BaseGame.labelStyle);
        recordsLabelWindow.setPosition(40, Gdx.graphics.getHeight()/4);
        recordsLabelWindow.setColor( Color.CYAN );
        uiStage.addActor(recordsLabelWindow);
        recordsLabelWindow.setText("Records: " + recordsLevels);
    }
    // метод, который показывает на экране рекорд уровня(конец)

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
//            recordsLabel.setText("Records: " + record);
//            uiStage.addActor(recordsLabel);
    }
    // метод, который запускается, когда закончилось игровое время(конец)

    // метод, который запускается, когда все кирпичи разрушены
    protected void allTheBricksAreBroken(int record, String key) {
            messageLabel.setText("You win!");
            messageLabel.setColor(Color.LIME);
            messageLabel.setVisible(true);
            ball.remove();
            Time.remove();
            paddle.remove();
            record = score;
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
    private void startLevel() {
        if ( ball.isPaused() && ballStop) {
            ball.setPaused(false);
            messageLabel.setVisible(false);
            startGame = true;
        }
    }
    // метод, который заставляет шарик двигаться(конец)

    // когда на поле появляется несколько мячей
    private void ballsOverlaps() {
        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            for (BaseActor wall : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Wall")) {
                if (bal.overlaps(wall)) {
                    bal.bounceOff(wall); // отскакивание под углом
                    //wallBumpSound.play();
                }
            }
            if (bal.overlaps(paddle)) {
                //bounceSound.play();
                float ballCenterX = bal.getX() + bal.getWidth() / 2;
                float paddlePercentHit = (ballCenterX - paddle.getX()) / paddle.getWidth();
                float bounceAngle = MathUtils.lerp(150, 30, paddlePercentHit);
                bal.setMotionAngle(bounceAngle);
            }
            for (BaseActor br : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
                if (bal.overlaps(br)) {
                    bal.bounceOff(br);
                    //brickBumpSound.play();
                    if (Color.rgb888(br.getColor()) == Color.rgb888(Color.RED)) {
                        br.remove();
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
                    // если зеленый шар косается кирпича, то (иногда) появляется Item
                    if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.GREEN)) {
                        float spawnProbability = 30; // частота появления Item
                        if (MathUtils.random(0, 100) < spawnProbability) {
                            Item i = new Item(0, 0, mainStage);
                            i.centerAtActor(br);
                        }
                    }
                }
            }
            // если ball вылетает за верхнюю или нижнюю границу экрана
            if (bal.getY() < -50 && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0 ||
                    bal.getY() > Gdx.graphics.getHeight() && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0) {
                bal.remove();
                if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.GREEN)) {
                    ball = new Ball(0,0,mainStage);
                    ball.setColor(Color.GREEN);
                    live --;
                    if (live < 0) {
                        requestHandler.showVideoAd();
                    }
                    pref.putInteger("liveMemory", live);
                    pref.flush();
                    // если небыло перекрытия paddle and PADDLE_STOP, то содаем кнопку start
                    // если перекрытие было, то кнопка создасться как закончится время timerPaddleStop
                    if (paddleStop) {
                        // инициализация кнопки, которая отпускает шарик от весла
                        final TextButton start = new TextButton("Start", BaseGame.textButtonStyle);
                        start.setPosition(windowPlayWidth / 2 - start.getWidth() / 2, (Gdx.graphics.getHeight() - windowPlayHeight) / 2);
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
                    ball.setSpeed(ball.getSpeed() + 100);
                    //requestHandler.showBannerAd(); // показывает рекламный баннер
                    //requestHandler.showVideoAd(); // показывает видео рекламу с вознагрождением
                }
                if (ball.getSpeed() > ball.getMaxSpeed())
                    ball.setSpeed(ball.getMaxSpeed());
                else if (realItem.getType() == Item.Type.BALL_SPEED_DOWN) {
                    ball.setSpeed(ball.getSpeed() * 0.90f);
                    //requestHandler.hideBannerAd(); // удаляет рекламный баннер
                }
                else if (realItem.getType() == Item.Type.BALL_TWO) {
                    new Ball(paddle.getX() + paddle.getWidth() / 2 - ball.getWidth() / 2,
                            paddle.getY() + paddle.getHeight() / 2 + ball.getHeight() / 2, false, mainStage);
                }
                else if (realItem.getType() == Item.Type.PADDLE_STOP) {
                    paddleStop = false;
                    ballStop = false;
                    uiStage.addActor(TimePaddleStop);
                }
                else if (realItem.getType() == Item.Type.LIVE) {
                    live ++;
                }
                paddle.setBoundaryRectangle();
                item.remove();
                //itemCollectSound.play();
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
                start.setPosition(windowPlayWidth / 2 - start.getWidth() / 2, (Gdx.graphics.getHeight() - windowPlayHeight) / 2);
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
        ballsOverlaps();
        itemOverlaps();

    }

}
