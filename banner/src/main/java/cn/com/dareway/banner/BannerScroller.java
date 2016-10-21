package cn.com.dareway.banner;

import android.content.Context;
import android.widget.Scroller;

/**
 * Created by Administrator on 2016/10/21.
 */

public class BannerScroller extends Scroller {
    private int mDuration = 1500;


    public BannerScroller(Context context) {
        super(context);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    public void setmDuration(int time) {
        mDuration = time;
    }
}
