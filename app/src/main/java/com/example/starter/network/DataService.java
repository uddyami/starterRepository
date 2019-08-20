package com.example.starter.network;

import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataService  implements Callback<List<FactModel>> {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://us-central1-avocado-24aa4.cloudfunctions.net/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();
            retrofit = new retrofit2.Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public DataService() {
        GetDataService service = getRetrofitInstance().create(GetDataService.class);
        Call<List<FactModel>> call = service.getAllFacts();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<FactModel>> call, Response<List<FactModel>> response) {
        List<FactModel>  facts =response.body();
        Log.d("DataService"," Response: "+facts);
    }

    @Override
    public void onFailure(Call<List<FactModel>> call, Throwable t) {
        Log.d("DataService"," Response: onFailure" + t.getMessage());

    }
}
