package com.kun.modulea;

import android.util.Log;

import com.kun.baselib.base.ApplicationImpl;
import com.kun.baselib.base.BaseApplication;

/**
 * @author kun
 * @date 2017/12/11
 */

public class ModuleA implements ApplicationImpl {
    @Override
    public void onCreate(BaseApplication application) {
        Log.i("aaa","AModule");
    }
}
