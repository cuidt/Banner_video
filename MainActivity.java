package com.bwie.banner_video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bwie.banner_video.adapter.ShowAdapter;
import com.bwie.banner_video.bean.Beans;
import com.bwie.banner_video.presenter.MyPresenter;
import com.bwie.banner_video.util.DialogUtils;
import com.bwie.banner_video.util.OkHttpUtils;
import com.bwie.banner_video.view.Iview;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 *
 *
 */
public class MainActivity extends AppCompatActivity implements Iview {
    private Banner mBan;
    List<String> list = new ArrayList<>();
    private RecyclerView mRecy;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化 Fresco
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        //隐藏标题
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initView();
        okUrlBanner();
        MyPresenter presenter = new MyPresenter(this);
        presenter.loadData();
    }

    private void initView() {
        mBan = (Banner) findViewById(R.id.ban);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        videoView= (VideoView) findViewById(R.id.video_view);
        //创建布局管理器
        LinearLayoutManager ll = new LinearLayoutManager(this);
        mRecy.setLayoutManager(ll);

    }

    //Banner轮播
    private void okUrlBanner() {
        OkHttpUtils.getInstance().doGet(Api.BanUrl, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) throws IOException {
                Gson gson = new Gson();
                Beans beans = gson.fromJson(result, Beans.class);
                for (int i = 0; i < beans.getData().size(); i++) {
                    list.add(beans.getData().get(i).getImage_url());
                }
                mBan.setImageLoader(new Img());
                mBan.setImages(list);
                mBan.start();
            }
        });
    }

    //请求数据
    @Override
    public void setData(List<Beans.DataBean> beanList) {
        //创建适配器
        ShowAdapter showAdapter = new ShowAdapter(MainActivity.this, beanList);
        mRecy.setAdapter(showAdapter);
        //条目点击
        showAdapter.setmOnItemClickListener(new ShowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
              //  Toast.makeText(ShowActivity.this,"点击下载播放",Toast.LENGTH_SHORT).show();
                DialogUtils.showUpdataDialog(MainActivity.this);

                DialogUtils.setPlay(new DialogUtils.autopPlay() {
                    @Override
                    public void autopplay(String path) {
                        //播放视频
                        Uri uri = Uri.parse(path);

                        videoView.setMediaController(new MediaController(MainActivity.this));
                        videoView.setVideoURI(uri);
                        videoView.start();
                        videoView.requestFocus();
                    }
                });
            }
        });
    }
}
