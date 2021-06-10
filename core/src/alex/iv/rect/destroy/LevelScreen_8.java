package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_8 extends LevelScreenMain {

    private Warp warpMain1;
    private Warp warp1;
    private Warp warp2;
    private Warp warp3;
    private Warp warp4;

    public LevelScreen_8(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(90); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_8);

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
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 0 || rowNum == 1) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0) {
                    warp1 = new Warp( x, y, mainStage);
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
                    warpMain1 = new Warp(x, y, "black_warp.png", mainStage);
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
                if (rowNum == 10 && colNum != 0) {
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
                if (rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 12 && colNum == 6 || rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                //////////////////////////////////////
                if (rowNum == 14 && colNum != 9 || rowNum == 13) {
                    brick.remove();
                }
                if (rowNum == 14 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 1 || rowNum == 14 && colNum == 2 || rowNum == 14 && colNum == 3 || rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 5 || rowNum == 14 && colNum == 6 || rowNum == 14 && colNum == 7) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage);
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

    }
}
