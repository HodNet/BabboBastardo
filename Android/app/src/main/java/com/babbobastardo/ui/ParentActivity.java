package com.babbobastardo.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.babbobastardo.R;

public class ParentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void startSnowFallingAnimation(ImageView snowFalling) {
        snowFalling.setBackgroundResource(R.drawable.snow_falling_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable) snowFalling.getBackground();
        frameAnimation.start();
    }
}
