package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class BT2 extends AppCompatActivity {

    GridView gridFood;
    ArrayList<Food> foods;
    FoodGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt2);

        gridFood = findViewById(R.id.gridFood);

        ArrayList<Food_BT2> foods;

        foods = new ArrayList<>();
        foods.add(new Food_BT2(R.drawable.banh_mi, "Bánh mì"));
        foods.add(new Food_BT2(R.drawable.pho, "Phở"));
        foods.add(new Food_BT2(R.drawable.tra_sua, "Trà sữa"));

        foods.add(new Food_BT2(R.drawable.banh_mi, "Bánh mì đặc biệt"));
        foods.add(new Food_BT2(R.drawable.pho, "Phở bò tái"));
        foods.add(new Food_BT2(R.drawable.tra_sua, "Trà sữa trân châu"));

        adapter = new FoodGridAdapter(
                BT2.this,
                R.layout.item_food_grid,
                foods
        );

        gridFood.setAdapter(adapter);

        gridFood.setAdapter(adapter);
    }
}
