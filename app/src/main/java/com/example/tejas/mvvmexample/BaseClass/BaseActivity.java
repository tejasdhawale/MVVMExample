package com.example.tejas.mvvmexample.BaseClass;

import android.app.ProgressDialog;
import android.content.Intent;
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

    public void startActivity(Class c){
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }


//  abstract void addViewModel(Context context);
    protected abstract void onBinding();
    protected abstract int getContentView();



}
