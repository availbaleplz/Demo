package com.example.randomapple.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.randomapple.demo.R;

public class DiagramActivity extends AppCompatActivity {

    private RadioGroup rg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagram);

        getSupportActionBar().setTitle("Focus Time");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rg = findViewById(R.id.rg_1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                switch(rb.getId()) {
                    case R.id.rb_d:
                        break;
                    case R.id.rb_w:
                        break;
                    case R.id.rb_m:
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
