package com.kun.baselib.base;

/**
 * Created by kun on 2017/8/17.
 */

public class BaseDataCache {
    /**
     * 这里可以存储缓存信息，如用户session等
     */
    private static BaseDataCache instance;

    public static BaseDataCache getInstance() {
        if (instance == null) {
            synchronized (BaseDataCache.class) {
                if (instance == null) {
                    instance = new BaseDataCache();
                }
            }
        }
        return instance;
    }
}
