package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_25 extends LevelScreenMain {

    private Warp warpMain;
    private Warp warp;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_25(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        //background.loadTexture("background/fon_level.png");
        showTime(300); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_25);
        quantityBricks(86, 7);


        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 28;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick(x, y, mainStage);
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9 ||
                        rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5 || rowNum == 7 || rowNum == 8 || rowNum == 9 ||
                        rowNum == 11 || rowNum == 12 || rowNum == 13 || rowNum == 14 || rowNum == 15 || rowNum == 19 || rowNum == 20 ||
                        rowNum == 21 || rowNum == 24 || rowNum == 25 && colNum == 0 || rowNum == 25 && colNum == 2 || rowNum == 25 && colNum == 4 ||
                        rowNum == 25 && colNum == 6 || rowNum == 25 && colNum == 8 || rowNum == 26 && colNum == 1 || rowNum == 26 && colNum == 3 ||
                        rowNum == 26 && colNum == 5 || rowNum == 26 && colNum == 7 || rowNum == 26 && colNum == 9 || rowNum == 27) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 5 ||
                        rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 7 || rowNum == 25 && colNum == 1 || rowNum == 25 && colNum == 3 ||
                        rowNum == 25 && colNum == 5 || rowNum == 25 && colNum == 7 || rowNum == 25 && colNum == 9 || rowNum == 26 && colNum == 0 ||
                        rowNum == 26 && colNum == 2 || rowNum == 26 && colNum == 4 || rowNum == 26 && colNum == 6 || rowNum == 26 && colNum == 8) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 10) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 16 || rowNum == 17 || rowNum == 18) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 22 || rowNum == 23) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 8 || rowNum == 0 && colNum == 9) {
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 20 && colNum == 0) {
                    warpMain = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 4 && colNum == 4) {
                    warp = new Warp( x, y, mainStage);
                }
                if (rowNum == 2 && colNum == 2) {
                    Action spin_1 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
                    brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 2 && colNum == 7) {
                    Action spin_2 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_2 = Actions.forever( spin_2 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_2 = new BrickHard(x, y, mainStage, false);
                    brickHard_2.addAction(spinForever_2); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 4 && colNum == 0) {
                    Action spin_3 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_3 = Actions.forever( spin_3 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_3 = new BrickHard(x, y, mainStage, false);
                    brickHard_3.addAction(spinForever_3); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 4 && colNum == 9) {
                    Action spin_4 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_4 = Actions.forever( spin_4 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_4 = new BrickHard(x, y, mainStage, false);
                    brickHard_4.addAction(spinForever_4); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 8 && colNum == 1) {
                    Action spin_5 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_5 = Actions.forever( spin_5 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_5 = new BrickHard(x, y, mainStage, false);
                    brickHard_5.addAction(spinForever_5); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 8 && colNum == 3) {
                    Action spin_6 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_6 = Actions.forever( spin_6 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_6 = new BrickHard(x, y, mainStage, false);
                    brickHard_6.addAction(spinForever_6); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 8 && colNum == 5) {
                    Action spin_7 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_7 = Actions.forever( spin_7 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_7 = new BrickHard(x, y, mainStage, false);
                    brickHard_7.addAction(spinForever_7); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 8 && colNum == 7) {
                    Action spin_8 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_8 = Actions.forever( spin_8 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_8 = new BrickHard(x, y, mainStage, false);
                    brickHard_8.addAction(spinForever_8); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 8 && colNum == 9) {
                    Action spin_9 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_9 = Actions.forever( spin_9 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_9 = new BrickHard(x, y, mainStage, false);
                    brickHard_9.addAction(spinForever_9); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 12 && colNum == 0) {
                    Action spin_10 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_10 = Actions.forever( spin_10 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_10 = new BrickHard(x, y, mainStage, false);
                    brickHard_10.addAction(spinForever_10); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 12 && colNum == 2) {
                    Action spin_11 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_11 = Actions.forever( spin_11 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_11 = new BrickHard(x, y, mainStage, false);
                    brickHard_11.addAction(spinForever_11); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 12 && colNum == 4) {
                    Action spin_12 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_12 = Actions.forever( spin_12 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_12 = new BrickHard(x, y, mainStage, false);
                    brickHard_12.addAction(spinForever_12); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 12 && colNum == 6) {
                    Action spin_13 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_13 = Actions.forever( spin_13 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_13 = new BrickHard(x, y, mainStage, false);
                    brickHard_13.addAction(spinForever_13); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 12 && colNum == 8) {
                    Action spin_14 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_14 = Actions.forever( spin_14 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_14 = new BrickHard(x, y, mainStage, false);
                    brickHard_14.addAction(spinForever_14); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 14 && colNum == 1) {
                    Action spin_15 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_15 = Actions.forever( spin_15 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_15 = new BrickHard(x, y, mainStage, false);
                    brickHard_15.addAction(spinForever_15); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 14 && colNum == 3) {
                    Action spin_16 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_16 = Actions.forever( spin_16 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_16 = new BrickHard(x, y, mainStage, false);
                    brickHard_16.addAction(spinForever_16); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 14 && colNum == 5) {
                    Action spin_17 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_17 = Actions.forever( spin_17 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_17 = new BrickHard(x, y, mainStage, false);
                    brickHard_17.addAction(spinForever_17); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 14 && colNum == 7) {
                    Action spin_18 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_18 = Actions.forever( spin_18 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_18 = new BrickHard(x, y, mainStage, false);
                    brickHard_18.addAction(spinForever_18); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 14 && colNum == 9) {
                    Action spin_19 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_19 = Actions.forever( spin_19 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_19 = new BrickHard(x, y, mainStage, false);
                    brickHard_19.addAction(spinForever_19); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 20 && colNum == 1) {
                    Action spin_20 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_20 = Actions.forever( spin_20 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_20 = new BrickHard(x, y, mainStage, false);
                    brickHard_20.addAction(spinForever_20); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 20 && colNum == 3) {
                    Action spin_21 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_21 = Actions.forever( spin_21 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_21 = new BrickHard(x, y, mainStage, false);
                    brickHard_21.addAction(spinForever_21); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 20 && colNum == 5) {
                    Action spin_22 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_22 = Actions.forever( spin_22 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_22 = new BrickHard(x, y, mainStage, false);
                    brickHard_22.addAction(spinForever_22); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 20 && colNum == 7) {
                    Action spin_23 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_23 = Actions.forever( spin_23 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_23 = new BrickHard(x, y, mainStage, false);
                    brickHard_23.addAction(spinForever_23); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 20 && colNum == 9) {
                    Action spin_24 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_24 = Actions.forever( spin_24 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_24 = new BrickHard(x, y, mainStage, false);
                    brickHard_24.addAction(spinForever_24); // добавляет бесконечное вращение обькту brickHard
                }

            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_25, "records_25"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 25, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_25");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_25"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 8 && starTimer > 0) {
            createAttainment(25);
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain)) {
                bal.centerAtActor(warp);
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

    }
}