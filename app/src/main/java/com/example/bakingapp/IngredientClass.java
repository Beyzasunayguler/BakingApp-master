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

public class IngredientClass extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IngredientAdapter ingredientAdapter;
    private ProgressBar ingredientLoadingBar;
    @BindView(R.id.ingredientText)
    private TextView ingredientText;
    @BindView(R.id.measureText)
    private TextView measureText;
    @BindView(R.id.quantityText)
    TextView quantityText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_class);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.ingredientRecyclerView);
        ingredientLoadingBar = (ProgressBar) findViewById(R.id.ingredientLoadingBar);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ingredientAdapter = new IngredientAdapter();
        recyclerView.setAdapter(ingredientAdapter);

        if (getIntent().getExtras() == null) {
            Toast.makeText(this, "Something went wrong, check the logs", Toast.LENGTH_LONG).show();
        } else {
            String ingredient = getIntent().getExtras().getString(IntentConstants.INGREDIENT);
            String measure = getIntent().getExtras().getString(IntentConstants.INGREDIENT_MEASURE);
            Double quantity = getIntent().getExtras().getDouble(IntentConstants.INGREDIENT_QUANTITY);
            quantityText.setText(String.valueOf(quantity));
            measureText.setText(measure);
            ingredientText.setText(ingredient);
        }

    }
}
