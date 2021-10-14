package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import alex.iv.rect.destroy.actors.Ball;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.actors.Paddle;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.Item;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_28 extends LevelScreenMain {

    private Paddle paddle_2;
    private Warp warpMain1;
    private Warp warpMain2;
    private Warp warp1;
    private Warp warp2;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_28(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(300); // инициализируем метод отображение игрового времени
        quantityBricks(69, 6);
        showModalScreen(28, recordsLevel_28, "rules_level_screen/level_screen_28_ru.txt",
                "rules_level_screen/level_screen_28.txt");

        paddle_2 = new Paddle(paddle.getX(), Gdx.graphics.getHeight() - super.wallWight.getHeight() * 2.5f , mainStage);
        paddle_2.setSize(paddle.getWidth() * 2,Gdx.graphics.getHeight() / 60f);
        paddle_2.setBoundaryRectangle();
        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 31;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                if (rowNum == 0 || rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5 || rowNum == 6 ||
                        rowNum == 7 || rowNum == 12 || rowNum == 14 || rowNum == 19 || rowNum == 20 || rowNum == 21 || rowNum == 22 ||
                        rowNum == 23 || rowNum == 24 || rowNum == 25 || rowNum == 26 || rowNum == 27 || rowNum == 28 || rowNum == 29 ||
                        rowNum == 30) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 3 ||
                        rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8 || rowNum == 8 && colNum == 9 ||
                        rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 1 || rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 3 ||
                        rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 7 || rowNum == 18 && colNum == 8 || rowNum == 18 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 0) {
                    warpMain1 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 26 && colNum == 9) {
                    warpMain2 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 7 && colNum == 7) {
                    warp1 = new Warp( x, y, mainStage);
                }
                if (rowNum == 19 && colNum == 1) {
                    warp2 = new Warp( x, y, mainStage);
                }
                if (rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 4 || rowNum == 13 && colNum == 6 ||
                        rowNum == 13 && colNum == 8) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 5 || rowNum == 13 && colNum == 7 ||
                        rowNum == 13 && colNum == 9) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 9 || rowNum == 10 || rowNum == 11 || rowNum == 15 || rowNum == 16 || rowNum == 17) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                    brick.setBrickFlash(false); // инициализация метода смены цветов кирпича
                }
                if (rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5 || rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 5) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                    brick.mBrick = true;
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
        super.wallWight.remove();
    }

    @Override
    protected void ballsOverlaps() {
            for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
                if (bal.getX() < 0) {
                    bal.setPosition(wallHeightLeft.getX()+wallHeightLeft.getWidth()+10, bal.getY());
                    bal.setMotionAngle(-bal.getMotionAngle());
                    wallBumpSound.play();
                }
                if (bal.getX() > Gdx.graphics.getWidth()) {
                    bal.setPosition(wallHeightRight.getX()-bal.getWidth()+10, bal.getY());
                    bal.setMotionAngle(-bal.getMotionAngle());
                    wallBumpSound.play();
                }
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

                //bal.getY() > Gdx.graphics.getHeight() && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0

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

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_28, "records_28"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 28, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_28");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_28"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 7 && starTimer > 0) {
            createAttainment(28);
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED) && brick.mBrick ||
                    Color.rgb888(brick.getColor()) == Color.rgb888(Color.ORANGE) && brick.mBrick ||
                    Color.rgb888(brick.getColor()) == Color.rgb888(Color.YELLOW) && brick.mBrick ||
                    Color.rgb888(brick.getColor()) == Color.rgb888(Color.GREEN) && brick.mBrick) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

        // метод, который держит ракетку горизонтально выровнянную с пальцем на экране
        if (paddleStop) {
            float touchDownX = Gdx.input.getX();
            paddle_2.setX(touchDownX - paddle_2.getWidth() / 2);
            paddle_2.boundToWorld();
        }
        // метод, который держит ракетку горизонтально выровнянную с пальцем на экране(конец)
        // метод, который заставляет отскакивать мячики от дополнительного весла
        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(paddle_2)) {
                //bounceSound.play();
                float positionPaddle_Y = paddle_2.getY() + paddle_2.getHeight() / 2; // находим центр paddle по оси Y
                float positionBall_Y = bal.getY() + bal.getHeight() / 2; // находим центр ball по оси Y
                float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
                float paddlePercentHit = (ballCenterX - paddle_2.getX()) / paddle_2.getWidth();
                // если во время столкновения ось Y обьекта bal больше оси Y обьекта paddle, то мячь отскакивает и движется вверх. В противном случае - вниз
                if (positionBall_Y > positionPaddle_Y) {
                    bounceAngle = MathUtils.lerp(150, 30, paddlePercentHit);
                } else {
                    bounceAngle = MathUtils.lerp(-150, -30, paddlePercentHit);
                }
                bal.setMotionAngle(bounceAngle);
            }
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain1)) {
                bal.centerAtActor(warp2);
                bal.setMotionAngle(MathUtils.random(360));
            }
            if (bal.overlaps(warpMain2)) {
                bal.centerAtActor(warp1);
                bal.setMotionAngle(MathUtils.random(360));
            }
        }
    }
}