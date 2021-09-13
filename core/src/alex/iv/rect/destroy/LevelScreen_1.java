package alex.iv.rect.destroy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import alex.iv.rect.destroy.actors.Brick;
import alex.iv.rect.destroy.controller.BaseActor;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;
import alex.iv.rect.destroy.controller.RectangleGame;


/** Методы для класса Brick, усложняющие игру

 ///////////////////////////////////////////////////////

 *  brick.setColor(Color.RED); - задает красный цвет

 *  brick.setColor(Color.ORANGE); - задает оранжевый цвет
    brick.numberColor = 2;

 *  brick.setColor(Color.YELLOW); - задает желтый цвет
    brick.numberColor = 3;

 *  brick.setColor(Color.GREEN); - задает зеленый цвет
    brick.numberColor = 4;

 *  brick.setColor(Color.BLUE); - задает синий цвет
    brick.numberColor = 5;

 //////////////////////////////////////////////////////////

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

///////////////////////////////////////////////////

 //        warp = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
 //                MathUtils.random(Gdx.graphics.getHeight() - 80),
 //                "black_warp.png", mainStage);
 //        warp2 = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
 //                MathUtils.random(Gdx.graphics.getHeight() - 50), mainStage);
 //        warp3 = new Warp(MathUtils.random(LevelScreenMain.getWindowPlayWidth() - 40),
 //                MathUtils.random(Gdx.graphics.getHeight() - 50), mainStage);

//////////////////////////////////////////////////

 //     Gdx.app.log("MyTag", "my informative message"); выводит в Log текстовое сообщение
 // выводит в Log переменную int
 //     Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
 //     Gdx.app.log("MyTag", String.valueOf(10));
 //     Gdx.app.log("MyTag", String.valueOf(attainment));

 /////////////////////////////////////////////////

 - При создании экземпляра BrickHard(жесткий кирпич) конструктор имеет булевую переменную "brickHardStatus".
 - Если brickHardStatus = true, то мяч будет отскакивать от BrickHard как от стен(Wall)
 - Если brickHardStatus = false, то мяч будет отскакивать от BrickHard как от весла(Paddle)

    НАПРИМЕР:
        BrickHard brickHard = new BrickHard(x, y, mainStage, true);
            или
        BrickHard brickHard = new BrickHard(x, y, mainStage, false);

 //////////////////////////////////////////////////

 - При создании экземпляра Hindrance(помеха) конструктор имеет булевую переменную "hindranceStatus".
 - Если hindranceStatus = true, то мяч от помехи будет отскакивать с обоих сторон
 - Если hindranceStatus = false, то мяч от помехи будет отскакивать только с верхней стороны. Если мяч коснется нижней стороны помехи, то она пропустит мяч на верхнюю свою сторону
 - Также после создании экземпляра Hindrance нужно вызвать метод "setHindranceMoving(false)", который заставляет хаотично двигаться обьект

    НАПРИМЕР:
        Hindrance hindrance = new Hindrance(x, y, mainStage, true);
        hindrance.setHindranceMoving(false);

 //////////////////////////////////////////////////

 - Создание дополнительного весла(Paddle)
    1. private Paddle paddle_2; // создаем полле класса
    2. paddle_2 = new Paddle(paddle.getX(), 50, mainStage); // в методе "initialize()" фиксируем весло по осям X and Y
    3. // в методе "update()" пишем два метода, которые: 1.держит весло горизонтально выровнянное с пальцем на экране. 2.заставляет отскакивать мячики от весла
    // метод, который держит ракетку горизонтально выровнянную с пальцем на экране
    if (paddleStop) {
        float touchDownX = Gdx.input.getX();
        paddle_2.setX(touchDownX - paddle_2.getWidth() / 2);
        paddle_2.boundToWorld();
    }
    // метод, который держит ракетку горизонтально выровнянную с пальцем на экране(конец)
    // метод, который заставляет отскакивать мячики от дополнительного весла
    for (BaseActor bal : BaseActor.getList(mainStage, "alex.iv.rect.destroy.actors.Ball")) {
        if (bal.overlaps(paddle_2)) {
            float positionPaddle_Y = paddle_2.getY() + paddle_2.getHeight() / 2; // находим центр paddle по оси Y
            float positionBall_Y = bal.getY() + bal.getHeight() / 2; // находим центр ball по оси Y
            float ballCenterX = bal.getX() + bal.getWidth() / 2; // находим центр шарика по оси Х
            float paddlePercentHit = (ballCenterX - paddle_2.getX()) / paddle_2.getWidth();
            // если во время столкновения ось Y обьекта bal больше оси Y обьекта paddle, то мячь отскакивает и движется вверх. В противном случае - вниз
                if (positionBall_Y > positionPaddle_Y) {
                    bounceAngle = MathUtils.lerp(150, 30, paddlePercentHit);
                } else {
                    bounceAngle = MathUtils.lerp(-150, -30, paddlePercentHit);
                }
            bal.setMotionAngle(bounceAngle);
        }
    }
    // метод, который заставляет отскакивать мячики от дополнительного весла(конец)

 ////////////////////////////////////////////////////////////////////////////////////////////

 - Создание движущихся облаков
    1. private Clouds cloud; // создаем поле класса
    2. cloud = new Clouds(0, Gdx.graphics.getHeight(), mainStage); // в методе "initialize()" создаем обьект Clouds
        uiStage.addActor(cloud);  // в методе "initialize()" добавляем его к "uiStage"
    3. cloud.setMotionAngle(-90); // в методе "update()" заставляем его двигаться

 ////////////////////////////////////////////////////////////////////////////////////////////

 - Вращение обьекта вокруг своей оси
    1. Action spin_1 = Actions.rotateBy( 360, 2 ); // заставляет вращаться кирпич на 360 градусов за 2 секунды
    2. Action spinForever_1 = Actions.forever( spin_1 ); // повторяет цикл вращения бесконечно
    3. BrickHard brickHard_1 = new BrickHard(x, y, mainStage, false);
    4. brickHard_1.addAction(spinForever_1); // добавляет бесконечное вращение обькту brickHard

 // ВАЖНО - что бы актер вращался вокруг оси, необходимо прописать ему - setOrigin(Align.center); // фиксирует центр обьекта(нужно для вращения вокруг оси)

 ////////////////////////////////////////////////////////////////////////////////////////////

 * */

public class LevelScreen_1 extends LevelScreenMain {

    // чтобы реклама появлялась, обязательно нужно использовать этод конструктор(с параметром requestHandler), в классе
    // MenuScreen
    public LevelScreen_1(IActivityRequestHandler requestHandler) {
        super(requestHandler);
        requestHandler.hideBannerAd(); // при запуске уровня баннер скрывается
    }

    public void initialize() {
        super.initialize();

        showTime(280); // инициализируем метод отображение игрового времени
        //background.loadTexture("background/fon_level.png");
        quantityBricks(100, 7);
        showModalScreen(1, recordsLevel_1, "rules_level_screen/level_screen_1_ru.txt",
                "rules_level_screen/level_screen_1.txt");

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
                if (rowNum == 0 || rowNum == 1 || rowNum == 2 || rowNum == 3 || rowNum == 4 || rowNum == 5) {
                    brick.setColor(Color.RED);
                }
                if (rowNum == 6) {
                    brick.setColor(Color.ORANGE);
                    brick.numberColor = 2;
                }
                if (rowNum == 7) {
                    brick.setColor(Color.YELLOW);
                    brick.numberColor = 3;
                }
                if (rowNum == 8) {
                    brick.setColor(Color.GREEN);
                    brick.numberColor = 4;
                }
                if (rowNum == 9) {
                    brick.setColor(Color.BLUE);
                    brick.numberColor = 5;
                }

            }
        }
        // показывает в Log количество видимых обьектов Brick
        //Gdx.app.log("MyTag", String.valueOf(BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick")));
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            timeIsUp(recordsLevel_1, "records_1"); // инициализируем метод timeIsUp - ВРЕМЯ ВЫШЛО
            RectangleGame.setActiveScreen(new IntermediateScreen(requestHandler, 1, score));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") == 0 && starTimer > 0) {
            allTheBricksAreBroken("records_1");// инициализируем метод allTheBricksAreBroken - ВСЕ КИРПИЧИ РАЗРУШЕНЫ
            RectangleGame.setActiveScreen(new VictoryScreen(requestHandler, "attainmentColorLevelMemory_1"));
        }
        if (BaseActor.count(mainStage, "alex.iv.rect.destroy.actors.Brick") < 8 && starTimer > 0) {
            createAttainment(1);
        }

    }
}
