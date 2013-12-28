package com.gesturetutorial.awesomeness;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.io.IOException;

public class TutorialView extends WebView implements OnTouchListener {
	static TutorialView instance;

	// Swipe Types.
	final public static int LeftToRight = 0;
	final public static int RightToLeft = 1;
	final public static int Pinch = 2;
	final public static int UpToDown = 3;
	final public static int DownToUp = 4;
	final public static int SingleFingerTap = 5;
	final public static int DoubleFingerTap = 6;
	// Swipe Locations.
	final public static int UpperLeft = 0;
	final public static int UpperCenter = 1;
	final public static int UpperRight = 2;
	final public static int CenterLeft = 3;
	final public static int Center = 4;
	final public static int CenterRight = 5;
	final public static int LowerLeft = 6;
	final public static int LowerCenter = 7;
	final public static int LowerRight = 8;

	private static final String TAG = "TutorialView";

	private static int swipeWidth = 550, swipeHeight = 550;

	/*
	 * Start an animation corresponding to the given Swipe and Location.
	 * 
	 * @param activity A activity we can use.
	 * 
	 * @param swipe A Swipe type you'd like to display to the user.
	 * 
	 * @param location A Location on the screen you want the tutorial to appear.
	 * 
	 * @param view A View that you want to add the tutorial to. You can use
	 * findViewById(android.R.id.content).
	 */
	public static TutorialView create(final Activity activity, final int swipe,
			final int location, final View view) {
		if (instance != null)
			instance.hide();
		instance = new TutorialView(activity);

		final FrameLayout fl = new FrameLayout(activity);
		instance.loadUrl(swipeToAsset(swipe));
		fl.addView(instance, new LinearLayout.LayoutParams(swipeWidth,
				swipeHeight));
		// tv.loadUrl(swipeToAsset(swipe));
		final FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(
				swipeWidth, swipeHeight);
		flp.gravity = locationToGravity(location);
		instance.setLayoutParams(flp);
		((ViewGroup) view).addView(fl, flp);
		// tv.loadUrl(swipeToAsset(swipe));

		// final AssetManager mgr = activity.getAssets();
		// displayFiles(mgr, "");

		return instance;
	}

	static void displayFiles(final AssetManager mgr, final String path) {
		try {
			final String list[] = mgr.list(path);
			if (list != null) {
				for (int i = 0; i < list.length; ++i) {
					Log.v("Assets:", path + "/" + list[i]);
					displayFiles(mgr, path + "/" + list[i]);
				}
			}
		} catch (final IOException e) {
			Log.v("List error:", "can't list" + path);
		}

	}

	private static int locationToGravity(final int location) {
		switch (location) {
		case TutorialView.UpperLeft:
			return Gravity.TOP | Gravity.LEFT;
		case TutorialView.UpperCenter:
			return Gravity.TOP | Gravity.CENTER_HORIZONTAL;
		case TutorialView.UpperRight:
			return Gravity.TOP | Gravity.RIGHT;
		case TutorialView.CenterLeft:
			return Gravity.CENTER_VERTICAL | Gravity.LEFT;
		case TutorialView.Center:
			return Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
		case TutorialView.CenterRight:
			return Gravity.CENTER_VERTICAL | Gravity.RIGHT;
		case TutorialView.LowerLeft:
			return Gravity.BOTTOM | Gravity.LEFT;
		case TutorialView.LowerCenter:
			return Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
		case TutorialView.LowerRight:
			return Gravity.BOTTOM | Gravity.RIGHT;
		default:
			return TutorialView.locationToGravity(TutorialView.Center);
		}
	}

	private static String swipeToAsset(final int swipe) {
		String url = "file:///android_asset/";
		switch (swipe) {
		case TutorialView.LeftToRight:
			swipeWidth = 550;
			swipeHeight = 315;
			url += "lefttoright.gif";
			break;

		case TutorialView.RightToLeft:
			swipeWidth = 550;
			swipeHeight = 307;
			url += "righttoleft.gif";
			break;

		case TutorialView.Pinch:
			Log.e(TAG, "Pinch is not supported!");
			swipeWidth = 0;
			swipeHeight = 0;
			url += "test.gif";
			break;

		case TutorialView.UpToDown:
			swipeWidth = 266;
			swipeHeight = 509;
			url += "uptodown.gif";
			break;

		case TutorialView.DownToUp:
			swipeWidth = 267;
			swipeHeight = 500;
			url += "downtoup.gif";
			break;

		case TutorialView.SingleFingerTap:
			swipeWidth = 267;
			swipeHeight = 318;
			url += "singletap.gif";
			break;

		case TutorialView.DoubleFingerTap:
			swipeWidth = 275;
			swipeHeight = 340;
			url += "doubletap.gif";
			break;
		default:
			swipeWidth = 0;
			swipeHeight = 0;
			url += "test.gif";
			break;

		}
		return url;
	}

	public TutorialView(final Context context) {
		super(context);
		this.init();
	}

	public TutorialView(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		this.init();
	}

	public TutorialView(final Context context, final AttributeSet attrs,
			final int defStyle) {
		super(context, attrs, defStyle);
		this.init();
	}

	public void hide() {
		this.setVisibility(View.INVISIBLE);
		this.clearCache(true);
	}

	private void init() {
		this.setBackgroundColor(Color.TRANSPARENT); // Background color
		this.setInitialScale(1); // Make whole image viewable.
		this.getSettings().setUseWideViewPort(true);
		this.getSettings().setDefaultZoom(ZoomDensity.FAR);
		this.getSettings().setLoadWithOverviewMode(true);

	}

	@Override
	public boolean onTouch(final View arg0, final MotionEvent arg1) {
		return true; // Ignore touches.
	}

	public TutorialView show() {
		this.setVisibility(View.VISIBLE);
		return this;
	}

}
