package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_2 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_2(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(80); // инициализируем метод отображение игрового времени
        quantityBricks(10, 1);
        showModalScreen(2, recordsLevel_2, "rules_level_screen/level_screen_2_ru.txt",
                "rules_level_screen/level_screen_2.txt");

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 1;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 250;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                brick.setColor(Color.ORANGE);
                brick.numberColor = 2;
            }
        }
        //Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_2, "records_2"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 2, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_2");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_2"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 2 && starTimer > 0) {
            createAttainment(2);
        }

        for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
            if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED)) {
                brick.leftRightMoving(0, 2, 800, 900, 0, 180);
            }
        }

    }
}
