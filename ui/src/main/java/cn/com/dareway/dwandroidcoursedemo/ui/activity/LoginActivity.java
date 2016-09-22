package cn.com.dareway.dwandroidcoursedemo.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import cn.com.dareway.dwandroidcoursedemo.MainActivity;
import cn.com.dareway.dwandroidcoursedemo.R;

public class LoginActivity extends AppCompatActivity {


    LinearLayout ll_login;
    Button btn_login;
    EditText etUsername, etPassword;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }



        ll_login = (LinearLayout) findViewById(R.id.ll_login);
        btn_login = (Button) findViewById(R.id.btn_login);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);


        sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("username", "");
        String password = sp.getString("password", "");
        if (!"".equals(username)) {
            etUsername.setText(username);
        }

        if (!"".equals(password)) {
            etPassword.setText(password);
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //把账户保存到sp里
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", etUsername.getText().toString());
                editor.putString("password", etPassword.getText().toString());
                editor.apply();


                //跳转页面
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
