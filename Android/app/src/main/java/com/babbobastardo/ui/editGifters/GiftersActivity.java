package com.babbobastardo.ui.editGifters;

import android.os.Bundle;
import android.widget.ImageView;

import com.babbobastardo.R;
import com.babbobastardo.ui.ParentActivity;

public class GiftersActivity extends ParentActivity {
    private ImageView snowFalling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gifters_activity);

        snowFalling = findViewById(R.id.gifters_snowFalling);
        startSnowFallingAnimation(snowFalling);
    }
}
