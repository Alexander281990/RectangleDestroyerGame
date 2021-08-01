package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_26 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_26(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(240); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_26);
        quantityBricks(76, 6);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 23;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                if (rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 7|| rowNum == 8 || rowNum == 9 || rowNum == 10 ||
                        rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 4 ||
                        rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8 || rowNum == 12 && colNum == 0 ||
                        rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 6 ||
                        rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 8 || rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 1 ||
                        rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 5 || rowNum == 13 && colNum == 6 ||
                        rowNum == 13 && colNum == 7 || rowNum == 13 && colNum == 8 || rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 1 ||
                        rowNum == 14 && colNum == 2 || rowNum == 14 && colNum == 3 || rowNum == 14 && colNum == 5 || rowNum == 14 && colNum == 6 ||
                        rowNum == 14 && colNum == 7 || rowNum == 14 && colNum == 8 || rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 1 ||
                        rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 4 || rowNum == 15 && colNum == 6 || rowNum == 15 && colNum == 7 ||
                        rowNum == 15 && colNum == 8 || rowNum == 16 && colNum == 0 || rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 3 ||
                        rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 5 || rowNum == 16 && colNum == 7 || rowNum == 16 && colNum == 8 ||
                        rowNum == 18 || rowNum == 19 || rowNum == 20 || rowNum == 22) {
                    brick.remove();
                }
                if (rowNum == 0 || rowNum == 21 || rowNum == 11 && colNum == 9 || rowNum == 12 && colNum == 9 || rowNum == 13 && colNum == 9 ||
                        rowNum == 14 && colNum == 9 || rowNum == 15 && colNum == 9 || rowNum == 16 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 1 || rowNum == 17) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 5) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 6) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 6 || rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 5 ||
                        rowNum == 13 && colNum == 4 || rowNum == 14 && colNum == 4 || rowNum == 15 && colNum == 3 || rowNum == 15 && colNum == 5 ||
                        rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 6) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 19 && colNum == 1) {
                    Action spin_1 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
                    brickHard_1.setBrickHardMoving(false);
                    brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 19 && colNum == 8) {
                    Action spin_2 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_2 = Actions.forever( spin_2 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_2 = new BrickHard(x, y, mainStage, false);
                    brickHard_2.setBrickHardMoving(false);
                    brickHard_2.addAction(spinForever_2); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 3 ||
                        rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 7 ||
                        rowNum == 3 && colNum == 8 || rowNum == 3 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                    brickHard.setRotateBrick(false, 10);
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 3 ||
                        rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 7 ||
                        rowNum == 8 && colNum == 8 || rowNum == 8 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                    brickHard.setRotateBrick(false, 6);
                }


            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_26, "records_26"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 26, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_26, "records_26", attainmentColorLevel_26, "attainmentColorLevelMemory_26");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 7 && starTimer > 0) {
            createAttainment(26);
        }

    }
}