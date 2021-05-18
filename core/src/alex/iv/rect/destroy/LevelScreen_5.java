package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_5 extends LevelScreenMain {
    //public IActivityRequestHandler requestHandler;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_5(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        //this.requestHandler = requestHandler;
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(100); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_5);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 8;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 150;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (colNum == 0 || colNum == 9){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                } else {
                    brick.setColor(Color.RED);
                }
            }
        }
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_5, "records_5"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 5, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_5, "records_5");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

    }
}
