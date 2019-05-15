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

    public void setIngredientsData (List<Ingredient> data) {
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
     //adapterHolder.bind(ingredients.get(position).ingredient);
     adapterHolder.bind(ingredients.get(position).measure);
     adapterHolder.bind(ingredients.get(position).quantity);



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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent = new Intent(itemView.getContext(), IngredientClass.class);
                    Ingredient ingredient = ingredients.get(getAdapterPosition());
                    shareIntent.putExtra(IntentConstants.INGREDIENT, ingredient.quantity);
                    shareIntent.putExtra(IntentConstants.INGREDIENT_MEASURE, ingredient.measure);
                    shareIntent.putExtra(IntentConstants.INGREDIENT_QUANTITY, ingredient.quantity);
                    itemView.getContext().startActivity(shareIntent);
                }
            });
        }
        public void bind(Double quentity) {
            quantityTextView=itemView.findViewById(R.id.quantityText);
            quantityTextView.setText(String.valueOf(quentity));
        }

        public void bind(String measure) {
            measureTextView=itemView.findViewById(R.id.measureText);
            measureTextView.setText(measure);

        }

    }
}
