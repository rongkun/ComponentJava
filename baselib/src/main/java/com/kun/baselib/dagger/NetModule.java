package com.kun.baselib.dagger;


import android.util.Log;

import com.kun.baselib.base.BaseApplication;
import com.kun.baselib.net.NetParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.io.File;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.jakewharton.byteunits.DecimalByteUnit.MEGABYTES;

@Module
public class NetModule {

    private static final int DISK_CACHE_SIZE = (int) MEGABYTES.toBytes(50);

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        Gson gson = new GsonBuilder().create();
        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(NetParams.BASE_URL).build();
    }


    /**
     * client with interceptor
     *
     * @return
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(BaseApplication app) {
        return createOkHttpClient(app).build();
    }


    private static OkHttpClient.Builder createOkHttpClient(BaseApplication app) {
//         Install an HTTP cache in the application cache directory.
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        return new OkHttpClient.Builder().cache(cache).addInterceptor(getLoggingInterceptor());
    }
//截取网络访问信息，打印retrofit日志
    private static HttpLoggingInterceptor getLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("retrofit","retrofit:"+message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}

