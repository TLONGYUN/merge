package com.tlong.merge.domain.secondary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjxx_ad")
public class ZjxxAd {

    @Id
    private String id;

    //广告标题
    private String title;

    //图片URL
    private String adpicture;

    //广告视频
    private String advideo;

    //广告内容
    private String adcontent;

    //发布人
    private String username;

    //是否审核
    private Integer checked;

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

    public String getAdpicture() {
        return adpicture;
    }

    public void setAdpicture(String adpicture) {
        this.adpicture = adpicture;
    }

    public String getAdvideo() {
        return advideo;
    }

    public void setAdvideo(String advideo) {
        this.advideo = advideo;
    }

    public String getAdcontent() {
        return adcontent;
    }

    public void setAdcontent(String adcontent) {
        this.adcontent = adcontent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }
}
