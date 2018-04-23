package com.example.tejas.mvvmexample.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.tejas.mvvmexample.BaseClass.BaseActivity;
import com.example.tejas.mvvmexample.R;
import com.example.tejas.mvvmexample.ViewModel.MainViewModel;

public class MainActivity extends BaseActivity {

    Context mContext;
    MainViewModel mainViewModel;

    @Override
    protected void onBinding() {

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mBinding.setLifecycleOwner(this);


        mContext = this;
    }

    void FetchData(View view)
    {
        mainViewModel.getUserData().observe(this, o -> {
            if (o != null) {
                Toast.makeText(mContext, "Main Total page is  " + o.getTotal(), Toast.LENGTH_SHORT).show();
            }
        })
 ;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
