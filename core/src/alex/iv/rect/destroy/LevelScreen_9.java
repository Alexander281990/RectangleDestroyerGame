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

public class LevelScreen_9 extends LevelScreenMain {

    private Warp warpMain;
    private Warp warp;
    private Warp warp2;
    private Warp warpMain2;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_9(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(180); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_9);
        quantityBricks(110, 11);

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
                if (rowNum == 0 || rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5 || rowNum == 6 || rowNum == 10 ||
                        rowNum == 13 || rowNum == 17 || rowNum == 18 || rowNum == 19 || rowNum == 20 || rowNum == 21 || rowNum == 22 || rowNum == 23 ||
                        rowNum == 27) {
                    brick.remove();
                }
                if (rowNum == 7 || rowNum == 8 || rowNum == 9 || rowNum == 14 || rowNum == 15 || rowNum == 16 || rowNum == 24 ||
                        rowNum == 25 || rowNum == 26) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 11 || rowNum == 12){
                    brick.setColor(Color.RED);
                    brick.setBrickFlash(false);
                }
                if (rowNum == 5 && colNum == 0) {
                    warpMain = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 17 && colNum == 9) {
                    warpMain2 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 5 && colNum == 9) {
                    warp = new Warp( x, y, mainStage);
                }
                if (rowNum == 17 && colNum == 0) {
                    warp2 = new Warp( x, y, mainStage);
                }
                if (rowNum == 0 && colNum == 4 || rowNum == 1 && colNum == 5 || rowNum == 2 && colNum == 4 || rowNum == 3 && colNum == 5 ||
                        rowNum == 4 && colNum == 4) {
                    BrickHard brickHard = new BrickHard(x, y, mainStage, false);
                    brickHard.setBrickHardMoving(false);
                }
                if (rowNum == 20 && colNum == 1) {
                    Action spin_1 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
                    Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
                    BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
                    brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard
                }
                if (rowNum == 20 && colNum == 3) {
                    Action spin_2 = Actions.rotateBy( 360, 2 );
                    Action spinForever_2 = Actions.forever( spin_2 );
                    BrickHard brickHard_2 = new BrickHard(x, y, mainStage, false);
                    brickHard_2.addAction(spinForever_2);
                }
                if (rowNum == 20 && colNum == 5) {
                    Action spin_3 = Actions.rotateBy( 360, 2 );
                    Action spinForever_3 = Actions.forever( spin_3 );
                    BrickHard brickHard_3 = new BrickHard(x, y, mainStage, false);
                    brickHard_3.addAction(spinForever_3);
                }
                if (rowNum == 20 && colNum == 7) {
                    Action spin_4 = Actions.rotateBy( 360, 2 );
                    Action spinForever_4 = Actions.forever( spin_4 );
                    BrickHard brickHard_4 = new BrickHard(x, y, mainStage, false);
                    brickHard_4.addAction(spinForever_4);
                }
                if (rowNum == 20 && colNum == 9) {
                    Action spin_5 = Actions.rotateBy( 360, 2 );
                    Action spinForever_5 = Actions.forever( spin_5 );
                    BrickHard brickHard_5 = new BrickHard(x, y, mainStage, false);
                    brickHard_5.addAction(spinForever_5);
                }

            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_9, "records_9"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 9, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_9", "attainmentColorLevelMemory_9");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 12 && starTimer > 0) {
            createAttainment(9);
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain) || bal.overlaps(warpMain2)) {
                int r = MathUtils.random(1, 2);
                if (r == 1) {
                    bal.centerAtActor(warp);
                } else if (r == 2){
                    bal.centerAtActor(warp2);
                }
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

    }
}