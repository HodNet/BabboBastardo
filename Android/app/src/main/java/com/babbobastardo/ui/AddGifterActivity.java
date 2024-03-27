package com.babbobastardo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.babbobastardo.R;
import com.babbobastardo.control.EditGiftersController;
import com.babbobastardo.ui.editGifters.GiftersActivity;
import com.google.android.material.textfield.TextInputEditText;

public class AddGifterActivity extends AppCompatActivity {
    EditGiftersController editGiftersController = EditGiftersController.getInstance(this);

    private TextInputEditText gifterNameEditText;
    private TextInputEditText gifterEmailEditText;
    private ImageView doneButton;

    private TextWatcher gifterTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            editGiftersController.gifterInputChanged(
                    gifterNameEditText.getText().toString(),
                    gifterEmailEditText.getText().toString()
            );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gifter_activity);

        gifterNameEditText = findViewById(R.id.addGifter_name);
        gifterEmailEditText = findViewById(R.id.addGifter_email);
        doneButton = findViewById(R.id.addGifter_doneButton);

        gifterNameEditText.addTextChangedListener(gifterTextWatcher);
        gifterEmailEditText.addTextChangedListener(gifterTextWatcher);

        //OBSERVE FORM STATE
        editGiftersController.getGifterFormState().observe(this, gifterFormState -> {
            if (gifterFormState == null) {
                return;
            }

            if (gifterFormState.isDataValid()) {
                doneButton.setEnabled(true);
                doneButton.setColorFilter(getResources().getColor(R.color.colorPrimary, null));
            } else {
                doneButton.setEnabled(false);
                doneButton.setColorFilter(getResources().getColor(R.color.gray, null));
                if (gifterFormState.getNameError() != null) {
                    gifterNameEditText.setError(gifterFormState.getNameError());
                }
                if (gifterFormState.getEmailError() != null) {
                    gifterEmailEditText.setError(gifterFormState.getEmailError());
                }
            }
        });

        //DONE BUTTON
        doneButton.setOnClickListener(v -> {
            String name = gifterNameEditText.getText().toString();
            String email = gifterEmailEditText.getText().toString();
            editGiftersController.addGifter(name, email);
            Toast.makeText(this, "Gifter added", Toast.LENGTH_SHORT).show();
            goToGiftersActivity();
        });
    }

    private void goToGiftersActivity() {
        Intent intent = new Intent(this, GiftersActivity.class);
        startActivity(intent);
    }
}
