package com.kun.baselib.utils;

import android.content.Context;
import android.widget.Toast;

import com.kun.baselib.base.BaseApplication;

/**
 * Created by kun on 2015/12/6
 */
public class ToastUtil {
    private static long lastClickTime = 0;
    public static final int MIN_CLICK_DELAY_TIME = 3000;

    public static void toastLong(Context ct, String msg) {
        Toast.makeText(ct, msg, Toast.LENGTH_LONG).show();
    }

    public static void toastShort(Context ct, String msg) {
        Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(Context ct, int StringId) {
        Toast.makeText(ct, StringId, Toast.LENGTH_LONG).show();
    }

    public static void toastShort(Context ct, int StringId) {
        Toast.makeText(ct, StringId, Toast.LENGTH_SHORT).show();
    }

    public static void toastLimit(Context ct, int StringId){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            Toast.makeText(ct, StringId, Toast.LENGTH_SHORT).show();
        }
    }

    public static void toastLimit(Context ct, String msg){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void toastShort(String msg){
        Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastShort(int StringId){
        Toast.makeText(BaseApplication.getContext(), StringId, Toast.LENGTH_SHORT).show();
    }
    /**
     *
     * @param ct 上下文
     * @param time 间隔时间 单位ms
     * @param StringId Stringid
     */
    public static void toastLimit(Context ct,int time, int StringId){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > time) {
            lastClickTime = currentTime;
            Toast.makeText(ct, StringId, Toast.LENGTH_SHORT).show();
        }
    }
    /**
     *
     * @param ct 上下文
     * @param time 间隔时间 单位ms
     * @param msg String
     */
    public static void toastLimit(Context ct,int time, String msg){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > time) {
            lastClickTime = currentTime;
            Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show();
        }
    }

//    public static void toastCenter(Context mContext, String msg){
//        new CenterToast(mContext, msg).showDatePicker();
//    }
//    public static void toastCenter(Context mContext, int StringId){
//        new CenterToast(mContext, mContext.getString(StringId)).showDatePicker();
//    }
//    public static void showToastLongDebug(Context mContext, String msg) {
//        if (!BuildConfig.ISOPEN)
//            Toast.makeText(mContext, "debug:" + msg, Toast.LENGTH_LONG).showDatePicker();
//    }
//
//    public static void showToastShortDebug(Context mContext, String msg) {
//        if (!BuildConfig.ISOPEN)
//            Toast.makeText(mContext, "debug:" + msg, Toast.LENGTH_SHORT).showDatePicker();
//    }
}
