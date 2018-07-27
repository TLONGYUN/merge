package com.tlong.merge.domain.secondary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tsign_history")
@DynamicUpdate
public class TsignHistory {

    @Id
    private String id;

    //调用的接口
    private String api;

    //请求的数据
    private String request;

    //返回的数据
    private String response;

    //请求的时间
    private Date reqtime;

    //返回的时间
    private Date restime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getReqtime() {
        return reqtime;
    }

    public void setReqtime(Date reqtime) {
        this.reqtime = reqtime;
    }

    public Date getRestime() {
        return restime;
    }

    public void setRestime(Date restime) {
        this.restime = restime;
    }
}
