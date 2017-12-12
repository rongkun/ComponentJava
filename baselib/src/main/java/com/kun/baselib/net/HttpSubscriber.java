package com.kun.baselib.net;

import android.util.Log;
import com.kun.baselib.base.BaseResponse;
import com.kun.baselib.utils.ToastUtil;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 将成功之后的操作方法抽象出去，其他方法有默认实现
 */
public abstract class HttpSubscriber<T extends BaseResponse> extends DisposableSubscriber<T> {

    private static final String TAG = "NET";

    @Override
    public void onNext(T t) {
        if (t != null && t.getStatus() == 200) {
            onSuccess(t);
        } else {
            onFail(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof UnknownHostException) {
            toast("请检查您的网络设置");
            noNet();
        } else if (e instanceof SocketTimeoutException) {
            toast("连接超时");
        } else if (e instanceof ConnectException) {
            toast("连接出错");
        }else{
           toast("访问出错");
        }
    }

    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(T t);

    public void onFail(T t) {
        if (t == null) {
            toast("服务器访问失败");
        } else {
            Log.i(TAG,"code:"+t.getStatus());
            toast(t.getMessage());
        }
    }

    public void noNet(){}

    private void toast(final String str){
        ToastUtil.toastShort(str);
    }
}
