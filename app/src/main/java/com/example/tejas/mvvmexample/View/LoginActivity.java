package com.example.tejas.mvvmexample;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.example.tejas.mvvmexample.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    Context mContext;
    LoginViewModel loginViewModel;
    private String mEmail, mPass;

    @Override
    void onBinding() {
        loginViewModel = new LoginViewModel(this);
        mBinding.setLifecycleOwner(this);
        mContext = this;
        mBinding.email.setText("binding@test.com");
        mBinding.password.setText("password");

    }

    @Override
    int getContentView() {
        return R.layout.activity_login;
    }

    public void login(View v) {
        mEmail=mBinding.email.getText().toString();
        mPass=mBinding.password.getText().toString();

        if (isValid())
            loginViewModel.callLogin(mEmail,mPass);
    }


    private boolean isValid() {
        boolean validate;

        if (!TextUtils.isEmpty(mEmail)) {
            validate= true;
        } else {
            mBinding.email.setError("Please Enter Email");
            mBinding.email.requestFocus();
            validate = false;
        }
        if (!TextUtils.isEmpty(mPass)) {
            validate=true;
        } else {
            validate=false;
            mBinding.password.setError("Please Enter Password");
            mBinding.password.requestFocus();
        }
        return validate;
    }

}

