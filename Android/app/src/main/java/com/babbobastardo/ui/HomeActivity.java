package com.babbobastardo.ui;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.babbobastardo.R;

public class HomeActivity extends ParentActivity {
    private Button startButton;
    private ImageView snowFalling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        startButton = findViewById(R.id.home_startButton);
        snowFalling = findViewById(R.id.home_snowFalling);

        startButton.setOnClickListener(v -> goToGiftersActivity());
        startSnowFallingAnimation(snowFalling);
    }

    private void goToGiftersActivity() {
        Intent intent = new Intent(this, GiftersActivity.class);
        startActivity(intent);
    }
}
