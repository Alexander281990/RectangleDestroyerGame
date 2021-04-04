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

public class AndroidLauncher extends AndroidApplication implements IActivityRequestHandler {

	private static final String adUnitId="ca-app-pub-3940256099942544/6300978111";
	private AdView adView;
	private static final String AD_UNIT_ID_INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712";
	private InterstitialAd interstitialAd;
	private static final String APP_ID="ca-app-pub-XXXXXX~XXXXX";
	private static final String AD_UNIT_ID="ca-app-pub-3940256099942544/5224354917";
	private RewardedVideoAd mAd;
	private boolean isRewardLoaded;



	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		RelativeLayout layout = new RelativeLayout(this);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		layout.setLayoutParams(params);

		View gameView=initializeForView(new RectangleGame(this), config);

		RelativeLayout.LayoutParams gameViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		gameViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		gameViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);

		gameView.setLayoutParams(gameViewParams);
		layout.addView(gameView);

		adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId(adUnitId);

		//AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
		//adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
		//adView.loadAd(adRequestBuilder.build());

		RelativeLayout.LayoutParams topParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		topParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
		topParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		layout.addView(adView, topParams);
		adView.setBackgroundColor(android.graphics.Color.TRANSPARENT);

		setContentView(layout);
//////////////////////////////////////////////////////////////////////
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

		//////////////////////////////////////////////

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

			@Override
			public void onRewarded(RewardItem rewardItem) {

				// call rewards method from here.
				loadRewardedVideoAd();  // Load for next Reward Point
				StartScreen.live += 2;
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
	}

	private void loadRewardedVideoAd() {
		isRewardLoaded=false;
		mAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
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

	////////////////////////////////////

	private void loadIntersitialAd(){

		AdRequest interstitialRequest = new AdRequest.Builder().build();
		interstitialAd.loadAd(interstitialRequest);
	}

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

	@Override
	public void hideBannerAd() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				adView.setVisibility(View.INVISIBLE);
			}
		});
	}

	//////////////////////////////////

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
}