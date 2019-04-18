package com.example.randomapple.demo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DatabaseHelper dbHelper;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this, "data.db", null, 1);
        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv= findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor1=db.rawQuery("select * from Flower",null);
        if(cursor1.getCount()==0){
            ContentValues values = new ContentValues();
            values.put("type", "1");
            values.put("available", true);
            db.insert("Flower", null, values);
            values.clear();
            values.put("type", "2");
            values.put("available", false);
            db.insert("Flower", null, values);
            values.clear();
        } else {
            Log.d("DB1", "onCreate: exits data");
        }
        Cursor cursor2=db.rawQuery("select * from Record",null);
        if(cursor2.getCount()==0) {
            ContentValues values = new ContentValues();
            values.put("type", "1");
            values.put("end_time", "22");
            values.put("start_time", "22");
            values.put("result", 1);
            values.put("label", "22");
            db.insert("Record", null, values);
            values.clear();
        }else{
            Log.d("DB2", "onCreate: exits data");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch(menuItem.getItemId()){
            case R.id.it_1:
                intent = new Intent(MainActivity.this, DiagramActivity.class);
                startActivity(intent);
                break;
            case R.id.it_2:
                intent = new Intent(MainActivity.this, Timeline.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return false;
    }
}

