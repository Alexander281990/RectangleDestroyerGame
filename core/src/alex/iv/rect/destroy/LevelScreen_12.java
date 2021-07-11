package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_12 extends LevelScreenMain {

    private Warp warpMain;
    private Warp warp2;
    private Warp warp3;
    private Warp warp4;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_12(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        //requestHandler.showBannerAd(); // при запуске LevelScreen_6 запускается рекламный банер в нижней части экрана
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_12);
        quantityBricks(99, 10);

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
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum < 27) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 25 && colNum == 0 || rowNum == 25 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 25 && colNum == 8) {
                    warp2 = new Warp( x, y, mainStage);
                }
                if (rowNum == 27 && colNum == 1 || rowNum == 27 && colNum == 3 || rowNum == 27 && colNum == 4 || rowNum == 27 && colNum == 5 || rowNum == 27 && colNum == 6 || rowNum == 27 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 27 && colNum == 0 || rowNum == 27 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 27 && colNum == 2 || rowNum == 27 && colNum == 7) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 28 && colNum == 0 || rowNum == 28 && colNum == 1 || rowNum == 28 && colNum == 2 || rowNum == 28 && colNum == 4 || rowNum == 28 && colNum == 5 || rowNum == 28 && colNum == 7 || rowNum == 28 && colNum == 8 || rowNum == 28 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 28 && colNum == 3 || rowNum == 28 && colNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 29 && colNum == 1 || rowNum == 29 && colNum == 2 || rowNum == 29 && colNum == 3 || rowNum == 29 && colNum == 6 || rowNum == 29 && colNum == 7 || rowNum == 29 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 29 && colNum == 0 || rowNum == 29 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 29 && colNum == 4 || rowNum == 29 && colNum == 5) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 30 || rowNum == 31) {
                    brick.remove();
                }
                if (rowNum == 30 && colNum == 0) {
                    warpMain = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 32 && colNum == 0 || rowNum == 32 && colNum == 1 || rowNum == 32 && colNum == 2 || rowNum == 32 && colNum == 4 || rowNum == 32 && colNum == 5 || rowNum == 32 && colNum == 7 || rowNum == 32 && colNum == 8 || rowNum == 32 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 32 && colNum == 0 || rowNum == 32 && colNum == 1 || rowNum == 32 && colNum == 2 ||  rowNum == 32 && colNum == 7 || rowNum == 32 && colNum == 8 || rowNum == 32 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 32 && colNum == 3 || rowNum == 32 && colNum == 6) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 33) {
                    brick.remove();
                }
                if (rowNum == 34 && colNum == 1 || rowNum == 34 && colNum == 3 || rowNum == 34 && colNum == 5 || rowNum == 34 && colNum == 7 || rowNum == 34 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 34 && colNum == 0 || rowNum == 34 && colNum == 2 || rowNum == 34 && colNum == 4 || rowNum == 34 && colNum == 6 || rowNum == 34 && colNum == 8) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.mBrick = true;
                }
                if (rowNum == 35 && colNum == 0 || rowNum == 35 && colNum == 2 || rowNum == 35 && colNum == 4 || rowNum == 35 && colNum == 6 || rowNum == 35 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 35 && colNum == 1 || rowNum == 35 && colNum == 3 || rowNum == 35 && colNum == 5 || rowNum == 35 && colNum == 7 || rowNum == 35 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.mBrick = true;
                }
                if (rowNum == 36 && colNum == 1 || rowNum == 36 && colNum == 3 || rowNum == 36 && colNum == 5 || rowNum == 36 && colNum == 7 || rowNum == 36 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 36 && colNum == 0 || rowNum == 36 && colNum == 2 || rowNum == 36 && colNum == 4 || rowNum == 36 && colNum == 6 || rowNum == 36 && colNum == 8) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.mBrick = true;
                }
                if (rowNum == 37) {
                    brick.remove();
                }
                if (rowNum == 38) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 39) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 40) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 41 && colNum == 0 || rowNum == 41 && colNum == 3 || rowNum == 41 && colNum == 4 || rowNum == 41 && colNum == 5 || rowNum == 41 && colNum == 6 || rowNum == 41 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 41 && colNum == 1 || rowNum == 41 && colNum == 8) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage,true);
                }
                if (rowNum == 41 && colNum == 2 || rowNum == 41 && colNum == 7) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 42 && colNum == 2 || rowNum == 42 && colNum == 4 || rowNum == 42 && colNum == 5 || rowNum == 42 && colNum == 7) {
                    brick.remove();
                }
                if (rowNum == 42 && colNum == 0 || rowNum == 42 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 42 && colNum == 3 || rowNum == 42 && colNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 42 && colNum == 1 || rowNum == 42 && colNum == 8) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 43 && colNum == 0 || rowNum == 43 && colNum == 2 || rowNum == 43 && colNum == 3 || rowNum == 43 && colNum == 6 || rowNum == 43 && colNum == 7 || rowNum == 43 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 43 && colNum == 1 || rowNum == 43 && colNum == 8) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 43 && colNum == 4 || rowNum == 43 && colNum == 5) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 44 && colNum == 0 || rowNum == 44 && colNum == 2 || rowNum == 44 && colNum == 4 || rowNum == 44 && colNum == 5 || rowNum == 44 && colNum == 7 || rowNum == 44 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 44 && colNum == 1 || rowNum == 44 && colNum == 8) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 44 && colNum == 3 || rowNum == 44 && colNum == 6) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 45 && colNum == 0 || rowNum == 45 && colNum == 1 || rowNum == 45 && colNum == 3 || rowNum == 45 && colNum == 4 || rowNum == 45 && colNum == 5 || rowNum == 45 && colNum == 6 || rowNum == 45 && colNum == 8 || rowNum == 45 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 45 && colNum == 2 || rowNum == 45 && colNum == 7) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 46 && colNum == 0 || rowNum == 46 && colNum == 1 || rowNum == 46 && colNum == 3 || rowNum == 46 && colNum == 4 || rowNum == 46 && colNum == 5 || rowNum == 46 && colNum == 6 || rowNum == 46 && colNum == 8 || rowNum == 46 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 46 && colNum == 2 || rowNum == 46 && colNum == 7) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 47 || rowNum == 48 || rowNum == 49) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 45 && colNum == 1) {
                    warp3 = new Warp( x, y, mainStage);
                }
                if (rowNum == 45 && colNum == 8) {
                    warp4 = new Warp( x, y, mainStage);
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_12, "records_12"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 12, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_12, "records_12", attainmentColorLevel_12, "attainmentColorLevelMemory_12");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 11 && starTimer > 0) {
            createAttainment(12);
        }
        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED) && brick.mBrick) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
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

    }
}