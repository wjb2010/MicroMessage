package com.example.dllo.micromessage.Main.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by dllo on 16/10/31.
 */

public class DB_Helper extends SQLiteOpenHelper{

    private Context context;


    public DB_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DBValues.TABLE_NAME+"("+"id integer primary key autoincrement,"+DBValues.NAME+" text,"+DBValues.NUMBER+" text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
