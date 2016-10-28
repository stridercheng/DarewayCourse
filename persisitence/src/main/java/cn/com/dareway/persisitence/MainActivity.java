package cn.com.dareway.persisitence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import cn.com.dareway.persisitence.db.DBManager;
import cn.com.dareway.persisitence.model.Book;

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
        Book book = new Book();
        book.setId(1);
        book.setAuthor("dareway");
        book.setName("book1");
        book.setPages(45);
        book.setPrice(20.04);

        Book book1 = new Book();
        book1.setId(2);
        book1.setAuthor("dareway");
        book1.setName("book2");
        book1.setPages(45);
        book1.setPrice(20.04);

        DBManager dbManager = new DBManager(this);
//        dbManager.insertBook(book);
//        dbManager.insertBookUseSql(book1);
        dbManager.getBooks();
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
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
