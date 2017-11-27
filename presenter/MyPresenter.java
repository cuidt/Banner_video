package com.bwie.banner_video.presenter;

/**
 * Created by 崔 on 2017/11/27.
 */

import com.bwie.banner_video.bean.Beans;
import com.bwie.banner_video.model.IModel;
import com.bwie.banner_video.view.Iview;
import com.bwie.banner_video.MyModel;

import java.util.List;
import rx.Observer;
public class MyPresenter {
    IModel model;
    Iview view;

    public MyPresenter(Iview view) {
        this.view = view;
        model=new MyModel();
    }

    public void loadData(){
        model.setObSerVer(new Observer<Beans>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                //    Log.i("///", "onError: "+e);
            }

            @Override
            public void onNext(Beans  beans ) {
                List<Beans.DataBean> data = beans.getData();
                //  Log.i("/////", "onNext: "+list.size());
                view.setData(data);

            }
        });
    }
}
