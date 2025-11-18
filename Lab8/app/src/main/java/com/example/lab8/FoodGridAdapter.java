package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodGridAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Food_BT2> list;

    public FoodGridAdapter(Context context, int layout, ArrayList<Food_BT2> list) {
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

        ImageView img = convertView.findViewById(R.id.imgFoodGrid);
        TextView name = convertView.findViewById(R.id.txtFoodGrid);

        Food_BT2 f = list.get(position);

        img.setImageResource(f.getImage());
        name.setText(f.getName());

        return convertView;
    }
}
