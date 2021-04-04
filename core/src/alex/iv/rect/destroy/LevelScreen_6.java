package alex.iv.rect.destroy;

import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.LevelScreenMain;

public class LevelScreen_6 extends LevelScreenMain {

    public IActivityRequestHandler requestHandler;

    public LevelScreen_6(IActivityRequestHandler requestHandler){
        this.requestHandler=requestHandler;
        requestHandler.showBannerAd(); // при запуске LevelScreen_6 запускается рекламный банер в нижней части экрана
    }

    private boolean b;

    public void initialize() {
        super.initialize();
        showTime(10); // инициализируем метод отображение игрового времени
        b = true;
    }

    public void update(float dt) {
        super.update(dt);

        if (starTimer < 0) {
            b = false;
        }

        if (b == false) {
            requestHandler.showOrLoadInterstitial();
//            requestHandler.showBannerAd();
        }

    }

}
