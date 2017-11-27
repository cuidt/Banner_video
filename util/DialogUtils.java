package com.bwie.banner_video.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.bwie.banner_video.DownloadThread;

/**
 * Created by 崔 on 2017/11/27.
 */

public class DialogUtils {
    public static long MAX_SIZE = 0;
    public static long PROGRESS = -2;
    //  private static File file;
    private static String path;
    public static void showUpdataDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("是否下载")
                .setMessage("下载吧")
                .setNegativeButton("以后再说", null)
                .setPositiveButton("立即下载", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //支持mp4视频播放格式
                        // path= context.getCacheDir() + "/uri=vedio";
                        // new DownloadThread("http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio",
                        // context.getCacheDir() + "/uri=vedio").start();
                        path= context.getCacheDir() + "/911Mothers_2010W-480p.mp4";
                        new DownloadThread("http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4",
                                context.getCacheDir() + "/911Mothers_2010W-480p.mp4").start();
                        showProgress(context);
                    }
                }).show();
    }

    public static interface autopPlay {
        void autopplay(String path);
    }
    public static autopPlay play;
    public static void setPlay(autopPlay autopPlay){
        play=autopPlay;
    };



    public static void showProgress(final Context context){
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle("正在下载");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(100);
        pd.show();

        new AsyncTask<String, Integer, String>(){

            @Override
            protected String doInBackground(String... strings) {

                while (PROGRESS+1 < MAX_SIZE){
                    SystemClock.sleep(100);
                    if (MAX_SIZE>0){
                        publishProgress((int)(PROGRESS * 100 / MAX_SIZE));
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                pd.dismiss();
                play.autopplay(path);

                //  file=new File(context.getCacheDir() + "/911Mothers_2010W-480p.mp4");

                // openApi(context,file);
                Toast.makeText(context,"下载完成",Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                pd.setProgress(values[0]);
            }
        }.execute();
    }
    //安装

    //http://blog.csdn.net/cfy137000/article/details/70257912
//    public static void openApi(Context context, File file){
//        String[] command = {"chmod", "777", file.getPath() };
//        ProcessBuilder builder = new ProcessBuilder(command);
//        try {
//            builder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //隐式跳转
//        Intent intent=new Intent(Intent.ACTION_VIEW);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
//        context.startActivity(intent);
//    }
}
