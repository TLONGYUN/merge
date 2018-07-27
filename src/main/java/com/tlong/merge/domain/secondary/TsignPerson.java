package com.tlong.merge.domain.secondary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tsign_person")
public class TsignPerson {

    @Id
    private String id;

    //人员id
    private String peopleid;

    //真实姓名
    private String realname;

    //身份证号
    private String idcard;

    //银行卡号
    private String bank;

    //手机号
    private String phone;

    //服务id
    private String serviceid;

    //时间
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(String peopleid) {
        this.peopleid = peopleid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
