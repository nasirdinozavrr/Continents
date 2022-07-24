package com.example.continents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> implements Serializable {
    private ArrayList<Continent> continents;
    private OnItemClick onItemClick;

    public ContinentAdapter(ArrayList<Continent> continents, OnItemClick onItemClick) {
        this.continents = continents;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.bind(continents.get(position).getImage(), continents.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
            onItemClick.OnItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    class ContinentViewHolder extends RecyclerView.ViewHolder {
        private ItemContinentBinding binding;

        public ContinentViewHolder(@NonNull ItemContinentBinding binding) {
            super(binding.getRoot());

        }

        public void bind(int img, String str) {
            binding.continent_img.setImageResource(img);
            binding.continent_text.setText(str);
        }
    }
}

