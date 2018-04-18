package com.example.tejas.mvvmexample;

import android.content.Context;
import android.widget.Toast;

public class LoginViewModel extends BaseViewModel {

    private Context mContext;



    public LoginViewModel(Context context) {
        mContext=context;
    }

    public void callLogin(String email, String pass) {
        Toast.makeText(mContext,"Inside callLogin \n "+email +" \n "+pass,Toast.LENGTH_SHORT).show();
    }

}
