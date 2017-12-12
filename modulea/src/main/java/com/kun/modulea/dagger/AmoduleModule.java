package com.kun.modulea.dagger;

import com.kun.baselib.dagger.PerActivity;
import com.kun.modulea.net.AmoduleApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AmoduleModule {
    @PerActivity
    @Provides
    AmoduleApi providesNetApi(Retrofit retrofit) {
        return retrofit.create(AmoduleApi.class);
    }

}
