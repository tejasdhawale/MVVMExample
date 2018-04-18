package com.example.tejas.mvvmexample;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T mBinding;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,getContentView());
        onBinding();
    }

    public void showProgressLoading(String title ,String msg, boolean isCancelable) {
        progressDialog = ProgressDialog.show(this, title, msg);
        progressDialog.setCancelable(isCancelable);
        if(!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    public void stopLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


//    abstract void addViewModel(Context context);
    abstract void onBinding();
    abstract int getContentView();



}
