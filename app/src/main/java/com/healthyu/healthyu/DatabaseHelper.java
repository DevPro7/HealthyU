package com.healthyu.healthyu.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by qiangli on 4/15/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HealthyU.db";
    /*
    uset_table contains userid, name, password, zipcode, eat, burn, date
    */
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "userid";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    public static final String COL_4 = "zipcode";
    // eat = calories consumed daily
    public static final String COL_5 = "eat";
    // burn = calories burned daily
    public static final String COL_6 = "burn";
    public static final String COL_7 = "date";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // just for checking
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (userid INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password STRING, zipcode TEXT, eat INTEGER, burn INTEGER, date INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
