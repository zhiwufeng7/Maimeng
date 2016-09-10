package com.qft3.maimeng.util;

import com.qft3.maimeng.bean.ComicRecBean;
import com.qft3.maimeng.lib.UrlLib;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface HttpService {

//    @GET(UrlLib.COMIC_REC_URL)
//    Observable<ComicRecBean> queryComicRec();

    @GET(UrlLib.COMIC_REC_URL)
    Observable<String> queryComicRec();

    @GET(UrlLib.COMIC_REC_URL_AD)
    Observable<String> queryComicRecAd();

//    @GET(UrlLib.HOME_OTHER_URL)
//    Observable<HomeChildBean> queryHomeOther(@Path("id") int id, @Query("offset") int offset);

}
