package com.example.tejas.mvvmexample.BaseClass;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause(){}

}