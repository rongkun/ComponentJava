package com.kun.modulea.atest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kun.baselib.base.BaseActivity;
import com.kun.modulea.R;
import com.kun.modulea.dagger.DaggerAmoduleComponent;

public class ATestActivity extends BaseActivity<ATestPresenter> implements ATestContract.View {
    private Button btn;
    @Override
    protected void daggerInit() {
        DaggerAmoduleComponent.builder()
                .appComponent(getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atest );
        mPresenter.attachView(this);
        btn = findViewById(R.id.btnTest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/bmodule/test")
                        .navigation(mContext);
            }
        });
    }
}
