package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.actors.Paddle;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_16 extends LevelScreenMain {

    private Paddle paddle_2;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_16(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        paddle_2 = new Paddle(paddle.getX(), 50, mainStage);
        showTime(200); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_16);
        quantityBricks(95, 9);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 24;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                if (rowNum == 0 || rowNum == 1 || rowNum == 2) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 3 ||
                        rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 8 || rowNum == 3 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 3 || rowNum == 4 && colNum == 4 ||
                        rowNum == 4 && colNum == 5 || rowNum == 4 && colNum == 6 || rowNum == 4 && colNum == 7 || rowNum == 4 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 4 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 4 && colNum == 0) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 5 && colNum == 0 || rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 3 ||
                        rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 8 ||
                        rowNum == 5 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 5 && colNum == 6) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 6 ||
                        rowNum == 6 && colNum == 5 || rowNum == 6 && colNum == 7 || rowNum == 6 && colNum == 8 ||
                        rowNum == 6 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 2) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 7 && colNum == 0 || rowNum == 7 && colNum == 3  || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 6 ||
                        rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 8 || rowNum == 7 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 2) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 7 && colNum == 4) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5 ||
                        rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 5 ||
                        rowNum == 9 && colNum == 6 || rowNum == 9 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 2) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 2 || rowNum == 10 && colNum == 3 ||
                        rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 3 ||
                        rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 6 || rowNum == 11 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 11 && colNum == 1) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 12) {
                    brick.remove();
                }
                if (rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 4 || rowNum == 13 && colNum == 6 ||
                        rowNum == 13 && colNum == 7 || rowNum == 13 && colNum == 8 || rowNum == 13 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 3) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 13 && colNum == 5) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 1 || rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 6 ||
                        rowNum == 14 && colNum == 5 || rowNum == 14 && colNum == 8 || rowNum == 14 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 14 && colNum == 3 || rowNum == 14 && colNum == 2) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 14 && colNum == 7) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 14 && colNum == 0) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 1 || rowNum == 15 && colNum == 4 || rowNum == 15 && colNum == 5 ||
                        rowNum == 15 && colNum == 6 || rowNum == 15 && colNum == 7 || rowNum == 15 && colNum == 8 || rowNum == 15 && colNum == 9 ||
                        rowNum == 16 && colNum == 0 || rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 5 ||
                        rowNum == 16 && colNum == 6 || rowNum == 16 && colNum == 7 || rowNum == 16 && colNum == 8 || rowNum == 16 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 15 && colNum == 3 || rowNum == 15 && colNum == 2 || rowNum == 16 && colNum == 3 || rowNum == 16 && colNum == 2) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 17 && colNum == 0 || rowNum == 17 && colNum == 1 || rowNum == 17 && colNum == 2 || rowNum == 17 && colNum == 3 ||
                        rowNum == 17 && colNum == 4 || rowNum == 17 && colNum == 5 || rowNum == 17 && colNum == 8 || rowNum == 17 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 17 && colNum == 6 || rowNum == 17 && colNum == 7) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 3 || rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 5 ||
                        rowNum == 18 && colNum == 8 || rowNum == 18 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 18 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 1) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 7) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 19 && colNum == 2 || rowNum == 19 && colNum == 4 || rowNum == 19 && colNum == 5 ||
                        rowNum == 19 && colNum == 8 || rowNum == 19 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 19 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 19 && colNum == 0 || rowNum == 19 && colNum == 1) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 19 && colNum == 6 || rowNum == 19 && colNum == 7) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 20 && colNum == 2 || rowNum == 20 && colNum == 3 || rowNum == 20 && colNum == 4 || rowNum == 20 && colNum == 5 ||
                        rowNum == 20 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 20 && colNum == 8) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 20 && colNum == 0 || rowNum == 20 && colNum == 1) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 20 && colNum == 6 || rowNum == 20 && colNum == 7) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 21 && colNum == 2 || rowNum == 21 && colNum == 4 || rowNum == 21 && colNum == 5 || rowNum == 21 && colNum == 6 ||
                        rowNum == 21 && colNum == 7 || rowNum == 21 && colNum == 8 || rowNum == 21 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 21 && colNum == 0 || rowNum == 21 && colNum == 1) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 21 && colNum == 3) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 22 && colNum == 0 || rowNum == 22 && colNum == 1 || rowNum == 22 && colNum == 2 || rowNum == 22 && colNum == 3 ||
                        rowNum == 22 && colNum == 6 || rowNum == 22 && colNum == 7 || rowNum == 22 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 22 && colNum == 4 || rowNum == 22 && colNum == 5) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 22 && colNum == 9) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 23) {
                    brick.setColor(Color.RED);
                }


            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_16, "records_16"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 16, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_16, "records_16", attainmentColorLevel_16, "attainmentColorLevelMemory_16");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 10 && starTimer > 0) {
            createAttainment(16);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        // метод, который заставляет отскакивать мячики от дополнительного весла(конец)
///////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}