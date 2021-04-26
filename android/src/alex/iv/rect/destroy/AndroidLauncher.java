package alex.iv.rect.destroy;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import alex.iv.rect.destroy.controller.IActivityRequestHandler;
import alex.iv.rect.destroy.controller.RectangleGame;
import alex.iv.rect.destroy.controller.StartScreen;

import static alex.iv.rect.destroy.controller.MenuScreen.pref;
import static alex.iv.rect.destroy.controller.StartScreen.live;

public class AndroidLauncher extends AndroidApplication implements IActivityRequestHandler {

    private static final String APP_ID="ca-app-pub-XXXXXX~XXXXX"; // ID приложения
	private static final String adUnitId="ca-app-pub-3940256099942544/6300978111"; // ID для баннера
    private static final String AD_UNIT_ID_INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712"; // ID для межстраничного банера
    private static final String AD_UNIT_ID="ca-app-pub-3940256099942544/5224354917"; // ID для видео-рекламы
	public AdView adView; // переменная, которая хранит рекламный баннер
	public InterstitialAd interstitialAd; // переменная, которая хранит межстраничный баннер
	public RewardedVideoAd mAd; // переменная, которая хранит видео-рекламу
	public boolean isRewardLoaded;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		RelativeLayout layout = new RelativeLayout(this);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		layout.setLayoutParams(params);
		View gameView=initializeForView(new RectangleGame(this), config);

		// инициализация баннерной рекламы
		RelativeLayout.LayoutParams gameViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		gameViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		gameViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		gameView.setLayoutParams(gameViewParams);
		layout.addView(gameView);
		adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId(adUnitId);
		RelativeLayout.LayoutParams topParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		topParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
		topParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		layout.addView(adView, topParams);
		adView.setBackgroundColor(android.graphics.Color.TRANSPARENT);
		setContentView(layout);
        // инициализация баннерной рекламы(конец)

        // инициализация межстраничной рекламы
		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);
		interstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {}

			@Override
			public void onAdClosed() {
				loadIntersitialAd();
			}
		});

		loadIntersitialAd();
        // инициализация межстраничной рекламы(конец)

		// инициализация видео рекламы с вознагрождением
		MobileAds.initialize(this, APP_ID);
		mAd = MobileAds.getRewardedVideoAdInstance(this);
		mAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
			@Override
			public void onRewardedVideoAdLoaded() {
				isRewardLoaded =true;
			}

			@Override
			public void onRewardedVideoAdOpened() {

			}

			@Override
			public void onRewardedVideoStarted() {

			}

			@Override
			public void onRewardedVideoAdClosed() {
				loadRewardedVideoAd();
			}

			// метод, в котором нужно прописать вознагрождение, которое нужно за просмотр рекламы
			@Override
			public void onRewarded(RewardItem rewardItem) {
				loadRewardedVideoAd();
				live += 1; // если посмотрел рекламу, добавится 2 жизни
				pref.putInteger("liveMemory", live);
				pref.flush();
			}

			@Override
			public void onRewardedVideoAdLeftApplication() {

			}

			@Override
			public void onRewardedVideoAdFailedToLoad(int i) {

			}

//			@Override
//			public void onRewardedVideoCompleted() {
//
//			}
		});
		loadRewardedVideoAd();
        // инициализация видео рекламы с вознагрождением(конец)

	}

    // метод, который показывает рекламный баннер
    @Override
    public void showBannerAd() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adView.setVisibility(View.VISIBLE);
                AdRequest.Builder builder = new AdRequest.Builder();
                AdRequest ad = builder.build();
                adView.loadAd(ad);
            }
        });
    }

    // метод, который скрывает рекламный баннер
    @Override
    public void hideBannerAd() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adView.setVisibility(View.INVISIBLE);
            }
        });
    }

	private void loadRewardedVideoAd() {
		isRewardLoaded=false;
		mAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
	}

	private void loadIntersitialAd(){
		AdRequest interstitialRequest = new AdRequest.Builder().build();
		interstitialAd.loadAd(interstitialRequest);
	}

	// метод, который загружает межстраничную рекламу
	@Override
	public void showOrLoadInterstitial() {

		runOnUiThread(new Runnable() {
			public void run() {
				if (interstitialAd.isLoaded())
					interstitialAd.show();
				else
					loadIntersitialAd();
			}
		});
	}

	// метод, который загружает видео-рекламу с вознагрождерием(вознагрождение прописывается в методе onRewarded)
	@Override
	public void showVideoAd(){
		runOnUiThread(new Runnable() {
			public void run() {

				if (mAd.isLoaded()) {
					mAd.show();
				} else {
					loadRewardedVideoAd();
				}
			}
		});
	}

	@Override
	public boolean hasVideoReward(){

		return isRewardLoaded;
		//return mAd.isLoaded();    // -> must be called on the main UI thread.
	}

    @Override
    protected void onResume() {
        super.onResume();
        adView.resume();
        mAd.resume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        adView.pause();
        mAd.pause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adView.destroy();
        mAd.destroy(this);
    }
}

// инструкция по показу рекламы
// - в классе, котором будем показывать рекламу создаем переменную requestHandler
// private IActivityRequestHandler requestHandler; // переменная для ссылки на метод из AndroidLauncher(showOrLoadInterstitial()) - для вызова метода, который показывает рекламу
// - нужно в этом классе создать конструктор
// public NameClass(IActivityRequestHandler requestHandler) { // конструктор, который создает саму ссылку на метод showOrLoadInterstitial из AndroidLauncher
//    this.requestHandler = requestHandler;
// }
// - чтобы requestHandler стал обьектом, и через него можно было вызвать методы показа рекламы, нужно гдето создать екземпляр класса NameClass с параметром requestHandler
// nameClass = new NameClass(requestHandler);
// - далее, в нужном месте вызываем нужный метод показа рекламы
// requestHandler.showBannerAd(); // показывает рекламный баннер
// requestHandler.showOrLoadInterstitial(); // показывает межстраничный баннер
// requestHandler.showVideoAd(); // показывает видео рекламу с вознагрождением
// requestHandler.hideBannerAd(); // скрывает рекламный баннер
// Примеры находятся в классах LevelScreenMain and LevelScreen_6