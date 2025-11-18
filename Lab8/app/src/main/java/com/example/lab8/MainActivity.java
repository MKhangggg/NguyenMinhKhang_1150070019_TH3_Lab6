package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProducts;
    TextView txtSelected;
    ArrayList<Product> products;
    MyListViewAdapter adapter;
    Button btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProducts = findViewById(R.id.lvProducts);
        txtSelected = findViewById(R.id.txtSelected);
        btnNextPage = findViewById(R.id.btnNextPage);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.icon_android, "Android", "Hệ điều hành của Google"));
        products.add(new Product(R.drawable.icon_ios, "iOS", "Hệ điều hành của Apple"));
        products.add(new Product(R.drawable.icon_windows, "Windows Phone", "Hệ điều hành Microsoft"));

        adapter = new MyListViewAdapter(
                MainActivity.this,
                R.layout.row_item,
                products
        );
        btnNextPage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BT1_BT3.class);
            startActivity(intent);
        });
        lvProducts.setAdapter(adapter);

        lvProducts.setOnItemClickListener((parent, view, position, id) -> {
            Product p = products.get(position);
            txtSelected.setText("Bạn chọn: " + p.getTitle());
        });
    }
}
