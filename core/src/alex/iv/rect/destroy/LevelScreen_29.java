package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.actors.Hindrance;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_29 extends LevelScreenMain {

    private Warp warpMain1;
    private Warp warpMain2;
    private Warp warp1;
    private Warp warp2;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_29(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(300); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_29);
        quantityBricks(128, 11);

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
                if (rowNum == 0 || rowNum == 1 || rowNum == 5 || rowNum == 7 || rowNum == 9 || rowNum == 10 || rowNum == 11 || rowNum == 13 ||
                        rowNum == 15 || rowNum == 17|| rowNum == 18 || rowNum == 19 || rowNum == 21 || rowNum == 23 ||
                        rowNum == 26 && colNum == 0 || rowNum == 26 && colNum == 9 || rowNum == 27) {
                    brick.remove();
                }
                if (rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 26 && colNum == 1 || rowNum == 26 && colNum == 2 ||
                        rowNum == 26 && colNum == 3 || rowNum == 26 && colNum == 4 || rowNum == 26 && colNum == 5 ||
                        rowNum == 26 && colNum == 6 || rowNum == 26 && colNum == 7 || rowNum == 26 && colNum == 8) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 8 || rowNum == 24 || rowNum == 25) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 20 || rowNum == 22) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 6 || rowNum == 16) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 12 || rowNum == 14) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 7 && colNum == 5) {
                    Hindrance hindrance = new Hindrance(x, y, mainStage, true);
                    hindrance.setHindranceMoving(false);
                }
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 8 ||
                        rowNum == 27 && colNum == 1 || rowNum == 27 && colNum == 2 || rowNum == 27 && colNum == 3 ||
                        rowNum == 27 && colNum == 4 || rowNum == 27 && colNum == 5 || rowNum == 27 && colNum == 6 || rowNum == 27 && colNum == 7 ||
                        rowNum == 27 && colNum == 8) {
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 10 && colNum == 1) {
                    Action spin_1 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
                    brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 10 && colNum == 3) {
                    Action spin_2 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_2 = Actions.forever( spin_2 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_2 = new BrickHard(x, y, mainStage, false);
                    brickHard_2.addAction(spinForever_2); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 10 && colNum == 5) {
                    Action spin_3 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_3 = Actions.forever( spin_3 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_3 = new BrickHard(x, y, mainStage, false);
                    brickHard_3.addAction(spinForever_3); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 10 && colNum == 7) {
                    Action spin_4 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_4 = Actions.forever( spin_4 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_4 = new BrickHard(x, y, mainStage, false);
                    brickHard_4.addAction(spinForever_4); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 10 && colNum == 9) {
                    Action spin_5 = Actions.rotateBy( -360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_5 = Actions.forever( spin_5 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_5 = new BrickHard(x, y, mainStage, false);
                    brickHard_5.addAction(spinForever_5); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 1 || rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 3 ||
                        rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 5 || rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 7 ||
                        rowNum == 18 && colNum == 8 || rowNum == 18 && colNum == 9) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                    brickHard.setRotateBrick(false, 10);
                }
                if (rowNum == 21 && colNum == 2 || rowNum == 21 && colNum == 5 || rowNum == 21 && colNum == 8 || rowNum == 23 && colNum == 3 ||
                        rowNum == 23 && colNum == 6) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, true);
                    brickHard.setBrickHardMoving(false);
                }
                if (rowNum == 9 && colNum == 6) {
                    warpMain1 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 26 && colNum == 0) {
                    warpMain2 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 9 && colNum == 0) {
                    warp1 = new Warp( x, y, mainStage);
                }
                if (rowNum == 26 && colNum == 9) {
                    warp2 = new Warp( x, y, mainStage);
                }
                if (rowNum == 15 && colNum == 0) {
                    Hindrance hindrance_5 = new Hindrance(0, y, mainStage, false);
                    hindrance_5.setSize( 0,Gdx.graphics.getHeight() / 60f);
                    hindrance_5.setBoundaryRectangle();
                    hindrance_5.setHindranceIncrease(false);
                }


            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_29, "records_29"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 29, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_29", "attainmentColorLevelMemory_29");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 12 && starTimer > 0) {
            createAttainment(29);
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain1) || bal.overlaps(warpMain2)) {
                int r = MathUtils.random(1, 2);
                if (r == 1) {
                    bal.centerAtActor(warp1);
                } else if (r == 2){
                    bal.centerAtActor(warp2);
                }
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

    }
}