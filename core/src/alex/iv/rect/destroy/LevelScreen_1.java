package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;


/** Методы для класса Brick, усложняющие игру

 *  brick.setColor(Color.RED); - задает красный цвет

 *  brick.setColor(Color.ORANGE); - задает оранжевый цвет
    brick.numberColor = 2;

 *  brick.setColor(Color.YELLOW); - задает желтый цвет
    brick.numberColor = 3;

 *  brick.setColor(Color.GREEN); - задает зеленый цвет
    brick.numberColor = 4;

 *  brick.setColor(Color.BLUE); - задает синий цвет
    brick.numberColor = 5;

 *  brick.setBrickMoving(false); - заставляет двигаться хаотично кирпичи. Пишется в методе public void initialize() { }, при создании brick

 *  brick.setBrickFlash(false); - заставляет мигать разными цветами кирпичи. Пишется в методе public void initialize() { }, при создании brick

 - если brick красного цвета и brick.mBrick == true, то этод код заставляет его двигаться в разные стороны с разной скоростью и длинной(brick.leftRightMoving(0, 2, 800, 900, 0, 180);)
 - изначально brick.mBrick == false;
 - чтобы этод код заработал, необходимо при создании brick(в месте которое нам нужно) прописать brick.mBrick == true;
 - пример LevelScreen_11 --> строка 115
 *  for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
        if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED) && brick.mBrick) {
            brick.leftRightMoving(0, 2, 800, 900, 0, 180);
        }
    }

 - если brick красного цвета, то этод код заставляет его двигаться в разные стороны с разной скоростью и длинной(brick.leftRightMoving(0, 2, 800, 900, 0, 180);)
 - пишется в методе public void update(float dt) { }
 *  for (BaseActor brick : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Brick")) {
        if (Color.rgb888(brick.getColor()) == Color.rgb888(Color.RED)) {
            brick.leftRightMoving(0, 2, 800, 900, 0, 180);
        }
    }


 //        warp = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
 //                MathUtils.random(Gdx.graphics.getHeight() - 80),
 //                "black_warp.png", mainStage);
 //        warp2 = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
 //                MathUtils.random(Gdx.graphics.getHeight() - 50), mainStage);
 //        warp3 = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
 //                MathUtils.random(Gdx.graphics.getHeight() - 50), mainStage);

 * */

public class LevelScreen_1 extends LevelScreenMain {

    //public IActivityRequestHandler requestHandler;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_1(IActivityRequestHandler requestHandler) {
        super(requestHandler);
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_1);

        Brick tempBrick = new Brick(0,0,mainStage);
        tempBrick.remove();
        int totalRows = 10;
        int totalCols = 10;
        float marginX = (Gdx.graphics.getWidth() - totalCols * tempBrick.getBrickWidth()) / 2;
        float marginY = (Gdx.graphics.getHeight() - totalRows * tempBrick.getBrickHeight()) - 150;
        for (int rowNum = 0; rowNum < totalRows; rowNum++) {
            for (int colNum = 0; colNum < totalCols; colNum++) {
                float x = marginX + tempBrick.getBrickWidth()	* colNum;
                float y = marginY + tempBrick.getBrickHeight() * rowNum;
                Brick brick = new Brick( x, y, mainStage);
                if (rowNum == 5 || rowNum == 6){
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                } else  if (rowNum == 7){
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                } else {
                    brick.setColor(Color.RED);
                }
            }
        }
        // показывает в Log количество видимых обьектов Brick
        Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_1, "records_1"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 1, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_1, "records_1");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

    }
}
