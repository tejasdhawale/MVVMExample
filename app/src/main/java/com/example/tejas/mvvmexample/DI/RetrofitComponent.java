package com.example.tejas.mvvmexample.DI;

import com.example.tejas.mvvmexample.ViewModel.LoginViewModel;
import com.example.tejas.mvvmexample.ViewModel.MainViewModel;

import dagger.Component;

/**
 * Created by webwerks on 16/08/17.
 */
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {

    void inject(LoginViewModel dependent);

    void inject(MainViewModel dependent);

}