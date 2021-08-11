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

public class LevelScreen_14 extends LevelScreenMain {

    private Warp warpMain1;
    private Warp warpMain2;
    private Warp warpMain3;
    private Warp warp1;
    private Warp warp2;
    private Warp warp3;
    private Warp warp4;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_14(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_14);
        quantityBricks(207, 20);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 25;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 0 || rowNum == 1) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 2 && colNum == 3) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 2 && colNum == 4) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 2 && colNum == 8) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 2 && colNum == 9) {
                    brick.remove();
                    warpMain1 = new Warp(x, y, "black_warp.png", mainStage);
                }
                /////////////////
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 3 && colNum == 3) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 3 && colNum == 4) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 3 && colNum == 8) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 3 && colNum == 9) {
                    brick.remove();
                }
                //////////////////////////////////////
                if (rowNum == 4 && colNum == 0 || rowNum == 4 && colNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 4 && colNum == 3) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 4 && colNum == 4) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 4 && colNum == 8 || rowNum == 4 && colNum == 9) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                //////////////////////////////////////
                if (rowNum == 5 && colNum == 0 || rowNum == 5 && colNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 9) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 5 && colNum == 9) {
                    warp1 = new Warp( x, y, mainStage);
                }
                //////////////////////////////////////
                if (rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 8) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 6) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 5) {
                    brick.setColor(Color.BLUE);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 6 && colNum == 2) {
                    warp2 = new Warp( x, y, mainStage);
                }
                /////////////////////////////////////
                if (rowNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                /////////////////////////////////
                if (rowNum == 8) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.mBrick = true;
                }
                //////////////////////////////////////
                if (rowNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ///////////////////////////////////
                if (rowNum == 10 || rowNum == 11 || rowNum == 12) {
                    brick.setColor(Color.GREEN);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 10 && colNum == 5) {
                    brick.remove();
                    warpMain2 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 11 && colNum == 5) {
                    brick.remove();
                }
                /////////////////////////////////////
                if (rowNum == 13) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 13 && colNum == 1) {
                    warp3 = new Warp( x, y, mainStage);
                }
                ///////////////////////////////////////
                if (rowNum == 14) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.mBrick = true;
                }
                /////////////////////////////
                if (rowNum == 15) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 16 && colNum == 0 || rowNum == 16 && colNum == 3 || rowNum == 16 && colNum == 6 || rowNum == 16 && colNum == 9) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 5 || rowNum == 16 && colNum == 7 || rowNum == 16 && colNum == 8) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 16 && colNum == 5) {
                    warp4 = new Warp( x, y, mainStage);
                }
                //////////////////////////////////
                if (rowNum == 17 || rowNum == 18) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                ///////////////////////////
                if (rowNum == 19 && colNum == 0 || rowNum == 19 && colNum == 5) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 19 && colNum == 1 || rowNum == 19 && colNum == 6) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 19 && colNum == 2 || rowNum == 19 && colNum == 7) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 19 && colNum == 3 || rowNum == 19 && colNum == 8) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 19 && colNum == 4 || rowNum == 19 && colNum == 9) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                ////////////////////////////////////////////
                if (rowNum == 20 && colNum == 2 || rowNum == 20 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 20 && colNum == 3 || rowNum == 20 && colNum == 8) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 20 && colNum == 4 || rowNum == 20 && colNum == 9) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 20 && colNum == 0 || rowNum == 20 && colNum == 5) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 20 && colNum == 1 || rowNum == 20 && colNum == 6) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                ////////////////////////////////////////////
                if (rowNum == 21 && colNum == 4 || rowNum == 21 && colNum == 9) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 21 && colNum == 0 || rowNum == 21 && colNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 21 && colNum == 1 || rowNum == 21 && colNum == 6) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 21 && colNum == 2 || rowNum == 21 && colNum == 7) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 21 && colNum == 3 || rowNum == 21 && colNum == 8) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 21 && colNum == 0) {
                    brick.remove();
                    warpMain3 = new Warp(x, y, "black_warp.png", mainStage);
                }
                ////////////////////////////////////////////
                if (rowNum == 22 || rowNum == 23 || rowNum == 24) {
                    brick.remove();
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_14, "records_14"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 14, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_14");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_14"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 21 && starTimer > 0) {
            createAttainment(14);
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.ORANGE) && brick.mBrick ||
                    Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED) && brick.mBrick) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain1) || bal.overlaps(warpMain2) || bal.overlaps(warpMain3)) {
                int r = MathUtils.random(1, 4);
                if (r == 1) {
                    bal.centerAtActor(warp1);
                } else if (r == 2){
                    bal.centerAtActor(warp2);
                } else if (r == 3) {
                    bal.centerAtActor(warp3);
                } else if (r == 4) {
                    bal.centerAtActor(warp4);
                }
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

    }
}