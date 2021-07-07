package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_10 extends LevelScreenMain {

    public LevelScreen_10(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        //this.requestHandler = requestHandler;
    }

    public void initialize() {
        super.initialize();

        showTime(180); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_10);

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
                if (rowNum == 15 || rowNum == 16 || rowNum == 17 || rowNum == 18){
                    brick.remove();
                }
                if (rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5 || rowNum == 6 || rowNum == 7 ||
                        rowNum == 8 || rowNum == 9 || rowNum == 10 || rowNum == 11 || rowNum == 12 || rowNum == 13 || rowNum == 14 ||
                        rowNum == 20 || rowNum == 21 || rowNum == 22 || rowNum == 23 || rowNum == 24 || rowNum == 25 || rowNum == 26 ||
                        rowNum == 27 || rowNum == 28 || rowNum == 29 || rowNum == 30 || rowNum == 31 || rowNum == 32 || rowNum == 33 ||
                        rowNum == 34 || rowNum == 35 || rowNum == 36 || rowNum == 37 || rowNum == 38 || rowNum == 39 || rowNum == 40 ||
                        rowNum == 41 || rowNum == 42 || rowNum == 43 || rowNum == 44 || rowNum == 45 || rowNum == 46 || rowNum == 47 ||
                        rowNum == 48 || rowNum == 49 || rowNum == 19){
                    brick.setColor(Color.RED);
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8) {
                    brick.remove();
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 5 || rowNum == 0 && colNum == 7 || rowNum == 0 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
            }
        }

        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_10, "records_10"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 10, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_10, "records_10", attainmentColorLevel_10, "attainmentColorLevelMemory_10");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 46 && starTimer > 0) {
            createAttainment(10);
        }

    }
}
