package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Food> list;

    public FoodAdapter(Context context, int layout, ArrayList<Food> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout, null);

        ImageView img = convertView.findViewById(R.id.imgFood);
        TextView name = convertView.findViewById(R.id.txtFoodName);
        TextView desc = convertView.findViewById(R.id.txtFoodDesc);

        Food f = list.get(position);

        img.setImageResource(f.getImage());
        name.setText(f.getName());
        desc.setText(f.getDescription());

        return convertView;
    }
}
