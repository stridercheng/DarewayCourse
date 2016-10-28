package cn.com.dareway.persisitence.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/28.
 */

public class RoomDBHelper extends SQLiteOpenHelper {
    String sql = "create table room(id integer, name text)";

    public RoomDBHelper(Context context) {
        super(context, "Room.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
