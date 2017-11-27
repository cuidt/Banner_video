package com.bwie.banner_video;

/**
 * Created by 崔 on 2017/11/27.
 */

public class DownloadTask extends Thread {
    String downloadUrl;
    String path;
    int blockSize;
    int startPosition;

    public DownloadTask(String downloadUrl, String path, int blockSize, int startPosition) {
        this.downloadUrl = downloadUrl;
        this.path = path;
        this.blockSize = blockSize;
        this.startPosition = startPosition;
    }

    @Override
    public void run() {
        NetUtils.downloadFile(downloadUrl,path,blockSize,startPosition);
    }
}
