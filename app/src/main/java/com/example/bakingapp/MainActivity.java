package com.example.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bakingapp.api.ApiClient;
import com.example.bakingapp.api.ApiInterface;
import com.example.bakingapp.models.Cakes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CakeAdapter cakeAdapter;
    private ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        loadingBar = (ProgressBar) findViewById(R.id.loadingBar);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        cakeAdapter = new CakeAdapter();
        recyclerView.setAdapter(cakeAdapter);
        ApiInterface mInterface= ApiClient.getClient().create(ApiInterface.class);

            mInterface.getCakes().enqueue(new Callback<List<Cakes>>() {
                @Override
                public void onResponse(Call<List<Cakes>> call, Response<List<Cakes>> response) {
                    cakeAdapter.setCakeData(response.body());
                    loadingBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<List<Cakes>> call, Throwable t) {
                    loadingBar.setVisibility(View.GONE);
                    t.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Something went wrong, check the logs", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
