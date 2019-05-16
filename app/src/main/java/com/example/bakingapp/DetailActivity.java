package com.example.bakingapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakingapp.models.Ingredient;
import com.example.bakingapp.models.Step;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private TextView cakeNameText;
    private Button ingredientButton;
    private RecyclerView recyclerView;
    private List<Ingredient> ingredients;
    private StepAdapter stepAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        List<Step> steps = getIntent().getExtras().getParcelableArrayList(IntentConstants.CAKE_STEPS);
        recyclerView = (RecyclerView) findViewById(R.id.stepRecyclerView);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        stepAdapter = new StepAdapter();
        recyclerView.setAdapter(stepAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        stepAdapter.setStepData(steps);
        cakeNameText = (TextView) findViewById(R.id.cakeNameText);
        ingredientButton = (Button) findViewById(R.id.ingredientButton);
        ingredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IngredientActivity.class);
                intent.putParcelableArrayListExtra(IntentConstants.INGREDIENT, (ArrayList<? extends Parcelable>) ingredients);
                startActivity(intent);
            }
        });


        if (getIntent().getExtras() == null) {
            Toast.makeText(this, "Something went wrong, check the logs", Toast.LENGTH_LONG).show();
        } else {
            String cakeName = getIntent().getExtras().getString(IntentConstants.CAKE_NAME);
            // List<Step> steps = getIntent().getExtras().getParcelableArrayList(IntentConstants.CAKE_STEPS);
            ingredients = getIntent().getExtras().getParcelableArrayList(IntentConstants.INGREDIENT);
            cakeNameText.setText(cakeName);

        }

    }
}
