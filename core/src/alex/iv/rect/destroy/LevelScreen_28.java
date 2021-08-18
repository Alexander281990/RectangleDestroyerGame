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