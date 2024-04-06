package com.example.kazanm1.ui.add;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kazanm1.databinding.ItemWellLayerBinding;
import com.example.kazanm1.models.WellLayerItem;
import com.example.kazanm1.models.WellLayerModel;

import java.util.List;

public class AdapterWellLayer extends RecyclerView.Adapter<AdapterWellLayer.ViewHolder> {
    private List<WellLayerItem> list;
    private OnDelete onDelete;

    public AdapterWellLayer(List<WellLayerItem> list, OnDelete onDelete) {
        this.list = list;
        this.onDelete = onDelete;
    }

    public interface OnDelete {
        void onDelete(WellLayerItem wellLayerItem);
    }

    @NonNull
    @Override
    public AdapterWellLayer.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWellLayerBinding binding = ItemWellLayerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWellLayer.ViewHolder holder, int position) {
        holder.Bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemWellLayerBinding binding;

        public ViewHolder(@NonNull ItemWellLayerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(WellLayerItem model) {
            binding.setModel(model);
            binding.remove.setOnClickListener(v -> {
                onDelete.onDelete(model);
                notifyDataSetChanged();
            });
        }
    }
}
