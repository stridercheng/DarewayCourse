package cn.com.dareway.persisitence.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.com.dareway.persisitence.model.Book;

/**
 * Created by Administrator on 2016/10/27.
 */

public class DBManager {
    private final static String TAG = DBManager.class.getSimpleName();
    private DBHelper dbHelper;

    public DBManager(Context context) {
        dbHelper = DBHelper.getInstance(context);
        RoomDBHelper roomDBHelper = new RoomDBHelper(context);
        SQLiteDatabase db = roomDBHelper.getWritableDatabase();
    }

    public void insertBook(Book book) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", book.getId());
        contentValues.put("name", book.getName());
        contentValues.put("author", book.getAuthor());
        contentValues.put("price", book.getPrice());
        contentValues.put("pages", book.getPages());
        db.insert("book", null, contentValues);
    }

    public void insertBookUseSql(Book book) {
        String insert="insert into book(id, name, author, price, pages)" +
                "values(?,?,?,?,?)";
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL(insert, new Object[]{book.getId(), book.getName(), book.getAuthor()
        , book.getPrice(), book.getPages()});

    }

    public List<Book> getBooks() {

        List<Book> bookList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("book", new String[]{"name, author"}, " id = ? ", new String[]{"1"}, null, null, null);
        while (cursor.moveToNext()) {
            Log.e(TAG, "name --->" + cursor.getString(cursor.getColumnIndex("name"))
                    + "author--->" + cursor.getString(cursor.getColumnIndex("author")));
        }
        return bookList;
    }

    public void getBooks2() {
        String query = "select * from book";
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{});
        while (cursor.moveToNext()) {

        }

    }

    public void createDB2() {

    }
}
