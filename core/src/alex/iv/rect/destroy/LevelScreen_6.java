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
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_6 extends LevelScreenMain {

    private Warp warpMain;
    private Warp warp2;
    private Warp warp3;
    private Warp warp4;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_6(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        //requestHandler.showBannerAd(); // при запуске LevelScreen_6 запускается рекламный банер в нижней части экрана
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        //background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_6);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 22;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 21) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 5) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 7 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                ////////////////////////
                if (rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                /////////////////////////
                if (rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5 || rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                /////////////////////////
                if (rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                /////////////////////////
                if (rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 5 || rowNum == 4 && colNum == 7 || rowNum == 4 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 4 && colNum == 0 || rowNum == 4 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 4 && colNum == 6 || rowNum == 4 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                /////////////////////////
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 5 && colNum == 0 || rowNum == 5 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 5 && colNum == 6 || rowNum == 5 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                /////////////////////////
                if (rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 5) {
                    brick.remove();
                }
                if (rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.numberColor = 1;
                }
                if (rowNum == 6 && colNum == 6 || rowNum == 6 && colNum == 7 || rowNum == 6 && colNum == 8 || rowNum == 6 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 4 && colNum == 4) {
                    warp2 = new Warp( x, y, mainStage);
                }
                ////////////////////////
                if (rowNum == 7 && colNum == 0 || rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 8 || rowNum == 7 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8 || rowNum == 8 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 8 || rowNum == 9 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 2 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 8 || rowNum == 10 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8 || rowNum == 11 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 8 || rowNum == 12 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 7 || rowNum == 13 && colNum == 8 || rowNum == 13 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 4 || rowNum == 13 && colNum == 5 || rowNum == 13 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////
                if (rowNum == 10 && colNum == 8) {
                    warpMain = new Warp(x, y, "black_warp.png", mainStage);
                }
                ///////////////////////////
                if (rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 5) {
                    brick.remove();
                }
                if (rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 1 || rowNum == 14 && colNum == 2 || rowNum == 14 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 14 && colNum == 6 || rowNum == 14 && colNum == 7 || rowNum == 14 && colNum == 8 || rowNum == 14 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                //////////////////////////////
                if (rowNum == 15 && colNum == 1 || rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 4 || rowNum == 15 && colNum == 5 || rowNum == 15 && colNum == 7 || rowNum == 15 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 15 && colNum == 6 || rowNum == 15 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ////////////////////////////////
                if (rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 5 || rowNum == 16 && colNum == 7 || rowNum == 16 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 16 && colNum == 0 || rowNum == 16 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 16 && colNum == 6 || rowNum == 16 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ////////////////////////////////
                if (rowNum == 17 && colNum == 1 || rowNum == 17 && colNum == 2 || rowNum == 17 && colNum == 4 || rowNum == 17 && colNum == 5 || rowNum == 17 && colNum == 7 || rowNum == 17 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 17 && colNum == 0 || rowNum == 17 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 17 && colNum == 6 || rowNum == 17 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ////////////////////////////////
                if (rowNum == 18 && colNum == 1 || rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 5 || rowNum == 18 && colNum == 7 || rowNum == 18 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ////////////////////////////////
                if (rowNum == 19 && colNum == 1 || rowNum == 19 && colNum == 2 || rowNum == 19 && colNum == 4 || rowNum == 19 && colNum == 5 || rowNum == 19 && colNum == 7 || rowNum == 19 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 19 && colNum == 0 || rowNum == 19 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 19 && colNum == 6 || rowNum == 19 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ////////////////////////////////
                if (rowNum == 20 && colNum == 4 || rowNum == 20 && colNum == 5) {
                    brick.remove();
                }
                if (rowNum == 20 && colNum == 0 || rowNum == 20 && colNum == 1 || rowNum == 20 && colNum == 2 || rowNum == 20 && colNum == 3) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 20 && colNum == 6 || rowNum == 20 && colNum == 7 || rowNum == 20 && colNum == 8 || rowNum == 20 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 18 && colNum == 1) {
                    warp3 = new Warp( x, y, mainStage);
                }
                //////////////////////////////
                if (rowNum == 18 && colNum == 7) {
                    warp4 = new Warp( x, y, mainStage);
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

//    // переопределили метод из класса LevelScreenMain();
//    @Override
//    public void ballsOverlaps() {
//        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
//            for (BaseActor wall : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Wall")) {
//                if (bal.overlaps(wall)) {
//                    bal.bounceOff(wall); // отскакивание под углом
//                    //wallBumpSound.play();
//                }
//            }
//            if (bal.overlaps(paddle)) {
//                //bounceSound.play();
//                float positionPaddle_Y = paddle.getY() + paddle.getHeight() / 2; // находим центр paddle по оси Y
//                float positionBall_Y = bal.getY() + bal.getHeight() / 2; // находим центр ball по оси Y
//                float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
//                float paddlePercentHit = (ballCenterX - paddle.getX()) / paddle.getWidth();
//                // если во время столкновения ось Y обьекта bal больше оси Y обьекта paddle, то мячь отскакивает и движется вверх. В противном случае - вниз
//                if (positionBall_Y > positionPaddle_Y) {
//                    bounceAngle = MathUtils.lerp(150, 30, paddlePercentHit);
//                } else {
//                    bounceAngle = MathUtils.lerp(-150, -30, paddlePercentHit);
//                }
//                bal.setMotionAngle(bounceAngle);
//
//            }
//
//            for (BaseActor brickHard : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.BrickHard")) {
//                if (bal.overlaps(brickHard)) {
//                    // если brickHardStatus = true, то мяч отскакивает от кирпича как от стен. А если brickHardStatus = false, то
//                    // мяч отскакивает от кирпича как от весла(paddle)
//                    if (brickHard.brickHardStatus) {
//                        bal.bounceOff(brickHard);
//                    } else {
//                        float positionBrickHard_Y = brickHard.getY() + brickHard.getHeight() / 2;
//                        float positionBall_Y = bal.getY() + bal.getHeight() / 2;
//                        float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
//                        float brickHardPercentHit = (ballCenterX - brickHard.getX()) / brickHard.getWidth();
//                        if (positionBall_Y > positionBrickHard_Y) {
//                            brickHardAngle = MathUtils.lerp(150, 30, brickHardPercentHit);
//                        } else {
//                            brickHardAngle = MathUtils.lerp(-150, -30, brickHardPercentHit);
//                        }
//                        bal.setMotionAngle(brickHardAngle);
//                    }
//                }
//            }
//
//            for (BaseActor hindrance : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Hindrance")) {
//                if (bal.overlaps(hindrance)) {
//                    // Если hindrance.brickHardStatus = true, то мяч от помехи будет отскакивать с обоих сторон
//                    // Если hindrance.brickHardStatus = false, то мяч от помехи будет отскакивать только с верхней стороны. Если мяч
//                    // коснется нижней стороны помехи, то она пропустит мяч на верхнюю свою сторону
//                    if (hindrance.brickHardStatus) {
//                        float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
//                        float hindrancePercentHit = (ballCenterX - hindrance.getX()) / hindrance.getWidth();
//                        hindranceAngle = MathUtils.lerp(150, 30, hindrancePercentHit);
//                        bal.setMotionAngle(hindranceAngle);
//                    } else {
//                        float positionHindrance_Y = hindrance.getY() + hindrance.getHeight() / 2;
//                        float positionBall_Y = bal.getY() + bal.getHeight() / 2;
//                        float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
//                        float hindrancePercentHit = (ballCenterX - hindrance.getX()) / hindrance.getWidth();
//                        if (positionBall_Y > positionHindrance_Y) {
//                            hindranceAngle = MathUtils.lerp(150, 30, hindrancePercentHit);
//                        } else {
//                            hindranceAngle = MathUtils.lerp(-150, -30, hindrancePercentHit);
//                        }
//                        bal.setMotionAngle(hindranceAngle);
//                    }
//                }
//            }
//
//            for (BaseActor br : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
//                if (bal.overlaps(br)) {
//                    bal.bounceOff(br);
//                    //brickBumpSound.play();
//                    if (Color.rgb888(br.getColor()) == Color.rgb888(Color.RED) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE) || Color.rgb888(br.getColor()) == Color.rgb888(Color.RED) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.RED)) {
//                        br.remove();
//                        switch (br.hit) {    // считает сколько раз попали по кирпичю, и добавляет очки за его дальнейшее уничтожение
//                            case 0:
//                                score += 50;
//                                break;
//                            case 1:
//                                score += 100;
//                                break;
//                            case 2:
//                                score += 150;
//                                break;
//                            case 3:
//                                score += 200;
//                                break;
//                            case 4:
//                                score += 250;
//                                break;
//                            default:
//                                score += 500;
//                                break;
//                        }
//                    } else if (Color.rgb888(br.getColor()) == Color.rgb888(Color.ORANGE) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE) || Color.rgb888(br.getColor()) == Color.rgb888(Color.ORANGE) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.ORANGE)) {
//                        br.hit ++;
//                        br.numberColor --;
//                        score += 10;
//                    } else if (Color.rgb888(br.getColor()) == Color.rgb888(Color.YELLOW) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE) || Color.rgb888(br.getColor()) == Color.rgb888(Color.YELLOW) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.YELLOW)) {
//                        br.hit ++;
//                        br.numberColor --;
//                        score += 10;
//                    } else if (Color.rgb888(br.getColor()) == Color.rgb888(Color.GREEN) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE) || Color.rgb888(br.getColor()) == Color.rgb888(Color.GREEN) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.GREEN)) {
//                        br.hit ++;
//                        br.numberColor --;
//                        score += 10;
//                    } else if (Color.rgb888(br.getColor()) == Color.rgb888(Color.BLUE) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE) || Color.rgb888(br.getColor()) == Color.rgb888(Color.BLUE) && Color.rgb888(bal.getColor()) == Color.rgb888(Color.BLUE)) {
//                        br.hit ++;
//                        br.numberColor --;
//                        score += 10;
//                    }
//                        switch (br.numberColor) {    // узнает по какому кирпичу было попадание, и меняет цветт в соответствии
//                            case 1:
//                                br.setColor(Color.RED);
//                                break;
//                            case 2:
//                                br.setColor(Color.ORANGE);
//                                break;
//                            case 3:
//                                br.setColor(Color.YELLOW);
//                                break;
//                            case 4:
//                                br.setColor(Color.GREEN);
//                                break;
//                            default:
//                        }
//                    scoreLabel.setText("Score " + score);
//                    // если белый шар косается кирпича, то (иногда) появляется Item
//                    if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE)) {
//                        float spawnProbability = 30; // частота появления Item
//                        if (MathUtils.random(0, 100) < spawnProbability) {
//                            Item i = new Item(0, 0, mainStage);
//                            i.centerAtActor(br);
//                        }
//                    }
//                }
//            }
//            // если ball вылетает за верхнюю или нижнюю границу экрана
//            if (bal.getY() < -50 && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0 ||
//                    bal.getY() > Gdx.graphics.getHeight() && BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") > 0) {
//                bal.remove();
//                if (Color.rgb888(bal.getColor()) == Color.rgb888(Color.WHITE)) {
//                    ball = new Ball(0,0,mainStage);
//                    ball.setColor(Color.WHITE);
//                    live --;
//                    if (live < 1) {
//                        //requestHandler.showVideoAd();
//                        RectangleGame.setActiveScreen(new GetLifeScreen(requestHandler));
//                    }
//                    pref.putInteger("liveMemory", live);
//                    pref.flush();
//                    // если небыло перекрытия paddle and PADDLE_STOP, то содаем кнопку start
//                    // если перекрытие было, то кнопка создасться как закончится время timerPaddleStop
//                    if (paddleStop) {
//                        // инициализация кнопки, которая отпускает шарик от весла
//                        final TextButton start = new TextButton("Start", BaseGame.textButtonStyle);
//                        start.setPosition(windowPlayWidth/2 - start.getWidth()/2,windowPlayHeight / 3.5f);
//                        uiStage.addActor(start);
//                        start.addListener(
//                                new EventListener() {
//                                    @Override
//                                    public boolean handle(Event e) {
//                                        if (!(e instanceof InputEvent) ||
//                                                !((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
//                                            return false;
//                                        startLevel();
//                                        start.remove();
//                                        return false;
//                                    }
//                                }
//                        );
//                    }
//                }
//            }
//        }
//    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_6, "records_6"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 6, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_6, "records_6", attainmentColorLevel_6, "attainmentColorLevelMemory_6");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 10 && starTimer > 0) {
            createAttainment(6);
        }

        if (starTimer < 120) {
            requestHandler.hideBannerAd(); // удаляет рекламный баннер
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain)) {
                int r = MathUtils.random(1, 3);
                if (r == 1) {
                    bal.centerAtActor(warp2);
                } else if (r == 2){
                    bal.centerAtActor(warp3);
                } else if (r == 3) {
                    bal.centerAtActor(warp4);
                }
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

//        ballsOverlaps();

    }
}
