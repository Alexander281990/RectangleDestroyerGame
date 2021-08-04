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

public class LevelScreen_6 extends LevelScreenMain {

    private Warp warpMain1;
    private Warp warpMain2;
    private Warp warpMain3;
    private Warp warpMain4;
    private Warp warpMain5;
    private Warp warpMain6;
    private Warp warp1;
    private Warp warp2;
    private Warp warp3;
    private Warp warp4;
    private Warp warp5;
    private Warp warp6;
    private Warp warp7;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_6(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        requestHandler.hideBannerAd(); // при нажатии на кнопку баннер скрывается
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(120); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_6);
        quantityBricks(124, 12);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 26;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 50;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 0 && colNum == 1 || rowNum == 0 && colNum == 3 || rowNum == 0 && colNum == 5 || rowNum == 0 && colNum == 7 || rowNum == 0 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 0 && colNum == 0 || rowNum == 0 && colNum == 2 || rowNum == 0 && colNum == 4 || rowNum == 0 && colNum == 6 || rowNum == 0 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 1 && colNum == 0 || rowNum == 1 && colNum == 2 || rowNum == 1 && colNum == 4 || rowNum == 1 && colNum == 6 || rowNum == 1 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 1 && colNum == 1 || rowNum == 1 && colNum == 3 || rowNum == 1 && colNum == 5 || rowNum == 1 && colNum == 7 || rowNum == 1 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 2 && colNum == 1 || rowNum == 2 && colNum == 3 || rowNum == 2 && colNum == 5 || rowNum == 2 && colNum == 7 || rowNum == 2 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 2 && colNum == 0 || rowNum == 2 && colNum == 2 || rowNum == 2 && colNum == 4 || rowNum == 2 && colNum == 6 || rowNum == 2 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 3 && colNum == 0 || rowNum == 3 && colNum == 2 || rowNum == 3 && colNum == 4 || rowNum == 3 && colNum == 6 || rowNum == 3 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 3 && colNum == 1 || rowNum == 3 && colNum == 3 || rowNum == 3 && colNum == 5 || rowNum == 3 && colNum == 7 || rowNum == 3 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 4 && colNum == 1 || rowNum == 4 && colNum == 3 || rowNum == 4 && colNum == 5 || rowNum == 4 && colNum == 7 || rowNum == 4 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 4 && colNum == 0 || rowNum == 4 && colNum == 2 || rowNum == 4 && colNum == 4 || rowNum == 4 && colNum == 6 || rowNum == 4 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 5 && colNum == 0 || rowNum == 5 && colNum == 2 || rowNum == 5 && colNum == 4 || rowNum == 5 && colNum == 6 || rowNum == 5 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 5 && colNum == 1 || rowNum == 5 && colNum == 3 || rowNum == 5 && colNum == 5 || rowNum == 5 && colNum == 7 || rowNum == 5 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 6 && colNum == 1 || rowNum == 6 && colNum == 3 || rowNum == 6 && colNum == 5 || rowNum == 6 && colNum == 7 || rowNum == 6 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 6 && colNum == 0 || rowNum == 6 && colNum == 2 || rowNum == 6 && colNum == 4 || rowNum == 6 && colNum == 6 || rowNum == 6 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 7 && colNum == 0 || rowNum == 7 && colNum == 2 || rowNum == 7 && colNum == 4 || rowNum == 7 && colNum == 6 || rowNum == 7 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 7 && colNum == 1 || rowNum == 7 && colNum == 3 || rowNum == 7 && colNum == 5 || rowNum == 7 && colNum == 7 || rowNum == 7 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 8 && colNum == 1 || rowNum == 8 && colNum == 3 || rowNum == 8 && colNum == 5 || rowNum == 8 && colNum == 7 || rowNum == 8 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 8 && colNum == 0 || rowNum == 8 && colNum == 2 || rowNum == 8 && colNum == 4 || rowNum == 8 && colNum == 6 || rowNum == 8 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 9 && colNum == 0 || rowNum == 9 && colNum == 2 || rowNum == 9 && colNum == 4 || rowNum == 9 && colNum == 6 || rowNum == 9 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 9 && colNum == 1 || rowNum == 9 && colNum == 3 || rowNum == 9 && colNum == 5 || rowNum == 9 && colNum == 7 || rowNum == 9 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 10 && colNum == 1 || rowNum == 10 && colNum == 3 || rowNum == 10 && colNum == 5 || rowNum == 10 && colNum == 7 || rowNum == 10 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 10 && colNum == 0 || rowNum == 10 && colNum == 2 || rowNum == 10 && colNum == 4 || rowNum == 10 && colNum == 6 || rowNum == 10 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 11 && colNum == 0 || rowNum == 11 && colNum == 2 || rowNum == 11 && colNum == 4 || rowNum == 11 && colNum == 6 || rowNum == 11 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 11 && colNum == 1 || rowNum == 11 && colNum == 3 || rowNum == 11 && colNum == 5 || rowNum == 11 && colNum == 7 || rowNum == 11 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 12 && colNum == 1 || rowNum == 12 && colNum == 3 || rowNum == 12 && colNum == 5 || rowNum == 12 && colNum == 7 || rowNum == 12 && colNum == 9) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 12 && colNum == 0 || rowNum == 12 && colNum == 2 || rowNum == 12 && colNum == 4 || rowNum == 12 && colNum == 6 || rowNum == 12 && colNum == 8) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 13 && colNum == 0 || rowNum == 13 && colNum == 2 || rowNum == 13 && colNum == 4 || rowNum == 13 && colNum == 6 || rowNum == 13 && colNum == 8 ) {
                    brick.remove();
                    new BrickHard(x, y, mainStage, false);
                }
                if (rowNum == 13 && colNum == 1 || rowNum == 13 && colNum == 3 || rowNum == 13 && colNum == 5 || rowNum == 13 && colNum == 7 || rowNum == 13 && colNum == 9 ) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 14 && colNum == 1 || rowNum == 14 && colNum == 3 || rowNum == 14 && colNum == 5 || rowNum == 14 && colNum == 7 || rowNum == 14 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 14 && colNum == 0 || rowNum == 14 && colNum == 2 || rowNum == 14 && colNum == 4 || rowNum == 14 && colNum == 6 || rowNum == 14 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 15 && colNum == 0 || rowNum == 15 && colNum == 2 || rowNum == 15 && colNum == 4 || rowNum == 15 && colNum == 6 || rowNum == 15 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 15 && colNum == 1 || rowNum == 15 && colNum == 3 || rowNum == 15 && colNum == 5 || rowNum == 15 && colNum == 7 || rowNum == 15 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 16 && colNum == 1 || rowNum == 16 && colNum == 3 || rowNum == 16 && colNum == 5 || rowNum == 16 && colNum == 7 || rowNum == 16 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 16 && colNum == 0 || rowNum == 16 && colNum == 2 || rowNum == 16 && colNum == 4 || rowNum == 16 && colNum == 6 || rowNum == 16 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 17 && colNum == 0 || rowNum == 17 && colNum == 2 || rowNum == 17 && colNum == 4 || rowNum == 17 && colNum == 6 || rowNum == 17 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 17 && colNum == 1 || rowNum == 17 && colNum == 3 || rowNum == 17 && colNum == 5 || rowNum == 17 && colNum == 7 || rowNum == 17 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 18 && colNum == 1 || rowNum == 18 && colNum == 3 || rowNum == 18 && colNum == 5 || rowNum == 18 && colNum == 7 || rowNum == 18 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 18 && colNum == 0 || rowNum == 18 && colNum == 2 || rowNum == 18 && colNum == 4 || rowNum == 18 && colNum == 6 || rowNum == 18 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 19 && colNum == 0 || rowNum == 19 && colNum == 2 || rowNum == 19 && colNum == 4 || rowNum == 19 && colNum == 6 || rowNum == 19 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 19 && colNum == 1 || rowNum == 19 && colNum == 3 || rowNum == 19 && colNum == 5 || rowNum == 19 && colNum == 7 || rowNum == 19 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 20 && colNum == 1 || rowNum == 20 && colNum == 3 || rowNum == 20 && colNum == 5 || rowNum == 20 && colNum == 7 || rowNum == 20 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 20 && colNum == 0 || rowNum == 20 && colNum == 2 || rowNum == 20 && colNum == 4 || rowNum == 20 && colNum == 6 || rowNum == 20 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 21 && colNum == 0 || rowNum == 21 && colNum == 2 || rowNum == 21 && colNum == 4 || rowNum == 21 && colNum == 6 || rowNum == 21 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 21 && colNum == 1 || rowNum == 21 && colNum == 3 || rowNum == 21 && colNum == 5 || rowNum == 21 && colNum == 7 || rowNum == 21 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 22 && colNum == 1 || rowNum == 22 && colNum == 3 || rowNum == 22 && colNum == 5 || rowNum == 22 && colNum == 7 || rowNum == 22 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 22 && colNum == 0 || rowNum == 22 && colNum == 2 || rowNum == 22 && colNum == 4 || rowNum == 22 && colNum == 6 || rowNum == 22 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 23 && colNum == 0 || rowNum == 23 && colNum == 2 || rowNum == 23 && colNum == 4 || rowNum == 23 && colNum == 6 || rowNum == 23 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 23 && colNum == 1 || rowNum == 23 && colNum == 3 || rowNum == 23 && colNum == 5 || rowNum == 23 && colNum == 7 || rowNum == 23 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 24 && colNum == 1 || rowNum == 24 && colNum == 3 || rowNum == 24 && colNum == 5 || rowNum == 24 && colNum == 7 || rowNum == 24 && colNum == 9 ) {
                    brick.remove();
                }
                if (rowNum == 24 && colNum == 0 || rowNum == 24 && colNum == 2 || rowNum == 24 && colNum == 4 || rowNum == 24 && colNum == 6 || rowNum == 24 && colNum == 8 ) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 25 && colNum == 0 || rowNum == 25 && colNum == 2 || rowNum == 25 && colNum == 4 || rowNum == 25 && colNum == 6 || rowNum == 25 && colNum == 8) {
                    brick.remove();
                }
                if (rowNum == 25 && colNum == 1 || rowNum == 25 && colNum == 3 || rowNum == 25 && colNum == 5 || rowNum == 25 && colNum == 7 || rowNum == 25 && colNum == 9) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 5 && colNum == 0) {
                    warpMain1 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 10 && colNum == 3) {
                    warpMain2 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 6 && colNum == 9) {
                    warpMain3 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 14 && colNum == 6) {
                    warpMain4 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 18 && colNum == 0) {
                    warpMain5 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 19 && colNum == 9) {
                    warpMain6 = new Warp(x, y, "black_warp.png", mainStage);
                }
                if (rowNum == 1 && colNum == 4) {
                    warp1 = new Warp( x, y, mainStage);
                }
                if (rowNum == 6 && colNum == 2) {
                    warp2 = new Warp( x, y, mainStage);
                }
                if (rowNum == 9 && colNum == 9) {
                    warp3 = new Warp( x, y, mainStage);
                }
                if (rowNum == 16 && colNum == 2) {
                    warp4 = new Warp( x, y, mainStage);
                }
                if (rowNum == 21 && colNum == 9) {
                    warp5 = new Warp( x, y, mainStage);
                }
                if (rowNum == 23 && colNum == 0) {
                    warp6 = new Warp( x, y, mainStage);
                }
                if (rowNum == 23 && colNum == 4) {
                    warp7 = new Warp( x, y, mainStage);
                }
                if (rowNum == 6 && colNum == 0 || rowNum == 7 && colNum == 9 || rowNum == 18 && colNum == 0 || rowNum == 11 && colNum == 3 ||
                        rowNum == 14 && colNum == 6 || rowNum == 19 && colNum == 9) {
                    brick.remove();
                }

            }
        }

        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_6, "records_6"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 6, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_6, "records_6", attainmentColorLevel_6, "attainmentColorLevelMemory_6");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 13 && starTimer > 0) {
            createAttainment(6);
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warpMain1) || bal.overlaps(warpMain2) || bal.overlaps(warpMain3) || bal.overlaps(warpMain4) || bal.overlaps(warpMain5) || bal.overlaps(warpMain6)) {
                int r = MathUtils.random(1, 7);
                if (r == 1) {
                    bal.centerAtActor(warp1);
                } else if (r == 2){
                    bal.centerAtActor(warp2);
                } else if (r == 3) {
                    bal.centerAtActor(warp3);
                } else if (r == 4) {
                    bal.centerAtActor(warp4);
                } else if (r == 5){
                    bal.centerAtActor(warp5);
                } else if (r == 6) {
                    bal.centerAtActor(warp6);
                } else if (r == 7) {
                    bal.centerAtActor(warp7);
                }
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

    }
}
