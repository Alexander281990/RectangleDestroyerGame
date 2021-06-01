package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_9 extends LevelScreenMain {

    public LevelScreen_9(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_9);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 12;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 150;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                brick.setColor(Color.YELLOW);
                brick.numberColor = 3;
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 7 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 3 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 8 || rowNum == 1 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 6 ||rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 5 || rowNum == 4 && colNum == 7 || rowNum == 4 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 6 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 6 || rowNum == 6 && colNum == 7 || rowNum == 6 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 6 || rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 6 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 8 || rowNum == 10 && colNum == 9) {
                    brick.remove();
                }
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8 || rowNum == 11 && colNum == 9) {
                    brick.remove();
                } else {
                    brick.setBrickFlash(false);
                }
            }
        }

    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_9, "records_9"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 9, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_9, "records_9");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

    }
}