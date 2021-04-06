package alex.iv.rect.destroy.controller;

public interface IActivityRequestHandler {
    void showOrLoadInterstitial(); // показывает межстраничный банер
    void showBannerAd(); // показывает рекламный банер
    void hideBannerAd(); // скрывает рекламный банер
    void showVideoAd(); // показывает видео рекламу с вознагрождением
    boolean hasVideoReward();
}
