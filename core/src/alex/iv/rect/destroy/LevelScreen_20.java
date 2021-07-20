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
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.GetLifeScreen;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.Item;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_20 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_20(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(200); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_20);
        quantityBricks(300, 30);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 30;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                brick.setColor(Color.RED);
                if (rowNum == 0 || rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5 || rowNum == 6 ||
                        rowNum == 7 || rowNum == 8 || rowNum == 9 || rowNum == 10 || rowNum == 11 || rowNum == 12 || rowNum == 13 ||
                        rowNum == 14 || rowNum == 16 || rowNum == 17 || rowNum == 18 || rowNum == 19 || rowNum == 20 || rowNum == 21 ||
                        rowNum == 22 || rowNum == 23 || rowNum == 24 || rowNum == 25 || rowNum == 26 || rowNum == 27 || rowNum == 28 ||
                        rowNum == 29) {
                    brick.visibleActor(false, false);
                }
                if (rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 1 || rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 3 ||
                        rowNum == 15 && colNum == 5 || rowNum == 15 && colNum == 6 || rowNum == 15 && colNum == 7 || rowNum == 15 && colNum == 8 ||
                        rowNum == 15 && colNum == 9) {
                    brick.visibleActor(false, false);
                }
                if (rowNum == 15 && colNum == 4) {
                    brick.setColor(Color.RED);
                }
            }
        }

        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    @Override
    protected void ballsOverlaps() {
        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            for (BaseActor wall : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Wall")) {
                if (bal.overlaps(wall)) {
                    bal.bounceOff(wall); // отскакивание под углом
                    //wallBumpSound.play();
                }
            }
            if (bal.overlaps(paddle)) {
                //bounceSound.play();
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
                if (bal.overlaps(br) && br.brickVisible) {
                    bal.bounceOff(br);
                    //brickBumpSound.play();
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
                    // если зеленый шар косается кирпича, то (иногда) появляется Item
                    if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE)) {
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

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_20, "records_20"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 20, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_20, "records_20", attainmentColorLevel_20, "attainmentColorLevelMemory_20");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 31 && starTimer > 0) {
            createAttainment(20);
        }

        ballsOverlaps();

    }
}