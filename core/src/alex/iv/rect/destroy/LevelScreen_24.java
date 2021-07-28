package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.actors.BrickHard;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_24 extends LevelScreenMain {

    private Warp warpMain;
    private Warp warp;
    private Warp warp2;
    private Warp warpMain2;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_24(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(180); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_24);
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

            }
        }
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_24, "records_24"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 24, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_24, "records_24", attainmentColorLevel_24, "attainmentColorLevelMemory_24");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 12 && starTimer > 0) {
            createAttainment(24);
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