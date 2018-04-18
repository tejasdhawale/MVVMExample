package com.example.tejas.mvvmexample.ViewModel;

import android.content.Context;
import android.os.Handler;

import com.example.tejas.mvvmexample.BaseClass.BaseViewModel;
import com.example.tejas.mvvmexample.eventbus.Event;
import com.example.tejas.mvvmexample.eventbus.EventBusUtil;
import com.example.tejas.mvvmexample.eventbus.EventCodes;


public class LoginViewModel extends BaseViewModel {

    private Context mContext;


//    public LoginViewModel(Context context) {
//        mContext = context;
//    }

    public boolean callLogin(final String email, String pass)
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                EventBusUtil.sendEvent(new Event(EventCodes.EventCode.login));
                // Do something after 5s = 5000ms

            }
        }, 5000);
        return true;
    }



}
