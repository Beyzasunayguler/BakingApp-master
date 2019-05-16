package com.example.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakingapp.models.Cakes;
import com.example.bakingapp.models.Ingredient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IngredientAdapter ingredientAdapter;
    private ProgressBar ingredientLoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_class);
        List<Ingredient> ingredients = getIntent().getExtras().getParcelableArrayList(IntentConstants.INGREDIENT);
        recyclerView = (RecyclerView) findViewById(R.id.ingredientRecyclerView);
        ingredientLoadingBar = (ProgressBar) findViewById(R.id.ingredientLoadingBar);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ingredientAdapter = new IngredientAdapter();
        recyclerView.setAdapter(ingredientAdapter);
        ingredientAdapter.setIngredientsData(ingredients);
    }
}
