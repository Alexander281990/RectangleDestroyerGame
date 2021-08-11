package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.actors.Hindrance;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_30 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_30(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(500); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_30);
        quantityBricks(157, 14);

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
                brick.setColor(Color.RED);
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 3 ||
                        rowNum == 0 && colNum == 5 || rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 2 ||
                        rowNum == 1 && colNum == 3 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 7 ||
                        rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 6 ||
                        rowNum == 2 && colNum == 7 || rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 2 ||
                        rowNum == 3 && colNum == 8 || rowNum == 3 && colNum == 9 || rowNum == 4 && colNum == 0 || rowNum == 4 && colNum == 1 ||
                        rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 8 || rowNum == 4 && colNum == 9 || rowNum == 5 && colNum == 6 ||
                        rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 8 || rowNum == 5 && colNum == 9 || rowNum == 6 && colNum == 6 ||
                        rowNum == 6 && colNum == 7 || rowNum == 6 && colNum == 8 || rowNum == 6 && colNum == 9 || rowNum == 7 && colNum == 6 ||
                        rowNum == 7 && colNum == 7 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 7 || rowNum == 9 && colNum == 6 ||
                        rowNum == 9 && colNum == 7 || rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 2 ||
                        rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 5 || rowNum == 11 && colNum == 0 ||
                        rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 4 ||
                        rowNum == 11 && colNum == 5 || rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 2 ||
                        rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 5 || rowNum == 13 && colNum == 6 ||
                        rowNum == 13 && colNum == 7 || rowNum == 13 && colNum == 8 || rowNum == 13 && colNum == 9 || rowNum == 14) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0) {
                    Action spin = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever = Actions.forever( spin ); // повторяет цикл вращения бесконечно
                    Hindrance hindrance = new Hindrance(x, y, mainStage, false);
                    hindrance.setOrigin(Align.center);
                    hindrance.setBoundaryRectangle();
                    hindrance.addAction(spinForever);
                }
                if (rowNum == 0 && colNum == 3) {
                    Action spin_1 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
                    brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 0 && colNum == 5) {
                    Action spin_2 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_2 = Actions.forever( spin_2 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_2 = new BrickHard(x, y, mainStage, false);
                    brickHard_2.addAction(spinForever_2); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 5 && colNum == 8) {
                    Action spin_3 = Actions.rotateBy( 360, 6 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_3 = Actions.forever( spin_3 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_3 = new BrickHard(x, y, mainStage, false);
                    brickHard_3.addAction(spinForever_3); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 5 && colNum == 9) {
                    Action spin_4 = Actions.rotateBy( -360, 6 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_4 = Actions.forever( spin_4 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_4 = new BrickHard(x, y, mainStage, false);
                    brickHard_4.addAction(spinForever_4); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 7 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 7 ||
                        rowNum == 5 && colNum == 6 || rowNum == 5 && colNum == 7 || rowNum == 6 && colNum == 6 || rowNum == 6 && colNum == 7 ||
                        rowNum == 7 && colNum == 6 || rowNum == 7 && colNum == 7 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 7 ||
                        rowNum == 9 && colNum == 6 || rowNum == 9 && colNum == 7 || rowNum == 13 && colNum == 6 || rowNum == 13 && colNum == 7 ||
                        rowNum == 13 && colNum == 8 || rowNum == 13 && colNum == 9) {
                    new BrickHard(x, y, mainStage, true);
                }
                if (rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9 || rowNum == 5 && colNum == 0 ||
                        rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 4 ||
                        rowNum == 5 && colNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 5 || rowNum == 3 && colNum == 3 ||
                        rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 7 ||
                        rowNum == 4 && colNum == 3 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 5 || rowNum == 4 && colNum == 6 ||
                        rowNum == 4 && colNum == 7 || rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 2 ||
                        rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 5 || rowNum == 7 && colNum == 8 ||
                        rowNum == 7 && colNum == 9 || rowNum == 8 && colNum == 8 || rowNum == 8 && colNum == 9 || rowNum == 9 && colNum == 8 ||
                        rowNum == 9 && colNum == 9 || rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 8 ||
                        rowNum == 10 && colNum == 9 || rowNum == 11 && colNum == 6 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 8 ||
                        rowNum == 11 && colNum == 9 || rowNum == 12 && colNum == 6 || rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 8 ||
                        rowNum == 12 && colNum == 9) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 0 && colNum == 4 || rowNum == 1 && colNum == 9 || rowNum == 3 && colNum == 8 || rowNum == 3 && colNum == 9 ||
                        rowNum == 7 && colNum == 0 || rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 3 ||
                        rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 5) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 1 && colNum == 6 || rowNum == 2 && colNum == 9 || rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 1 ||
                        rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 5) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 0 && colNum == 7 || rowNum == 1 && colNum == 8 || rowNum == 2 && colNum == 9 || rowNum == 9 && colNum == 0 ||
                        rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 4 ||
                        rowNum == 9 && colNum == 5 || rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 2 ||
                        rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 4 || rowNum == 13 && colNum == 5) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 14 && colNum == 0) {
                    Hindrance hindrance_8 = new Hindrance(0, y, mainStage, false);
                    hindrance_8.setSize( 0,Gdx.graphics.getHeight() / 60f);
                    hindrance_8.setBoundaryRectangle();
                    hindrance_8.setHindranceIncrease(false);
                }

            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_30, "records_30"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 30, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_30");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_30"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 15 && starTimer > 0) {
            createAttainment(30);
        }

    }
}