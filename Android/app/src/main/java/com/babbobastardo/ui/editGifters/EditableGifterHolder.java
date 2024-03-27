package com.babbobastardo.ui.editGifters;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.babbobastardo.R;
import com.babbobastardo.model.Gifter;
import com.babbobastardo.tools.PopupGeneratorOf;

import java.util.concurrent.ExecutionException;

public class EditableGifterHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView emailTextView;
    private ImageButton editButton;
    private ImageButton deleteButton;

    public EditableGifterHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.editableGifter_name);
        emailTextView = itemView.findViewById(R.id.editableGifter_email);
        editButton = itemView.findViewById(R.id.editableGifter_editButton);
        deleteButton = itemView.findViewById(R.id.editableGifter_deleteButton);
    }

    public void bind(Context context, Gifter gifter) {
        nameTextView.setText(gifter.getName());
        emailTextView.setText(gifter.getEmail());
        editButton.setOnClickListener(v -> editGifter(context, gifter));
        deleteButton.setOnClickListener(v -> PopupGeneratorOf.areYouSureToDeleteGifterPopup(context, gifter));
    }

    private void editGifter(Context context, Gifter gifter) {
        //TODO
    }
}

