package cn.com.dareway.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.com.dareway.sample.fragment.BlankFragment;
import cn.com.dareway.sample.fragment.ContactFragment;
import cn.com.dareway.sample.fragment.SpaceFragment;

public class MainActivity extends AppCompatActivity {
    BlankFragment blankFragment;
    ContactFragment contactFragment;
    SpaceFragment spaceFragment;
    FrameLayout fl_container;

    RadioGroup rg_bottom;
    RadioButton rb1, rb2, rb3;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_container = (FrameLayout) findViewById(R.id.fl_container);
        rg_bottom = (RadioGroup) findViewById(R.id.rg_bottom);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);

        blankFragment = BlankFragment.newInstance();
        //初始化
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_container, blankFragment).commit();

        rb1.setChecked(true);

        //注册RadioButton事件
        rg_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        fragmentManager.beginTransaction().replace(R.id.fl_container, blankFragment).commit();
                        break;
                    case R.id.rb2:
                        if (contactFragment == null) {
                            contactFragment = ContactFragment.newInstance();
                        }

                        fragmentManager.beginTransaction().replace(R.id.fl_container, contactFragment).commit();
                        break;
                    case R.id.rb3:

                        if (spaceFragment == null) {
                            spaceFragment = SpaceFragment.newInstance();
                        }
                        fragmentManager.beginTransaction().replace(R.id.fl_container, spaceFragment).commit();
                        break;
                }

            }
        });

    }
}
