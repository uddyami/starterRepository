package com.example.starter.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/webApi/api/v1/facts" )
    Call<List<FactModel>> getAllFacts();
}
