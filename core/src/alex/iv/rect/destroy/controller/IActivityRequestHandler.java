package alex.iv.rect.destroy.controller;

public interface IActivityRequestHandler {
    void showOrLoadInterstitial(); // показывает межстраничный банер
    void showBannerAd(); // показывает рекламный банер
    void hideBannerAd(); // удаляет рекламный банер
    void showVideoAd();
    boolean hasVideoReward();
}
