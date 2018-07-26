package com.tlong.merge.domain.primary;

import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity
@Table(name = "tlong_about")
public class TlongAbout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //标题
    private String title;

    //内容
    private String content;

    //上传人名称
    private String userName;

    //上传时间
    private Data publishTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Data getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Data publishTime) {
        this.publishTime = publishTime;
    }
}
