package com.techleadbd.digitaltosbi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txShowId, tv_PlusId, tv_ResetId, tv_MinusId;
    Animation zoom_in, zoom_out, rotate, move_left, move_right, bounch;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txShowId = findViewById(R.id.txShowId);
        tv_PlusId = findViewById(R.id.tv_PlusId);
        tv_ResetId = findViewById(R.id.tv_ResetId);
        tv_MinusId = findViewById(R.id.tv_MinusId);

        zoom_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in);
        zoom_out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_out);
        rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        move_left = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_left);
        move_right = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move_right);
        bounch = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounch);

        tv_PlusId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                txShowId.setText("" + count);
                txShowId.startAnimation(move_right);
                tv_PlusId.startAnimation(zoom_in);
            }
        });

        tv_MinusId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count - 1;
                txShowId.setText("" + count);
                txShowId.startAnimation(move_left);
                tv_MinusId.startAnimation(zoom_out);

            }
        });

        tv_ResetId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                txShowId.setText("" + count);
                txShowId.startAnimation(bounch);
                tv_ResetId.startAnimation(rotate);
            }
        });

    }
}