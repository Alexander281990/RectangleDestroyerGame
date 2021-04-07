package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.MenuScreen;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_1 extends LevelScreenMain {

    public IActivityRequestHandler requestHandler;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_1(IActivityRequestHandler requestHandler) {
        //super(requestHandler);
        this.requestHandler = requestHandler;
    }

    public void initialize() {
        super.initialize();

        showTime(30); // инициализируем метод отображение игрового времени
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

        if (starTimer < 0) {
            timeIsUp(recordsLevel_1, "records_1"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_1, "records_1");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

    }
}
