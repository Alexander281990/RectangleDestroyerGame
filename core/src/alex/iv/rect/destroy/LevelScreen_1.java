package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class LevelScreen_1 extends LevelScreenMain {

    public void initialize() {
        super.initialize();

        showTime(80); // инициализируем метод отображение игрового времени
        showRecordsLabelWindow(recordsLevel_1); // инициализируем метод отображение рекорда данного уровня

        Brick tempBrick = new Brick(0,0,mainStage);
        float brickWidth = tempBrick.getWidth();
        float brickHeight = tempBrick.getHeight();
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * brickWidth) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * brickHeight) - 150;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + brickWidth	* colNum;
                float y = marginY + brickHeight * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 5 || rowNum == 6 || rowNum == 7 || rowNum == 8 || rowNum == 9){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                } else {
                    brick.setColor(Color.RED);
                }
            }
        }

    }

    public void update(float dt) {
        super.update(dt);

        timeIsUp(recordsLevel_1, "records_1"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
        allTheBricksAreBroken(recordsLevel_1, "records_1");

    }
}
