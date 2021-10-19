package com.example.mynewsapp;



public class NEWS {
    public   String title;
    public   String desc;
    public String content;
    public   String img;
    public   String publish;
    public   String url;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NEWS(String title, String desc, String img, String publish,String content,String url) {
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.publish = publish;
        this.content = content;
        this.url = url;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDesc() {
//        return desc;
//    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
}
