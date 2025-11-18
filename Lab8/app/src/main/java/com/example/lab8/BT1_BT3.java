package com.example.lab8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BT1_BT3 extends AppCompatActivity {

    Toolbar toolbar;
    ListView lvFood;
    ArrayList<Food> foods;
    FoodAdapter adapter;
    Button btnNext;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1_bt3);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Đồ ăn nhanh Minh Khang");

        lvFood = findViewById(R.id.lvFood);
        btnNext = findViewById(R.id.btnNext);

        foods = new ArrayList<>();
        foods.add(new Food(R.drawable.banh_mi, "Bánh mì", "Món ăn Việt Nam"));
        foods.add(new Food(R.drawable.pho, "Phở", "Món nước truyền thống"));
        foods.add(new Food(R.drawable.tra_sua, "Trà sữa", "Thức uống giới trẻ yêu thích"));

        adapter = new FoodAdapter(this, R.layout.item_food, foods);
        lvFood.setAdapter(adapter);

        registerForContextMenu(lvFood);

        lvFood.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            lvFood.showContextMenu();
        });
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(BT1_BT3.this, BT2.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnAdd) {
            showAddDialog();
            return true;
        }
        if (id == R.id.mnExit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Chọn thao tác");
        menu.add(0, 1, 0, "Sửa");
        menu.add(0, 2, 0, "Xóa");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                showEditDialog();
                break;

            case 2:
                foods.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Đã xóa món ăn", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showAddDialog() {
        View view = getLayoutInflater().inflate(R.layout.dialog_input, null);
        EditText name = view.findViewById(R.id.edtName);
        EditText desc = view.findViewById(R.id.edtDesc);

        new AlertDialog.Builder(this)
                .setTitle("Thêm món ăn")
                .setView(view)
                .setPositiveButton("Thêm", (d, i) -> {
                    foods.add(new Food(R.drawable.banh_mi,
                            name.getText().toString(),
                            desc.getText().toString()));
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }

    private void showEditDialog() {
        View view = getLayoutInflater().inflate(R.layout.dialog_input, null);

        EditText name = view.findViewById(R.id.edtName);
        EditText desc = view.findViewById(R.id.edtDesc);

        Food f = foods.get(selectedIndex);
        name.setText(f.getName());
        desc.setText(f.getDescription());

        new AlertDialog.Builder(this)
                .setTitle("Sửa món ăn")
                .setView(view)
                .setPositiveButton("Lưu", (d, i) -> {
                    f.setName(name.getText().toString());
                    f.setDescription(desc.getText().toString());
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}
