package com.example.bakingapp.api;

import com.example.bakingapp.models.Cakes;
import com.example.bakingapp.models.Ingredient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static String Base_Url = "https://d17h27t6h515a5.cloudfront.net/";

    public static Retrofit getClient() {
        if (retrofit == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit;
        }
        return retrofit;
    }
  private interface CakeService{
        @GET("topher/2017/May/59121517_baking/baking.json")
      Call<List<Cakes>> getCakes(@Path("json") String path);
        Call<List<Ingredient>> getIngredient(@Path("json")String path);
    }
}
