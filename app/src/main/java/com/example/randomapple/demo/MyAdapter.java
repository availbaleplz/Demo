package com.example.randomapple.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.randomapple.demo.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Record> {

    private int resourceId;

    public MyAdapter(Context context, int resource, List<Record> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Record record = getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                false);
        ImageView image = view.findViewById(R.id.iv_1);
        TextView tv1 = view.findViewById(R.id.tv_1);
        TextView tv2 = view.findViewById(R.id.tv_2);
        image.setImageResource(record.getImageId());
        tv1.setText(record.getStart());
        tv2.setText(record.getEnd());
        return view;
    }
}
