package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class LevelScreen_3 extends LevelScreenMain {

    public LevelScreen_3() {

    }

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_3(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(120);
        showRecordsLabelWindow(recordsLevel_3);

        Brick tempBrick = new Brick(0,0,mainStage);
        float brickWidth = Gdx.graphics.getWidth()/12;
        float brickHeight = tempBrick.getHeight();
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * brickWidth) / 2; float marginY = (Gdx.graphics.getHeight() - totalRows * brickHeight) - 250;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + brickWidth	* colNum;
                float y = marginY + brickHeight * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8){
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 9){
                    brick.remove();
                }
                if (colNum == 0 && rowNum == 2 || colNum == 0 && rowNum == 4 || colNum == 0 && rowNum == 6 || colNum == 0 && rowNum == 8){
                    brick.remove();
                }
                if (colNum == 9 && rowNum == 1 || colNum == 9 && rowNum == 3 || colNum == 9 && rowNum == 5 || colNum == 9 && rowNum == 7){
                    brick.remove();
                }
                ///////
                if (rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 5 || rowNum == 0 && colNum == 7 || rowNum == 0 && colNum == 9){
                    brick.setColor(Color.RED);
                }
                if (rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 6 || rowNum == 9 && colNum == 8){
                    brick.setColor(Color.RED);
                }
                if (colNum == 0 && rowNum == 1 || colNum == 0 && rowNum == 3 || colNum == 0 && rowNum == 5 || colNum == 0 && rowNum == 7){
                    brick.setColor(Color.RED);
                }
                if (colNum == 9 && rowNum == 0 || colNum == 9 && rowNum == 2 || colNum == 9 && rowNum == 4 || colNum == 9 && rowNum == 6 || colNum == 9 && rowNum == 8){
                    brick.setColor(Color.RED);
                }
                ////////
                if (rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 3 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 8 || rowNum == 1 && colNum == 9  ){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (colNum == 1 && rowNum == 2 || colNum == 1 && rowNum == 3 || colNum == 1 && rowNum == 4 || colNum == 1 && rowNum == 5 || colNum == 1 && rowNum == 6 || colNum == 1 && rowNum == 7){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (colNum == 8 && rowNum == 2 || colNum == 8 && rowNum == 3 || colNum == 8 && rowNum == 4 || colNum == 8 && rowNum == 5 || colNum == 8 && rowNum == 6 || colNum == 8 && rowNum == 7){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                ////////
                if (rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 7){
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 6 || rowNum == 7 && colNum == 7){
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (colNum == 2 && rowNum == 2 || colNum == 2 && rowNum == 3 || colNum == 2 && rowNum == 4 || colNum == 2 && rowNum == 5 || colNum == 2 && rowNum == 6 || colNum == 2 && rowNum == 7){
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (colNum == 7 && rowNum == 2 || colNum == 7 && rowNum == 3 || colNum == 7 && rowNum == 4 || colNum == 7 && rowNum == 5 || colNum == 7 && rowNum == 6 || colNum == 7 && rowNum == 7){
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                ////////////
                if (rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 6){
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 5 || rowNum == 6 && colNum == 6){
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (colNum == 3 && rowNum == 3 || colNum == 3 && rowNum == 4 || colNum == 3 && rowNum == 5 || colNum == 3 && rowNum == 6){
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (colNum == 6 && rowNum == 3 || colNum == 6 && rowNum == 4 || colNum == 6 && rowNum == 5 || colNum == 6 && rowNum == 6){
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                ////////////
                if (rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 5){
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 5){
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (colNum == 4 && rowNum == 4 || colNum == 4 && rowNum == 5){
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (colNum == 5 && rowNum == 4 || colNum == 5 && rowNum == 5){
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
            }
        }

    }

    public void update(float dt) {
        super.update(dt);

        timeIsUp(recordsLevel_3, "records_3");

        allTheBricksAreBroken(recordsLevel_3, "records_3");

    }
}
