package com.kun.baselib.dagger;

import com.kun.baselib.base.BaseApplication;
import com.kun.baselib.base.BaseDataCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kun on 16/10/10
 */

@Module
public class AppModule {
    private BaseApplication baseApplication;

    public AppModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    @Provides
    @Singleton
    BaseApplication providesApplication() {
        return baseApplication;
    }

    @Provides
    @Singleton
    BaseDataCache provideDataCache(){return BaseDataCache.getInstance();}
}
