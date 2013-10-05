
package com.gesturetutorial.awesomeness;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class TutorialView extends WebView {

    public static int LeftToRight = 0;
    public static int RightToLeft = 1;
    public static int Pinch = 2;
    public static int UpToDown = 3;
    public static int DownToUp = 4;
    public static int SingleFingerTap = 5;
    public static int DoubleFingerTap = 6;

    private static final String TAG = "TutorialView";

    /*
     * Start an animation corresponding to the given Swipe and Location.
     * @param s A Swipe type you'd like to display to the user.
     * @param l A Location on the screen you want the tutorial to appear.
     */
    public static TutorialView create(final Activity a, final int swipe, final int location,
            final View v)
    {
        final TutorialView tv = new TutorialView(a);

        final FrameLayout fl = new FrameLayout(a);
        fl.addView(tv);

        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        final FrameLayout.LayoutParams rlp = new FrameLayout.LayoutParams(400, 550);
        rlp.height = 400;
        rlp.width = 550;
        // 550 X 400
        rlp.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        // rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, v.getId());
        // rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, v.getId());
        tv.setLayoutParams(rlp);
        ((ViewGroup) v).addView(fl, rlp);

        tv.loadUrl(swipeToAsset(swipe));
        return tv;
    }

    /*
     * Start an animation corresponding to the given Swipe and Location.
     * @param s A Swipe type you'd like to display to the user.
     * @param l A Location on the screen you want the tutorial to appear.
     */
    public static TutorialView create(final Activity a, final int s, final int l,
            final View v, final ViewGroup.LayoutParams lp)
    {
        final TutorialView tv = new TutorialView(a);
        // 550 X 400
        ((ViewGroup) v).addView(tv, lp);
        final String url = "file:///android_asset/" + s;
        tv.loadUrl(url);

        return tv;
    }

    private static String swipeToAsset(final int swipe) {
        String url = "file:///android_asset/";
        switch (swipe)
        {
            case 0:
                url += "LeftToRight.gif";
                break;

            case 1:
                url += "RightToLeft.gif";
                break;

            case 2:
                url += "Pinch.gif";
                break;

            case 3:
                url += "UpToDown.gif";
                break;

            case 4:
                url += "DownToUp.gif";
                break;

            case 5:
                url += "SingleFingerTap.gif";
                break;

            case 6:
                url += "DoubleFingerTap.gif";
                break;
            default:
                url += "test.gif";
                break;

        }
        return url;
    }

    private final Context myContext;

    public TutorialView(final Context context) {
        super(context);
        this.myContext = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public TutorialView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        this.myContext = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public TutorialView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        this.myContext = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public void hide()
    {
        this.setVisibility(View.INVISIBLE);
    }

    public TutorialView show()
    {
        this.setVisibility(View.VISIBLE);
        return this;
    }
}
