package cn.com.dareway.persisitence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
//        //File
//        //Sp
//        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("name", "tom");
//        editor.apply();
//
//        SharedPreferences sp1 = getSharedPreferences("spTest", MODE_PRIVATE);
//        SharedPreferences.Editor editor1 = sp1.edit();
//        editor1.putString("name", "zhang");
//        editor1.apply();
//
//        String name = sp1.getString("name", "");
//
//        Toast.makeText(this, "name--->" + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fileTest();
            }
        }).start();
    }



    private void fileTest() {
        try {
            FileOutputStream fos = openFileOutput("test", MODE_PRIVATE);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
            bufferedWriter.write("这是测试数据");
            bufferedWriter.flush();

            final String str = "123";

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv.setText(str);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
