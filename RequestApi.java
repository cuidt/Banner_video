package com.bwie.banner_video;

import com.bwie.banner_video.bean.Beans;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 崔 on 2017/11/27.
 */

public interface  RequestApi {
    public static final String BASE_URL = "http://result.eolinker.com/";

    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Observable<Beans> getData();
}
