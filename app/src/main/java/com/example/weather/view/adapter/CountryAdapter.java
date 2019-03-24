package com.example.weather.view.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.databinding.ItemCountryBinding;
import com.example.weather.data.model.Country;
import com.example.weather.view.callback.CountryClickCallback;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    List<Country> mCountryList;

    @Nullable
    private final CountryClickCallback countryClickCallback;



    public CountryAdapter(@Nullable CountryClickCallback countryClickCallback) {
        this.countryClickCallback = countryClickCallback;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCountryBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_country,
                        parent, false);

        binding.setCallback(countryClickCallback);

        return new CountryViewHolder(binding);

        }


    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, final int position) {
        holder.binding.setCountry(mCountryList.get(position));
        holder.binding.executePendingBindings();
        holder.binding.setCountryThumb(mCountryList.get(position).getCountryCode());

    }


    public int getItemCount() {
        return mCountryList == null ? 0 : mCountryList.size();
    }



    public void addItems(List<Country> repoList) {
        mCountryList = new ArrayList<>();
        mCountryList.addAll(repoList);
        notifyDataSetChanged();
    }





    public class CountryViewHolder extends RecyclerView.ViewHolder  {


        final ItemCountryBinding binding;


        public CountryViewHolder(ItemCountryBinding binding){
            super(binding.getRoot());
            this.binding = binding;



        }




    }



}
