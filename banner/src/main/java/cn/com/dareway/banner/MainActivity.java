package cn.com.dareway.banner;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    int[] pics = new int[]{
            R.mipmap.banner_1, R.mipmap.banner_2, R.mipmap.banner_3
    };

    ViewPager pager;
    BannerAdapter bannerAdapter;
    private Handler mHanler = new Handler();
    int cursor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        bannerAdapter = new BannerAdapter(pics, this);
        pager.setAdapter(bannerAdapter);

        loopBanner();

        changePagerSpeed();
    }


    //自动播放
    private void loopBanner() {
        mHanler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pager.setCurrentItem(cursor % 3);
                cursor ++;
                loopBanner();
            }
        }, 2000);
    }

    //调整播放速度
    private void changePagerSpeed() {
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);

            BannerScroller scroller = new BannerScroller(this);
            scroller.setmDuration(2000);
            field.set(pager, scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
