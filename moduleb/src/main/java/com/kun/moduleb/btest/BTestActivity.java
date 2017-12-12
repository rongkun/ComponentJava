package com.kun.moduleb.btest;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kun.baselib.base.BaseActivity;
import com.kun.moduleb.R;
import com.kun.moduleb.dagger.DaggerBmoduleComponent;

@Route(path = "/bmodule/test")
public class BTestActivity extends BaseActivity<BTestPresenter> implements BTestContract.View {

    @Override
    protected void daggerInit() {
        DaggerBmoduleComponent.builder()
                .appComponent(getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btest);
        mPresenter.attachView(this);
    }
}
