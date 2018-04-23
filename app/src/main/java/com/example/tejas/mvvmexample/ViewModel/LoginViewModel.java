package com.example.tejas.mvvmexample.ViewModel;

import android.arch.lifecycle.MutableLiveData;

import com.example.tejas.mvvmexample.BaseClass.BaseViewModel;
import com.example.tejas.mvvmexample.DI.DaggerRetrofitComponent;
import com.example.tejas.mvvmexample.Model.ApiResponse;
import com.example.tejas.mvvmexample.Network.Api;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends BaseViewModel {

    @Inject
    Api api;

    public LoginViewModel() {
        DaggerRetrofitComponent.builder().build().inject(this);
    }

    public MutableLiveData<ApiResponse> login(String leadId, String code) {

        MutableLiveData<ApiResponse> apiResponseMutableLiveData = new MutableLiveData<ApiResponse>();

        api.getSampleLoginData().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                apiResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                apiResponseMutableLiveData.setValue(null);
            }
        });

        return apiResponseMutableLiveData;

    }

}
