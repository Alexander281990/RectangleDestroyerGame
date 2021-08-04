package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.actors.Hindrance;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_15 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_15(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(240); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_15);
        quantityBricks(68, 7);

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
                if (rowNum == 0 || rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5 || rowNum == 6 ||
                        rowNum == 12 || rowNum == 13 || rowNum == 14 || rowNum == 16 || rowNum == 18 || rowNum == 20 ||
                        rowNum == 22 || rowNum == 24) {
                    brick.remove();
                }
                if (rowNum == 13 && colNum == 0) {
                    Hindrance hindrance = new Hindrance(x, y, mainStage, true);
                    hindrance.setHindranceMoving(false);
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8) {
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 8) {
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 8) {
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 8) {
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 6) {
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 6) {
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 6 ||
                        rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 0 || rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 5 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 4 ||
                        rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 8 || rowNum == 9 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 6) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 2 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 6 ||
                        rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 8) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 15) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 17) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 19) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 21) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
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
            timeIsUp(recordsLevel_15, "records_15"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 15, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_15, "records_15", attainmentColorLevel_15, "attainmentColorLevelMemory_15");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 8 && starTimer > 0) {
            createAttainment(15);
        }

    }
}
