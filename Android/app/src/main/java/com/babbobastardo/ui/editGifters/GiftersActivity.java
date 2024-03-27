package com.babbobastardo.ui.editGifters;

import android.os.Bundle;
import android.widget.ImageView;

import com.babbobastardo.R;
import com.babbobastardo.ui.ParentActivity;

public class GiftersActivity extends ParentActivity {
    private ImageView snowFalling;
    private ImageView doneBUtton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gifters_activity);


        snowFalling = findViewById(R.id.gifters_snowFalling);
        doneButton =findViewById(gifters_doneButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

        startSnowFallingAnimation(snowFalling);
    }
}
