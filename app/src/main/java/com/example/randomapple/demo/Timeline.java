package com.example.randomapple.demo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Timeline extends AppCompatActivity {

    private ListView lv;
    private DatabaseHelper dbHelper;
    private ArrayList<Record> records = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        getSupportActionBar().setTitle("Timeline");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new DatabaseHelper(this, "data.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Record", null, null, null,
                null, null, null);
        String startTime, endTime, type, start, end;
        int ifSucceed, imageId=0;

        if (cursor.moveToFirst()) {
            do {
                startTime = cursor.getString(cursor.getColumnIndex
                        ("start_time"));
                endTime = cursor.getString(cursor.getColumnIndex
                        ("end_time"));
                type = cursor.getString(cursor.getColumnIndex("type"));
                ifSucceed = cursor.getInt(cursor.getColumnIndex("result"));

                switch(type){
                    // 这个地方按你们那边补充
                    // replace "" by flowers' name，就是你要存数据库的花的type，如果你们嫌text麻烦
                    // 可以自行换成数字，换的话别忘了把type的数据类型也改了
                    // 你们把图片都放drawable了吧，我们有几个花就几个case，就给imageId赋值
                    case "1":
                        imageId = R.drawable.bluebonnet;//0替换成R.drawable.图片名这种形式
                        break;
                    default:
                        break;
                }

                start = "Start to grow a flower at " + startTime;

                if(ifSucceed == 1){
                    end = "Suceed to grow a " + type +" at " + endTime;
                } else {
                    end = "Growing fail at " + endTime;
                }

                Log.d("DBBBB", "onCreate:"+startTime);

                Record record = new Record(imageId, start, end);
                records.add(record);
            } while (cursor.moveToNext());
        }
        cursor.close();


        MyAdapter adapter = new MyAdapter(this, R.layout.list_layout, records);
        lv = findViewById(R.id.lv_1);
        lv.setAdapter(adapter);
    }
}
