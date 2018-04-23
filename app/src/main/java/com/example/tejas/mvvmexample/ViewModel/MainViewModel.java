package com.example.tejas.mvvmexample.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.tejas.mvvmexample.DI.DaggerRetrofitComponent;
import com.example.tejas.mvvmexample.Model.MainResponse;
import com.example.tejas.mvvmexample.Network.Api;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    @Inject
    Api api;

    public MainViewModel() {
        DaggerRetrofitComponent.builder().build().inject(this);
    }

    public MutableLiveData<MainResponse> getUserData() {
        MutableLiveData<MainResponse> mutableLiveData=new MutableLiveData<MainResponse>();
        api.getSampleData().enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
              mutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }

}
