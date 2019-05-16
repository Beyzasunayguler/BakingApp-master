package com.example.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StepActivity extends AppCompatActivity {
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        descriptionTextView=(TextView) findViewById(R.id.descriptionText);
        String description=getIntent().getExtras().getString(IntentConstants.CAKE_DESCRIPTION);
        descriptionTextView.setText(description);

    }
}
