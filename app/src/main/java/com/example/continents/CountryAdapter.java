package com.example.continents;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Serializable {
    private ArrayList<Country> data1;

    public CountryAdapter(ArrayList<Country> data1) {
        this.data1 = data1;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(data1.get(position).getImage(), data1.get(position).getName(), data1.get(position).getCapital());
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        private ItemCountryBinding binding;

        public CountryViewHolder(@NonNull ItemCountryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int image, String name, String capital) {
            binding.country_image.setImageResource(image);
            binding.country_name.setText(name);
            binding.country_capital.setText(capital);
        }
    }
}
