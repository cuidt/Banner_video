package com.bwie.banner_video.bean;

import java.util.List;

/**
 * Created by 崔 on 2017/11/27.
 */

public class Beans {

    /**
     * code : 200
     * data : [{"content":"习近平举行仪式欢迎加蓬总统访华","id":10000,"image_url":" */
    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 习近平举行仪式欢迎加蓬总统访华
         * id : 10000
         * image_url : http://pic32.nipic.com/20130817/9745430_101836881000_2.jpg
         * title : 今日头条
         * type : 1
         * vedio_url : http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4
         */

        private String content;
        private int id;
        private String image_url;
        private String title;
        private int type;
        private String vedio_url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getVedio_url() {
            return vedio_url;
        }

        public void setVedio_url(String vedio_url) {
            this.vedio_url = vedio_url;
        }
    }
}
