package com.example.bakingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.bakingapp.models.Cakes;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.AdapterHolder> {
    public List<Cakes> data;

    public void setCakeData(List<Cakes> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CakeAdapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new AdapterHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder adapterHolder, int i) {
        adapterHolder.bind(data.get(i).image);
        //adapterHolder.bind(data.get(i).name);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        ImageView cakeView;

        public AdapterHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent = new Intent(itemView.getContext(), DetailActivity.class);
                    Cakes cakes = data.get(getAdapterPosition());
                    shareIntent.putExtra(IntentConstants.CAKE_IMAGE, cakes.image);
                    shareIntent.putExtra(IntentConstants.CAKE_NAME, cakes.name);
                    //shareIntent.putExtra(IntentConstants.CAKE_SERVINGS,cakes.servings);
                    itemView.getContext().startActivity(shareIntent);

                }
            });

        }

        public void bind(final String cakeImage) {
            if (!TextUtils.isEmpty(cakeImage)) {
                cakeView = itemView.findViewById(R.id.cakeImage);
                Picasso.get().load("https://d17h27t6h515a5.cloudfront.net" + cakeImage).fit().centerCrop().into(cakeView);
                //cakeView = itemView.findViewById(R.id.cakeNameText);
            }

        }
    }

}
