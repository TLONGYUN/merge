package com.tlong.merge.domain.secondary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjxx_lesson")
@DynamicUpdate
public class ZjxxLesson {

    @Id
    private String id;

    //课程分类id

    //题目
    private String title;

    //课程目录
    private String lessonindex;

    // 课程讲师
    private String lessonauthor;

    //课程介绍
    private String lessoninfo;

    //课程视频
    private String lessonvideo;

    //课程图片
    private String lessonpicture;

    //当前状态
    private Integer lessonstate;

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

    public String getLessonindex() {
        return lessonindex;
    }

    public void setLessonindex(String lessonindex) {
        this.lessonindex = lessonindex;
    }

    public String getLessonauthor() {
        return lessonauthor;
    }

    public void setLessonauthor(String lessonauthor) {
        this.lessonauthor = lessonauthor;
    }

    public String getLessoninfo() {
        return lessoninfo;
    }

    public void setLessoninfo(String lessoninfo) {
        this.lessoninfo = lessoninfo;
    }

    public String getLessonvideo() {
        return lessonvideo;
    }

    public void setLessonvideo(String lessonvideo) {
        this.lessonvideo = lessonvideo;
    }

    public String getLessonpicture() {
        return lessonpicture;
    }

    public void setLessonpicture(String lessonpicture) {
        this.lessonpicture = lessonpicture;
    }

    public Integer getLessonstate() {
        return lessonstate;
    }

    public void setLessonstate(Integer lessonstate) {
        this.lessonstate = lessonstate;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }
}
