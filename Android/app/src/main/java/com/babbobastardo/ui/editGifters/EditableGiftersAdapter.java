package com.babbobastardo.ui.editGifters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.babbobastardo.R;
import com.babbobastardo.model.Gifter;

import java.util.List;

public class EditableGiftersAdapter extends RecyclerView.Adapter<EditableGifterHolder> {

    private List<Gifter> giftersList;
    private Context context;

    public EditableGiftersAdapter(Context context, List<Gifter> giftersList) {
        this.context = context;
        this.giftersList = giftersList;
    }

    @NonNull
    @Override
    public EditableGifterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gifter_item, parent, false);
        return new EditableGifterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditableGifterHolder holder, int position) {
        Gifter gifter = giftersList.get(position);
        holder.bind(context, gifter);
    }

    @Override
    public int getItemCount() {
        return giftersList.size();
    }
}
