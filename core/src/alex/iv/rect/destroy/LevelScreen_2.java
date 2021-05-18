package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.Warp;

public class LevelScreen_2 extends LevelScreenMain {

    private Warp warp;
    private Warp warp2;
    private Warp warp3;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_2(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        //this.requestHandler = requestHandler;
    }

    public void initialize() {
        super.initialize();
        background.loadTexture("background/fon_level.png");
        showTime(200); // инициализируем метод отображение игрового времени
        recordsLabelWindow.setText("Records: " + recordsLevel_2);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 250;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage );
                if (rowNum == 0 || rowNum == 1){
                    brick.setColor(Color.RED);
                }
                if (rowNum == 2 || rowNum == 3){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 4 || rowNum == 5){
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 6 || rowNum == 7){
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 8 || rowNum == 9){
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }
            }
        }

        warp = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
                MathUtils.random(Gdx.graphics.getHeight() - 80, LevelScreenMain.getWindowPlayHeight() + 100),
                "black_warp.png", mainStage);
        warp2 = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
                MathUtils.random(Gdx.graphics.getHeight() - 50, LevelScreenMain.getWindowPlayHeight() + 100), mainStage);
        warp3 = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
                MathUtils.random(Gdx.graphics.getHeight() - 50, LevelScreenMain.getWindowPlayHeight() + 100), mainStage);

    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_2, "records_2"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 2, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_2, "records_2");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

        for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
            if (bal.overlaps(warp)) {
                int r = MathUtils.random(1, 2);
                if (r == 1) {
                    bal.centerAtActor(warp2);
                } else {
                    bal.centerAtActor(warp3);
                }
                bal.setMotionAngle(MathUtils.random(360));
            }
        }

    }
}
