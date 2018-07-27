package com.tlong.merge.domain.secondary;

import javax.persistence.*;

@Entity
@Table(name = "zjxx_news")
public class ZjxxNews {

    @Id
    private String id;

    //标题
    private String title;

    //标题图标
    private String newsicon;

    //简介
    private String newsbrief;

    //内容
    private String ncontent;

    //图片
    private String npicture;

    //视频
    private String nvideo;

    //发布人
    private String username;

    //是否审核
    private String checked;

    //发布时间
    private String newstime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsicon() {
        return newsicon;
    }

    public void setNewsicon(String newsicon) {
        this.newsicon = newsicon;
    }

    public String getNewsbrief() {
        return newsbrief;
    }

    public void setNewsbrief(String newsbrief) {
        this.newsbrief = newsbrief;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public String getNpicture() {
        return npicture;
    }

    public void setNpicture(String npicture) {
        this.npicture = npicture;
    }

    public String getNvideo() {
        return nvideo;
    }

    public void setNvideo(String nvideo) {
        this.nvideo = nvideo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }
}
