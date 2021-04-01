package alex.iv.rect.destroy;

import alex.iv.rect.destroy.controller.LevelScreenMain;

public class LevelScreen_6 extends LevelScreenMain {

    public void initialize() {
        super.initialize();
        showTime(10); // инициализируем метод отображение игрового времени
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
           starTimer = 10;
        }

    }

}
