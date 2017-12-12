package com.kun.baselib.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * Created by lirongkun on 2017/3/8
 */

public interface BaseActivityView{
    BaseActivity getActivity();
    LifecycleProvider<ActivityEvent> getLifecycleProvider();
}
