package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_4 extends LevelScreenMain {
    public IActivityRequestHandler requestHandler;
    private Brick brick;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_4(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        this.requestHandler = requestHandler;
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(80); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_4);

        //        ball = new Ball(0, 0, mainStage)
//        //numberBalls = 0;
//        boolBalls = false;

//        Brick tempBrick = new Brick(0,0,mainStage);
//        float brickWidth = windowPlayWidth/11;
//        float brickHeight = tempBrick.getHeight();
//        tempBrick.remove();
//        int totalRows = 10;
//        int totalCols = 10;
//        float marginX = (windowPlayWidth - totalCols * brickWidth) / 2;
//        float marginY = windowPlayHeight;
//        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
//            for (int colNum = 0; colNum < totalCols; colNum++) {
//                float x = marginX + brickWidth	* colNum;
//                float y = marginY + brickHeight * rowNum;
//                new Brick( x, y, mainStage );
//            }
//        }
        Brick tempBrick = new Brick(0,0,mainStage);
        float brickWidth = Gdx.graphics.getWidth()/11f;
        float brickHeight = tempBrick.getHeight();
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 1;
        float marginX = (Gdx.graphics.getWidth() - totalCols * brickWidth) / 2; float marginY = (Gdx.graphics.getHeight() - totalRows * brickHeight) - 250;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + brickWidth	* colNum;
                float y = marginY + brickHeight * rowNum;
                brick = new Brick( x, y, mainStage );
                //brick.setBrickMoving(false);
                brick.setColor(Color.ORANGE);
                brick.numberColor = 2;
            }
        }
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_4, "records_4"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 4, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_4, "records_4");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED)) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

    }
}