package com.babbobastardo.ui.editGifters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.babbobastardo.R;
import com.babbobastardo.control.EditGiftersController;
import com.babbobastardo.ui.AddGifterActivity;
import com.babbobastardo.ui.ParentActivity;

public class GiftersActivity extends ParentActivity {
    private EditGiftersController editGiftersController;

    private ConstraintLayout giftersAddButton;
    private ImageView giftersDoneButton;
    private RecyclerView giftersRecyclerView;
    private EditableGiftersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gifters_activity);

        editGiftersController = EditGiftersController.getInstance(this);

        giftersAddButton = findViewById(R.id.gifters_addButton);
        giftersRecyclerView = findViewById(R.id.gifters_recyclerView);
        giftersDoneButton = findViewById(R.id.gifters_doneButton);

        giftersAddButton.setOnClickListener(v -> goToAddGiftersActivity());
        giftersDoneButton.setOnClickListener(v -> done());
        giftersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EditableGiftersAdapter(this, editGiftersController.getGifters());
        giftersRecyclerView.setAdapter(adapter);
    }

    private void goToAddGiftersActivity() {
        Intent intent = new Intent(this, AddGifterActivity.class);
        startActivity(intent);
    }

    private void done() {
        editGiftersController.decidiChiRegalare();
        editGiftersController.sendEmails(this);
    }
}