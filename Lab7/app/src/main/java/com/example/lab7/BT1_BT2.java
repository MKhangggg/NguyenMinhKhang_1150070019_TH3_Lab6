package com.example.lab7;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BT1_BT2 extends AppCompatActivity {

    Button btnColorSelector, btnDisabledSelector, btnRoundShape, btnShapeGradient, btnSelectorShape;
    Button btnShowToast, btnShowDialog, btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1);

        btnColorSelector = findViewById(R.id.btnColorSelector);
        btnDisabledSelector = findViewById(R.id.btnDisabledSelector);
        btnRoundShape = findViewById(R.id.btnRoundShape);
        btnShapeGradient = findViewById(R.id.btnShapeGradient);
        btnSelectorShape = findViewById(R.id.btnSelectorShape);
        btnShowToast = findViewById(R.id.btnShowToast);
        btnShowDialog = findViewById(R.id.btnShowDialog);
        btnNextPage = findViewById(R.id.btnNextPage);

        btnColorSelector.setOnClickListener(v ->
                show("Bạn bấm: Colored Selector")
        );
        btnDisabledSelector.setOnClickListener(v ->
                show("Nút này đang disabled")
        );
        btnRoundShape.setOnClickListener(v ->
                show("Bạn bấm: Round Shape")
        );
        btnShapeGradient.setOnClickListener(v ->
                show("Bạn bấm: Shape With Gradient")
        );
        btnSelectorShape.setOnClickListener(v ->
                show("Bạn bấm: Selector Shape")
        );
        btnShowToast.setOnClickListener(v -> showCustomToast());
        btnShowDialog.setOnClickListener(v -> showCustomDialog());
        btnNextPage.setOnClickListener(v -> {
            Intent intent = new Intent(BT1_BT2.this, BT3.class);
            startActivity(intent);
        });
    }

    private void show(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toast, null);

        TextView txt = view.findViewById(R.id.txtToast);
        txt.setText("Đây là Custom Toast");

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
    private void showCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        Button btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
