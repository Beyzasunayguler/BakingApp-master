package com.example.bakingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakingapp.api.ApiClient;
import com.example.bakingapp.api.ApiInterface;
import com.example.bakingapp.models.Cakes;
import com.example.bakingapp.models.Ingredient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    private ImageView cakeImage;
    private TextView cakeNameText;
    private Button ingredientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //ButterKnife.bind(this);
        cakeNameText = (TextView) findViewById(R.id.cakeNameText);
        cakeImage = (ImageView) findViewById(R.id.cakeImage);
        ingredientButton=(Button) findViewById(R.id.ingredientButton);
        ingredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IngredientClass.class);
                startActivity(intent);
            }
        });
        //cakeServingsText=(TextView) findViewById(R.id.cakeServingsText);

        if (getIntent().getExtras() == null) {
            Toast.makeText(this, "Something went wrong, check the logs", Toast.LENGTH_LONG).show();
        } else {
            String cakeImage = getIntent().getExtras().getString(IntentConstants.CAKE_IMAGE);
            String cakeName = getIntent().getExtras().getString(IntentConstants.CAKE_NAME);
           // Integer cakeServings= getIntent().getExtras().getInt(IntentConstants.CAKE_SERVINGS);
            cakeNameText.setText(cakeName);
          //  cakeServingsText.setText(String.valueOf(cakeServings));


        }

    }
}
