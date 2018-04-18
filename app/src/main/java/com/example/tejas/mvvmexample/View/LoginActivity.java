package com.example.tejas.mvvmexample.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.tejas.mvvmexample.BaseClass.BaseActivity;
import com.example.tejas.mvvmexample.R;
import com.example.tejas.mvvmexample.ViewModel.LoginViewModel;
import com.example.tejas.mvvmexample.databinding.ActivityLoginBinding;
import com.example.tejas.mvvmexample.eventbus.Event;
import com.example.tejas.mvvmexample.eventbus.EventBusUtil;
import com.example.tejas.mvvmexample.eventbus.EventCodes;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    Context mContext;
    LoginViewModel loginViewModel;
    private String mEmail, mPass;


    @Override
    protected void onBinding() {
//        loginViewModel = new LoginViewModel(this);

        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        mBinding.setViewModel(loginViewModel);
        mBinding.setLifecycleOwner(this);
        mContext = this;
        mBinding.email.setText("binding@test.com");
        mBinding.password.setText("p@ssw0rd");
        EventBusUtil.register(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    public void login(View v) {
        mEmail = mBinding.email.getText().toString();
        mPass = mBinding.password.getText().toString();

        if (isValid())
            showProgressLoading("loggin in ", "please wait..", false);
        if (loginViewModel.callLogin(mEmail, mPass)) {
            stopLoading();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Event event) {
        if (event != null) {
            if(event.getCode()== EventCodes.EventCode.login);
            {
                Toast.makeText(mContext,"logged In nigga !",Toast.LENGTH_SHORT).show();
                startActivity(MainActivity.class);
            }
        }
    }


    private boolean isValid() {
        boolean validate;

        if (!TextUtils.isEmpty(mEmail)) {
            validate = true;
        } else {
            validate = false;
            mBinding.email.setError("Please Enter Email");
            mBinding.email.requestFocus();

        }
        if (!TextUtils.isEmpty(mPass)) {
            validate = true;
        } else {
            validate = false;
            mBinding.password.setError("Please Enter Password");
            mBinding.password.requestFocus();
        }
        return validate;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }
}

