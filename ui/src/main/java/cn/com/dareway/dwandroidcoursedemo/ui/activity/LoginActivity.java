package cn.com.dareway.dwandroidcoursedemo.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.com.dareway.dwandroidcoursedemo.MainActivity;
import cn.com.dareway.dwandroidcoursedemo.R;

public class LoginActivity extends AppCompatActivity {


    LinearLayout ll_login;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ll_login = (LinearLayout) findViewById(R.id.ll_login);
        btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        ObjectAnimator.ofFloat(ll_login, "translationY", -600).setDuration(1000).start();
    }
}
