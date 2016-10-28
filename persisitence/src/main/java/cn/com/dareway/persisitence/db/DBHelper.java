package cn.com.dareway.persisitence.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

/**
 * Created by Administrator on 2016/10/27.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper dbHelper;
    String booktable = "create table Book (id integer" +
            " primary key autoincrement," +
            "author text,price real,pages integer,name text)";

    public synchronized static DBHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }

        return dbHelper;
    }

    public DBHelper(Context context) {
//        Environment.getExternalStorageDirectory().getAbsolutePath();
        super(context, "BookStore.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(booktable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
