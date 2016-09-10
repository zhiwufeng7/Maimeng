package com.qft3.maimeng.util;

import com.qft3.maimeng.lib.UrlLib;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HttpUtils {

    private static HttpService mHttpService;

//    public static HttpService create() {
//        if (mHttpService == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(UrlLib.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                    .build();
//            mHttpService = retrofit.create(HttpService.class);
//        }
//        return mHttpService;
//    }

    public static HttpService create() {
        if (mHttpService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(UrlLib.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mHttpService = retrofit.create(HttpService.class);
        }
        return mHttpService;
    }
}
