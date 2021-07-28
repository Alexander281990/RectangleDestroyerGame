package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;

import alex.iv.rect.destroy.actors.Ball;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.BaseGame;
import alex.iv.rect.destroy.controller.GetLifeScreen;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.Item;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_21 extends LevelScreenMain {

    private ArrayList<Brick> bricks;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_21(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        bricks = new ArrayList<>();
        showTime(320); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_21);
        quantityBricks(455, 45);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 50;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                bricks.add(brick);
                if (rowNum == 15 || rowNum == 16 || rowNum == 17 || rowNum == 18){
                    brick.remove();
                    bricks.remove(brick);
                }
                if (rowNum == 5 || rowNum == 10 || rowNum == 19 || rowNum == 24 || rowNum == 29 || rowNum == 34 || rowNum == 39 ||
                        rowNum == 44 || rowNum == 49) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 1 || rowNum == 6 || rowNum == 11 || rowNum == 20 || rowNum == 25 || rowNum == 30 || rowNum == 35 ||
                        rowNum == 40 || rowNum == 45) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 2 || rowNum == 7 || rowNum == 12 || rowNum == 21 || rowNum == 26 || rowNum == 31 || rowNum == 36 ||
                        rowNum == 41 || rowNum == 46) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 3 || rowNum == 8 || rowNum == 13 || rowNum == 22 || rowNum == 27 || rowNum == 32 || rowNum == 37 ||
                        rowNum == 42 || rowNum == 47) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 4 || rowNum == 9 || rowNum == 14 || rowNum == 23 || rowNum == 28 || rowNum == 33 || rowNum == 38 ||
                        rowNum == 43 || rowNum == 48) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8) {
                    brick.remove();
                    bricks.remove(brick);
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 5 || rowNum == 0 && colNum == 7 || rowNum == 0 && colNum == 9) {
                    brick.setColor(Color.RED);
                }


            }
        }
        for (int i = 0; i < bricks.size(); i ++) {
            if (i != 304) {
                bricks.get(i).visibleActor(false, false);
            }
        }
        bricks.remove(304);

        //Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
        Gdx.app.log("MyTag", String.valueOf(bricks.size()));
    }

    private void emergenceBricks() {
        int r1 = MathUtils.random(0, bricks.size());
        int r2 = MathUtils.random(0, bricks.size());
        for (int i = 0; i < bricks.size(); i ++) {
            if (i == r1) {
                bricks.get(i).visibleActor(true, true);
                bricks.remove(i); // удаляем обьект из листа
                for (int t = 0; t < bricks.size(); t ++) {
                    if (t == r2) {
                        bricks.get(t).visibleActor(true, true);
                        bricks.remove(t); // удаляем обьект из листа
                    }
                }
            }
        }
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
                        emergenceBricks();
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
            timeIsUp(recordsLevel_21, "records_21"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 21, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_21, "records_21", attainmentColorLevel_21, "attainmentColorLevelMemory_21");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 46 && starTimer > 0) {
            createAttainment(21);
        }

        //Gdx.app.log("MyTag", String.valueOf(r1) + "-" + String.valueOf(r2));

    }
}