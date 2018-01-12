package com.sanke.ilafedoseev.talkchat.DateBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sanke.ilafedoseev.talkchat.Model.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilafedoseev on 06/11/2017.
 */

public class DateFriends extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Friends";
    private static final String TABLE_NAME = "Friends";

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    private static final String TEXT_TYPE = " TEXT";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_NAME + TEXT_TYPE + "," +
                    KEY_EMAIL + TEXT_TYPE + " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DATABASE_NAME;



    public DateFriends(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void addFriend(Friend friend) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,friend.getName());
        values.put(KEY_EMAIL,friend.getEmail());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Friend> getAllFriends() {
        List<Friend> itemList = new ArrayList<Friend>();
        String selectQuery = "SELECT  * FROM " + DATABASE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Friend friend = new Friend();
                friend.setName(cursor.getString(0));
                friend.setEmail(cursor.getString(1));
                itemList.add(friend);
            } while (cursor.moveToNext());
        }

        return itemList;
    }


}