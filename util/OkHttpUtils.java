package com.bwie.banner_video.util;

import android.os.Handler;

import com.bwie.banner_video.OnUiCallback;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 崔 on 2017/11/27.
 */

public class OkHttpUtils {
    private Handler handler=new Handler();
    public Handler getHandler(){
        return handler;
    }
    private static OkHttpUtils okHttpUtils=new OkHttpUtils();
    private OkHttpUtils(){};
    public static OkHttpUtils getInstance(){
        return okHttpUtils;
    }
    private OkHttpClient client;
    private void initOkHttpClient(){
        if(client==null){
            client=new OkHttpClient().newBuilder().build();
        }
    }
    public void doGet(String url, OnUiCallback callback){
        initOkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Call call=client.newCall(request);
        call.enqueue(callback);
    }


}
