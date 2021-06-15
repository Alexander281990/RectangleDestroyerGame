package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.actors.Hindrance;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_8 extends LevelScreenMain {

    private Warp warpMain;
    private Warp warp1;
    private Warp warp2;
    private Warp warp3;
    private Warp warp4;

    public LevelScreen_8(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_8);

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
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0) {
                    warp1 = new Warp( x, y, mainStage);
                    Hindrance hindrance = new Hindrance(x, y, mainStage);
                    hindrance.setHindranceMoving(false);
                }
                if (rowNum == 0 && colNum == 9) {
                    warp2 = new Warp( x, y, mainStage);
                }
                /////////////////////////////////
                if (rowNum == 2 && colNum == 0) {
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 5 || rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 9) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.setBrickFlash(false);
                }
                //////////////////////////////////
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 6) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 5) {
                    brick.setColor(Color.GREEN);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 3 && colNum == 9) {
                    brick.remove();
                    warpMain = new Warp(x, y, "black_warp.png", mainStage);
                }
                //////////////////////////////////
                if (rowNum == 4 && colNum == 0 || rowNum == 4 && colNum == 8 || rowNum == 4 && colNum == 9 || rowNum == 4 && colNum == 3 || rowNum == 4 && colNum == 5) {
                    brick.remove();
                }
                if (rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 7) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 6) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                ////////////////////////////////
                if (rowNum == 5 && colNum == 0 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 6) {
                    brick.remove();
                }
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 8 || rowNum == 5 && colNum == 9) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 5) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                ///////////////////////////////////
                if (rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 5 || rowNum == 6 && colNum == 7 || rowNum == 6 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 6 && colNum == 1) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 6 || rowNum == 6 && colNum == 8) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                //////////////////////////////////////////
                if (rowNum == 7 && colNum == 0 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 6 || rowNum == 7 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 1) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 9) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                /////////////////////////////////
                if (rowNum == 8 || rowNum == 9 || rowNum == 10) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 9 && colNum == 1) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 8 && colNum == 2) {
                    warp3 = new Warp( x, y, mainStage);
                }
                if (rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 2 ||rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 5 ||rowNum == 10 && colNum == 6 ||rowNum == 10 && colNum == 8 ||rowNum == 10 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                /////////////////////////////////////
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 6 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                /////////////////////////////////////
                if (rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 1 ||  rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 12 && colNum == 6 || rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 12 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                //////////////////////////////////////
                if (rowNum == 14 && colNum != 9 || rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 4 || rowNum == 13 && colNum == 5 || rowNum == 13 && colNum == 6 || rowNum == 13 && colNum == 7 || rowNum == 13 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 14 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 2 || rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 5 || rowNum == 14 && colNum == 6 || rowNum == 14 && colNum == 7) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                //////////////////////////////////////
                if (rowNum == 15 && colNum == 1 || rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 3 || rowNum == 15 && colNum == 8 || rowNum == 15 && colNum == 7) {
                    brick.remove();
                }
                if (rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 7) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 15 && colNum == 4 || rowNum == 15 && colNum == 5 || rowNum == 15 && colNum == 6) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                //////////////////////////////
                if (rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 3 || rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 5 || rowNum == 16 && colNum == 6 || rowNum == 16 && colNum == 7 || rowNum == 16 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 7) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
                }
                if (rowNum == 16 && colNum == 0 || rowNum == 16 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                ////////////////////////////////
                if (rowNum == 17 && colNum == 1 || rowNum == 17 && colNum == 3 || rowNum == 17 && colNum == 5 || rowNum == 17 && colNum == 7 || rowNum == 17 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 17 && colNum == 0 || rowNum == 17 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 17 && colNum == 2 || rowNum == 17 && colNum == 4 || rowNum == 17 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.mBrick = true;
                }
                /////////////////////////////////
                if (rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 18 && colNum == 1 || rowNum == 18 && colNum == 3 || rowNum == 18 && colNum == 5 || rowNum == 18 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.mBrick = true;
                }
                /////////////////////////////////
                if (rowNum == 19 && colNum == 1 || rowNum == 19 && colNum == 2 || rowNum == 19 && colNum == 3 || rowNum == 19 && colNum == 4 || rowNum == 19 && colNum == 5 || rowNum == 19 && colNum == 6 || rowNum == 19 && colNum == 7 || rowNum == 19 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 19 && colNum == 0 || rowNum == 19 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 19 && colNum == 4) {
                    warp4 = new Warp( x, y, mainStage);
                }
                /////////////////////////////////
                if (rowNum == 20 && colNum == 1 || rowNum == 20 && colNum == 2 || rowNum == 20 && colNum == 3 || rowNum == 20 && colNum == 4 || rowNum == 20 && colNum == 5 || rowNum == 20 && colNum == 6 || rowNum == 20 && colNum == 7 || rowNum == 20 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 20 && colNum == 0 || rowNum == 20 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                //////////////////////////////////
                if (rowNum == 21 && colNum == 2 || rowNum == 21 && colNum == 4 || rowNum == 21 && colNum == 6 || rowNum == 21 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 21 && colNum == 0 || rowNum == 21 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 21 && colNum == 1 || rowNum == 21 && colNum == 3 || rowNum == 21 && colNum == 5 || rowNum == 21 && colNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.mBrick = true;
                }
                /////////////////////////////////
                if (rowNum == 22 && colNum == 1 || rowNum == 22 && colNum == 3 || rowNum == 22 && colNum == 5 || rowNum == 22 && colNum == 7 || rowNum == 22 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 22 && colNum == 0 || rowNum == 22 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 22 && colNum == 2 || rowNum == 22 && colNum == 4 || rowNum == 22 && colNum == 6) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.mBrick = true;
                }
                /////////////////////////////////
                if (rowNum == 23 && colNum == 1 || rowNum == 23 && colNum == 2 || rowNum == 23 && colNum == 3 || rowNum == 23 && colNum == 4 || rowNum == 23 && colNum == 5 || rowNum == 23 && colNum == 6 || rowNum == 23 && colNum == 7 || rowNum == 23 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 23 && colNum == 0 || rowNum == 23 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                //////////////////////////////////
                if (rowNum == 24) {
                    brick.setColor(Color.RED);
                }
            }
        }

    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_8, "records_8"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 8, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_8, "records_8");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED) && brick.mBrick || Color.rgb888(brick.getColor()) == Color.rgb888(Color.ORANGE) && brick.mBrick) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain)) {
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
