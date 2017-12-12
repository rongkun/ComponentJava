package com.kun.moduleb.dagger;

import com.kun.baselib.dagger.PerActivity;
import com.kun.moduleb.net.BmoduleApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class BmoduleModule {
    @PerActivity
    @Provides
    BmoduleApi providesNetApi(Retrofit retrofit) {
        return retrofit.create(BmoduleApi.class);
    }

}
