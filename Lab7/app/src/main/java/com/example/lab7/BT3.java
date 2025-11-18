package com.example.lab7;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BT3 extends AppCompatActivity {

    SeekBar sbR, sbG, sbB;
    TextView txtR, txtG, txtB;
    View viewRGB, viewCMY;

    int r = 0, g = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt3);

        sbR = findViewById(R.id.sbR);
        sbG = findViewById(R.id.sbG);
        sbB = findViewById(R.id.sbB);

        txtR = findViewById(R.id.txtR);
        txtG = findViewById(R.id.txtG);
        txtB = findViewById(R.id.txtB);

        viewRGB = findViewById(R.id.viewRGB);
        viewCMY = findViewById(R.id.viewCMY);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {

                r = sbR.getProgress();
                g = sbG.getProgress();
                b = sbB.getProgress();

                txtR.setText("R: " + r);
                txtG.setText("G: " + g);
                txtB.setText("B: " + b);

                viewRGB.setBackgroundColor(Color.rgb(r, g, b));

                int c = 255 - r;
                int m = 255 - g;
                int y = 255 - b;

                viewCMY.setBackgroundColor(Color.rgb(c, m, y));
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        sbR.setOnSeekBarChangeListener(listener);
        sbG.setOnSeekBarChangeListener(listener);
        sbB.setOnSeekBarChangeListener(listener);
    }
}
