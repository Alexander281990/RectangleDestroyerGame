package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_7 extends LevelScreenMain {
    //public IActivityRequestHandler requestHandler;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_7(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(240); // инициализируем метод отображение игрового времени
        quantityBricks(108, 11);
        showModalScreen(7, recordsLevel_7, "rules_level_screen/level_screen_7_ru.txt",
                "rules_level_screen/level_screen_7.txt");

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 20;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 150;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );

                if (rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 3 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 ||
                        rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 8 || rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 8 ||
                        rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 6 ||
                        rowNum == 3 && colNum == 8 || rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 3 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 6 ||
                        rowNum == 4 && colNum == 8 || rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 6 ||
                        rowNum == 5 && colNum == 8 || rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 6 ||
                        rowNum == 6 && colNum == 8 || rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 6 ||
                        rowNum == 7 && colNum == 8 || rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 6 ||
                        rowNum == 8 && colNum == 8 || rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 6 ||
                        rowNum == 9 && colNum == 8 || rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 6 ||
                        rowNum == 10 && colNum == 8 || rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 6 ||
                        rowNum == 11 && colNum == 8 || rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 6 ||
                        rowNum == 12 && colNum == 8 || rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 5 || rowNum == 13 && colNum == 6 ||
                        rowNum == 13 && colNum == 8 || rowNum == 14 && colNum == 1 || rowNum == 14 && colNum == 3 || rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 6 ||
                        rowNum == 14 && colNum == 8 || rowNum == 15 && colNum == 1 || rowNum == 15 && colNum == 3 || rowNum == 15 && colNum == 5 || rowNum == 15 && colNum == 6 ||
                        rowNum == 15 && colNum == 8 || rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 3 || rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 6 ||
                        rowNum == 16 && colNum == 8 || rowNum == 16 && colNum == 5 || rowNum == 17 && colNum == 1 || rowNum == 17 && colNum == 8 || rowNum == 18 && colNum == 1 ||
                        rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 3 || rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 5 || rowNum == 18 && colNum == 6 ||
                        rowNum == 18 && colNum == 7 || rowNum == 18 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 0 || rowNum == 19) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (colNum == 0 || colNum == 9) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5 || rowNum == 2 && colNum == 6 ||
                        rowNum == 2 && colNum == 7 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 7 || rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 7 ||
                        rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 7 || rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 7 || rowNum == 7 && colNum == 2 ||
                        rowNum == 7 && colNum == 7 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 7 || rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 7 ||
                        rowNum == 10 && colNum == 2 || rowNum == 10 && colNum == 7 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 2 || rowNum == 12 && colNum == 2 ||
                        rowNum == 12 && colNum == 7 || rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 7 || rowNum == 14 && colNum == 2 || rowNum == 14 && colNum == 7 ||
                        rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 7 || rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 7 || rowNum == 17 && colNum == 2 ||
                        rowNum == 17 && colNum == 3 || rowNum == 17 && colNum == 4 || rowNum == 17 && colNum == 5 || rowNum == 17 && colNum == 6 || rowNum == 17 && colNum == 7) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 4 && colNum == 5 || rowNum == 5 && colNum == 4 || rowNum == 6 && colNum == 5 || rowNum == 7 && colNum == 4 || rowNum == 8 && colNum == 5 ||
                        rowNum == 9 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 11 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 13 && colNum == 4 ||
                        rowNum == 14 && colNum == 5 || rowNum == 15 && colNum == 4) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_7, "records_7"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 7, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_7");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_7"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 12 && starTimer > 0) {
            createAttainment(7);
        }

    }
}
