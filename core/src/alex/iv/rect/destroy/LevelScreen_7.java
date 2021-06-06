package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_7 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_7(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(100); // инициализируем метод отображение игрового времени
        //background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_7);


        Brick tempBrick = new Brick(0, 0, mainStage);
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 150;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                brick.setColor(Color.ORANGE);
                brick.numberColor = 2;
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8){
                    brick.remove();
                }
                if (rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 3 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 9){
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 8){
                    brick.remove();
                }
                if (rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 9){
                    brick.remove();
                }
                if (rowNum == 4 && colNum == 0 || rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 6 || rowNum == 4 && colNum == 8){
                    brick.remove();
                }
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 9){
                    brick.remove();
                }
                if (rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 6 || rowNum == 6 && colNum == 8){
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 9){
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 8){
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 9){
                    brick.remove();
                }
            }
        }

    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_7, "records_7"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 7, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_7, "records_7");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED)) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

    }

}
