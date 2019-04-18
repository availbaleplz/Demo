package com.example.randomapple.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_FLOWER = "create table Flower ("
            + "type primary key, "
            + "available boolb)";

    public static final String CREATE_RECORD = "create table Record ("
            + "start_time text, "
            + "type text, "
            + "end_time text, "
            + "result integer, "
            + "label text)";


    private Context mContext;

    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FLOWER);
        db.execSQL(CREATE_RECORD);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Flower");
        db.execSQL("drop table if exists Record");
    }
}
