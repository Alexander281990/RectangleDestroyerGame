package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class LevelScreen_5 extends LevelScreenMain {

    public LevelScreen_5() {

    }

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_5(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void initialize() {
        super.initialize();

        showTime(120);
        showRecordsLabelWindow(recordsLevel_5);

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
                    brick.setBrickMoving(false);
                } else {
                    brick.setColor(Color.RED);
                }
            }
        }

    }

    @Override
    public void update(float dt) {
        super.update(dt);

        timeIsUp(recordsLevel_5, "records_5");
        allTheBricksAreBroken(recordsLevel_5, "records_5");

    }
}
