package com.kun.baselib.utils;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lirongkun on 2017/3/9
 */

public class RxHelper {
    /**
     * 将线程调度进行封装，在io线程观察，在主线程订阅
     *
     * @param <T> 当前观察者的类型
     * @return 作为参数用于 {@link Observable#compose(ObservableTransformer)} 中
     */
    public static <T> FlowableTransformer<T, T> io_main() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 将线程调度进行封装，在io线程观察，在computation线程订阅
     *
     * @param <T> 当前观察者的类型
     * @return 作为参数用于 {@link Observable#compose(ObservableTransformer)} 中
     */
    public static <T> FlowableTransformer<T, T> io_computation() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
