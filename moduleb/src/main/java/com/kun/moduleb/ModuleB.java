package com.kun.moduleb;

import android.util.Log;

import com.kun.baselib.base.ApplicationImpl;
import com.kun.baselib.base.BaseApplication;

/**
 * @author kun
 * @date 2017/12/11
 */

public class ModuleB implements ApplicationImpl {
    @Override
    public void onCreate(BaseApplication application) {
        Log.i("aaa","BModule");
    }
}
