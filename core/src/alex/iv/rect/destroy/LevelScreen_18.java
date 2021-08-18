package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_18 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_18(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        super.paddle.setSize( paddle.getWidth() * 2,Gdx.graphics.getHeight() / 60f);
        super.paddle.setBoundaryRectangle();
        background.loadTexture("background/fon_level.png");
        showTime(200); // инициализируем метод отображение игрового времени
        quantityBricks(101, 10);
        showModalScreen(18, recordsLevel_18, "rules_level_screen/level_screen_18_ru.txt",
                "rules_level_screen/level_screen_18.txt");

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 30;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 5 ||
                        rowNum == 0 && colNum == 6 || rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 2 ||
                        rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 8 || rowNum == 1 && colNum == 9 ||
                        rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 5 ||
                        rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 9 || rowNum == 3 && colNum == 0 ||
                        rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 4 ||
                        rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 8 || rowNum == 4 && colNum == 0 ||
                        rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 5 || rowNum == 4 && colNum == 6 ||
                        rowNum == 4 && colNum == 7 || rowNum == 4 && colNum == 9 || rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 2 ||
                        rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 6 || rowNum == 5 && colNum == 7 ||
                        rowNum == 5 && colNum == 8 || rowNum == 5 && colNum == 9 || rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 1 ||
                        rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 5 || rowNum == 6 && colNum == 7 ||
                        rowNum == 6 && colNum == 8 || rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 4 ||
                        rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 7 || rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 1 ||
                        rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 6 ||
                        rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 8 || rowNum == 8 && colNum == 9 || rowNum == 9 && colNum == 0 ||
                        rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 6 ||
                        rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 5 ||
                        rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 8 || rowNum == 10 && colNum == 9 ||
                        rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 5 ||
                        rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8 || rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 1 ||
                        rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 12 && colNum == 6 ||
                        rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 9 || rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 4 ||
                        rowNum == 13 && colNum == 9 || rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 1 || rowNum == 14 && colNum == 2 ||
                        rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 5 || rowNum == 14 && colNum == 6 || rowNum == 14 && colNum == 8 ||
                        rowNum == 14 && colNum == 9 || rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 3 ||
                        rowNum == 15 && colNum == 5 || rowNum == 15 && colNum == 6 || rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 2 ||
                        rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 5 || rowNum == 16 && colNum == 6 || rowNum == 16 && colNum == 8 ||
                        rowNum == 16 && colNum == 9 || rowNum == 17 && colNum == 0 || rowNum == 17 && colNum == 1 || rowNum == 17 && colNum == 3 ||
                        rowNum == 17 && colNum == 4 || rowNum == 17 && colNum == 6 || rowNum == 17 && colNum == 7 || rowNum == 17 && colNum == 8 ||
                        rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 1 || rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 4 ||
                        rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 8 || rowNum == 18 && colNum == 9 || rowNum == 19 && colNum == 0 ||
                        rowNum == 19 && colNum == 3 || rowNum == 19 && colNum == 4 || rowNum == 19 && colNum == 6 || rowNum == 19 && colNum == 7 ||
                        rowNum == 19 && colNum == 9 || rowNum == 20 && colNum == 0 || rowNum == 20 && colNum == 1 || rowNum == 20 && colNum == 2 ||
                        rowNum == 20 && colNum == 4 || rowNum == 20 && colNum == 6 || rowNum == 21 && colNum == 0 || rowNum == 21 && colNum == 2 ||
                        rowNum == 21 && colNum == 3 || rowNum == 21 && colNum == 5 || rowNum == 21 && colNum == 6 || rowNum == 21 && colNum == 7 ||
                        rowNum == 21 && colNum == 9 || rowNum == 22 && colNum == 0 || rowNum == 22 && colNum == 1 || rowNum == 22 && colNum == 3 ||
                        rowNum == 22 && colNum == 4 || rowNum == 22 && colNum == 5 || rowNum == 22 && colNum == 7 || rowNum == 22 && colNum == 9 ||
                        rowNum == 23 && colNum == 1 || rowNum == 23 && colNum == 2 || rowNum == 23 && colNum == 3 || rowNum == 23 && colNum == 5 ||
                        rowNum == 23 && colNum == 6 || rowNum == 23 && colNum == 7 || rowNum == 24 && colNum == 0 || rowNum == 24 && colNum == 1 ||
                        rowNum == 24 && colNum == 2 || rowNum == 24 && colNum == 4 || rowNum == 24 && colNum == 5 || rowNum == 24 && colNum == 6 ||
                        rowNum == 25 && colNum == 0 || rowNum == 25 && colNum == 1 || rowNum == 25 && colNum == 3 || rowNum == 25 && colNum == 4 ||
                        rowNum == 25 && colNum == 6 || rowNum == 25 && colNum == 7 || rowNum == 25 && colNum == 8 || rowNum == 26 && colNum == 0 ||
                        rowNum == 26 && colNum == 2 || rowNum == 26 && colNum == 3 || rowNum == 26 && colNum == 5 || rowNum == 26 && colNum == 6 ||
                        rowNum == 26 && colNum == 7 || rowNum == 26 && colNum == 9 || rowNum == 27 && colNum == 0 || rowNum == 27 && colNum == 1 ||
                        rowNum == 27 && colNum == 2 || rowNum == 27 && colNum == 3 || rowNum == 27 && colNum == 5 || rowNum == 27 && colNum == 6 ||
                        rowNum == 27 && colNum == 8 || rowNum == 27 && colNum == 9 || rowNum == 28 && colNum == 0 || rowNum == 28 && colNum == 1 ||
                        rowNum == 28 && colNum == 2 || rowNum == 28 && colNum == 3 || rowNum == 28 && colNum == 5 || rowNum == 28 && colNum == 7 ||
                        rowNum == 28 && colNum == 8 || rowNum == 28 && colNum == 9 || rowNum == 29 && colNum == 3 || rowNum == 29 && colNum == 4 ||
                        rowNum == 29 && colNum == 5 || rowNum == 29 && colNum == 6 || rowNum == 29 && colNum == 7) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 8 || rowNum == 1 && colNum == 4 || rowNum == 3 && colNum == 9 || rowNum == 5 && colNum == 4 ||
                        rowNum == 7 && colNum == 9 || rowNum == 8 && colNum == 5 || rowNum == 9 && colNum == 1 || rowNum == 11 && colNum == 2 ||
                        rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 7 || rowNum == 15 && colNum == 7 || rowNum == 17 && colNum == 5 ||
                        rowNum == 18 && colNum == 5 || rowNum == 19 && colNum == 1 || rowNum == 20 && colNum == 3 || rowNum == 22 && colNum == 6 ||
                        rowNum == 23 && colNum == 0 || rowNum == 25 && colNum == 9 || rowNum == 26 && colNum == 1 || rowNum == 29 && colNum == 9) {
                    brick.setColor(Color.RED);
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 0 && colNum == 7 || rowNum == 1 && colNum == 3 || rowNum == 3 && colNum == 6 || rowNum == 5 && colNum == 0 ||
                        rowNum == 7 && colNum == 8 || rowNum == 9 && colNum == 9 || rowNum == 10 && colNum == 4 || rowNum == 11 && colNum == 1 ||
                        rowNum == 13 && colNum == 6 || rowNum == 14 && colNum == 7 || rowNum == 15 && colNum == 4 || rowNum == 16 && colNum == 0 ||
                        rowNum == 18 && colNum == 3 || rowNum == 20 && colNum == 9 || rowNum == 21 && colNum == 8 || rowNum == 22 && colNum == 2 ||
                        rowNum == 24 && colNum == 9 || rowNum == 25 && colNum == 5 || rowNum == 27 && colNum == 7 || rowNum == 29 && colNum == 8) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 0 && colNum == 4 || rowNum == 2 && colNum == 8 || rowNum == 4 && colNum == 8 || rowNum == 6 && colNum == 9 ||
                        rowNum == 7 && colNum == 6 || rowNum == 9 && colNum == 8 || rowNum == 10 && colNum == 2 || rowNum == 12 && colNum == 8 ||
                        rowNum == 13 && colNum == 5 || rowNum == 14 && colNum == 3 || rowNum == 15 && colNum == 1 || rowNum == 17 && colNum == 9 ||
                        rowNum == 19 && colNum == 8 || rowNum == 20 && colNum == 8 || rowNum == 21 && colNum == 4 || rowNum == 23 && colNum == 9 ||
                        rowNum == 24 && colNum == 8 || rowNum == 25 && colNum == 2 || rowNum == 27 && colNum == 4 || rowNum == 29 && colNum == 2) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 0 && colNum == 1 || rowNum == 2 && colNum == 4 || rowNum == 4 && colNum == 3 || rowNum == 6 && colNum == 6 ||
                        rowNum == 7 && colNum == 3 || rowNum == 9 && colNum == 7 || rowNum == 11 && colNum == 9 || rowNum == 12 && colNum == 3 ||
                        rowNum == 13 && colNum == 2 || rowNum == 15 && colNum == 9 || rowNum == 16 && colNum == 7 || rowNum == 17 && colNum == 2 ||
                        rowNum == 19 && colNum == 5 || rowNum == 20 && colNum == 7 || rowNum == 21 && colNum == 1 || rowNum == 23 && colNum == 8 ||
                        rowNum == 24 && colNum == 7 || rowNum == 26 && colNum == 8 || rowNum == 28 && colNum == 6 || rowNum == 29 && colNum == 1) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
                if (rowNum == 0 && colNum == 9 || rowNum == 1 && colNum == 5 || rowNum == 2 && colNum == 0 || rowNum == 4 && colNum == 1 ||
                        rowNum == 6 && colNum == 2 || rowNum == 7 && colNum == 0 || rowNum == 9 && colNum == 2 || rowNum == 11 && colNum == 6 ||
                        rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 8 || rowNum == 15 && colNum == 8 || rowNum == 16 && colNum == 3 ||
                        rowNum == 18 && colNum == 7 || rowNum == 19 && colNum == 2 || rowNum == 20 && colNum == 5 || rowNum == 22 && colNum == 8 ||
                        rowNum == 23 && colNum == 4 || rowNum == 24 && colNum == 3 || rowNum == 26 && colNum == 4 || rowNum == 28 && colNum == 4
                        || rowNum == 29 && colNum == 0) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                    brick.setBrickMoving(false); // заставляет двигаться хаотично кирпичи
                }
            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_18, "records_18"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 18, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_18");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_18"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 11 && starTimer > 0) {
            createAttainment(18);
        }

    }
}