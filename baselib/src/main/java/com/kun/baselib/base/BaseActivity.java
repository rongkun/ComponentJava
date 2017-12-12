package com.kun.baselib.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kun.baselib.dagger.AppComponent;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by kun on 2017/4/10
 */

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements BaseActivityView{

    @Inject
    protected T mPresenter;

    protected Context mContext;
    protected final String TAG = "Activity";

    protected abstract void daggerInit();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "CurrentActivity: " + getClass().getSimpleName());
        mContext = this;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //绑定view
        ButterKnife.bind(this);
        daggerInit();
    }

    /**
     * 延时退出
     */
    protected void finishDelay(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }

    @Override
    public LifecycleProvider<ActivityEvent> getLifecycleProvider() {
        return this;
    }

    /**
     * 页面跳转
     * @param activityClass 跳转的Activity
     */
    public void startActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        mContext.startActivity(intent);
    }

    protected AppComponent getAppComponent(){
        return BaseApplication.getAppComponent();
    }

    @Override
    public BaseActivity getActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null) {
            mPresenter.destroyView();
        }
    }
}
