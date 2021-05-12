package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;

public class LevelScreen_7 extends LevelScreenMain {
    public IActivityRequestHandler requestHandler;

    private int[] number;
    private int timeBrick;
    private Brick brick;

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_7(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        this.requestHandler = requestHandler;
    }

    public void initialize() {
        super.initialize();

        showTime(120); // инициализируем метод отображение игрового времени
        //background.loadTexture("background/fon_level.png");
        recordsLabelWindow.setText("Records: " + recordsLevel_7);

        timeBrick = 5;
        number = new int[]{1, 2, 3, 4, 5};

        brick = new Brick(600, 1400, mainStage);
        brick.setColor(Color.ORANGE);
        brick.numberColor = number[1];

    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 110) {
            brick.setColor(Color.YELLOW);
            brick.numberColor = 3;
        }
        if (starTimer < 0) {
            timeIsUp(recordsLevel_7, "records_7"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 1, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken(recordsLevel_7, "records_7");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
        }

    }
}
