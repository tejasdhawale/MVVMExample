package com.example.tejas.mvvmexample.Network;

import com.example.tejas.mvvmexample.Model.ApiResponse;
import com.example.tejas.mvvmexample.Model.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by webwerks on 16/08/17.
 */

public interface Api {
    String ERROR_TAG = "API_ERROR";



    @GET("/api/unknown")
    Call<ApiResponse> getSampleLoginData();

    @GET("/api/unknown")
    Call<MainResponse> getSampleData();


}
