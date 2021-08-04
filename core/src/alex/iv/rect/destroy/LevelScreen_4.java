package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_4 extends LevelScreenMain {

    public LevelScreen_4(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(200); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_4);
        quantityBricks(50, 5);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 18;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        int rowNum;
        for (rowNum = 0; rowNum < totalRows; rowNum++) {
            int colNum;
            for (colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);

                if (rowNum == 17 || rowNum == 15 || rowNum == 13 || rowNum == 11 || rowNum == 10 || rowNum == 9 || rowNum == 7 || rowNum == 6 || rowNum == 4) {
                    brick.remove();
                }
                if (rowNum == 16) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 14) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.mBrick = true;
                }
                if (rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 8 || rowNum == 12 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 12) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false); // инициализация метода смены цветов кирпича
                }
                if (rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 6) {
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 9) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 5 && colNum == 0 || rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 8 || rowNum == 5 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 5) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 6) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 3) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 1) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 9) {
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false); // инициализация метода смены цветов кирпича
                }
                if (rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 5 || rowNum == 0 && colNum == 7) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.mBrick = true;
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_4, "records_4"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 4, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_4, "records_4", attainmentColorLevel_4, "attainmentColorLevelMemory_4");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 6 && starTimer > 0) {
            createAttainment(4);
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED) && brick.mBrick) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

    }
}
