package com.example.bakingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bakingapp.models.Ingredient;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.AdapterHolder> {
    public List<Ingredient> ingredients;

    public void setIngredientsData(List<Ingredient> data) {
        this.ingredients = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredients_list_item, viewGroup, false);
        return new IngredientAdapter.AdapterHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder adapterHolder, int position) {
        adapterHolder.bind(ingredients.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredients == null ? 0 : ingredients.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView quantityTextView;
        TextView ingredientText;
        TextView measureTextView;

        public AdapterHolder(@NonNull final View itemView) {
            super(itemView);
            quantityTextView = itemView.findViewById(R.id.quantityText);
            ingredientText = itemView.findViewById(R.id.ingredientText);
            measureTextView = itemView.findViewById(R.id.measureText);

        }

        public void bind(Ingredient ıngredient) {
            quantityTextView.setText(String.valueOf(ıngredient.quantity));
            ingredientText.setText(ıngredient.ingredient);
            measureTextView.setText(ıngredient.measure);
        }
    }
}
