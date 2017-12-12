package com.kun.moduleb.net;

import com.kun.baselib.base.BaseResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kun on 2017/8/14.
 */

public interface BmoduleApi {
    @GET("open/api/weather/json.shtml?")
    Flowable<BaseResponse<String>> getWeather(@Query("city") String city);
}
