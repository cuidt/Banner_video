package com.bwie.banner_video;

import com.bwie.banner_video.model.IModel;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 崔 on 2017/11/27.
 */

public class MyModel implements IModel {
    @Override
    public void setObSerVer(Observer obSerVer) {
        OkHttpClient okclient = new OkHttpClient.Builder().build();
        //引用封装类

        RetrofitManager.getInstance(RequestApi.BASE_URL,okclient)
                .setCreate(RequestApi.class)
                .getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(obSerVer);


        //未引用封装类
        //        Retrofit retrofit=new Retrofit.Builder()
//                .client(okclient)
//                .baseUrl(Constant.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        URLUtils urlUtils = retrofit.create(URLUtils.class);
//         urlUtils.getObservable()
//                 .subscribeOn(Schedulers.io())
//                 .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(obSerVer);

    }
}
