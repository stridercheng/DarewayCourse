package cn.com.dareway.dwandroidcoursedemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.com.dareway.dwandroidcoursedemo.ui.fragment.ContactFragment;
import cn.com.dareway.dwandroidcoursedemo.ui.fragment.MessageFragment;
import cn.com.dareway.dwandroidcoursedemo.ui.fragment.SpaceFragment;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl_container;
    MessageFragment messageFragment;
    ContactFragment contactFragment;
    SpaceFragment spaceFragment;
    RadioGroup rg_columns;
    RadioButton rb_message;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        fl_container = (FrameLayout) findViewById(R.id.fl_container);

        rg_columns = (RadioGroup) findViewById(R.id.rg_columns);
        rb_message = (RadioButton) findViewById(R.id.rb_message);

        //把信息Fragment填充进来
        messageFragment = MessageFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_container, messageFragment).commit();

        rb_message.setChecked(true);


        rg_columns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.e("MainActivity", "i--->" + i);
                switch (i) {

                    case R.id.rb_message:
                        if (messageFragment == null) {
                            messageFragment = MessageFragment.newInstance();
                        }

                        fragmentManager.beginTransaction().replace(R.id.fl_container, messageFragment).commit();

                        break;
                    case R.id.rb_contact:

                        if (contactFragment == null) {
                            contactFragment = ContactFragment.newInstance();
                        }

                        fragmentManager.beginTransaction().replace(R.id.fl_container, contactFragment).commit();
                        break;
                    case R.id.rb_space:

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
