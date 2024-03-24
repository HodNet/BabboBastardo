package com.babbobastardo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.babbobastardo.R;
import com.babbobastardo.ui.editGifters.GiftersActivity;

public class StartScreenActivity extends ParentActivity {
    private Button startButton;
    private ImageView snowFalling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen_activity);

        startButton = findViewById(R.id.startScreen_startButton);
        snowFalling = findViewById(R.id.startScreen_snowFalling);

        startButton.setOnClickListener(v -> goToGiftersActivity());
        startSnowFallingAnimation(snowFalling);
    }

    private void goToGiftersActivity() {
        Intent intent = new Intent(this, GiftersActivity.class);
        startActivity(intent);
    }
}
